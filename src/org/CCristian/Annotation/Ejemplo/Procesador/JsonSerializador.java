package org.CCristian.Annotation.Ejemplo.Procesador;

import org.CCristian.Annotation.Ejemplo.Init;
import org.CCristian.Annotation.Ejemplo.JsonAtributo;
import org.CCristian.Annotation.Ejemplo.Procesador.Exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

/*------------------MÉTODO------------------*/
    public static void inicializar_Objeto(Object object){   /*Inicializa el método marcado con la anotación @Init*/
        if (Objects.isNull(object)){    /*Excepción personalizada*/
            throw new JsonSerializadorException("El objeto a serializar NO puede ser null !!! ಠ益ಠ ");
        }
        Method[] methods = object.getClass().getDeclaredMethods();    /*Procesando las anotaciónes del objeto*/
        /*Devuelve un array de objetos Method que representan todos los métodos declarados en la clase, incluidos los métodos privados.*/
        Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(Init.class)) /*Filtra los campos que tengan presente la anotación @Init*/
                .forEach(m -> {
                    m.setAccessible(true);
                    try {
                        m.invoke(object);   /*Invoca el método por cada método que tenga la anotación @Init*/
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException( "Error al serializar, mo se puede inicializar el objeto ༼つಠ益ಠ༽つ " + e.getMessage());
                    }
                });
    }

    public static String convertir_a_Json (Object object){

        inicializar_Objeto(object);

        if (Objects.isNull(object)){    /*Excepción personalizada*/
            throw new JsonSerializadorException("El objeto a serializar NO puede ser null !!! ಠ益ಠ");
        }

        Field[] atributos = object.getClass().getDeclaredFields();    /*Procesando las anotaciónes del objeto*/
        /*Devuelve un array de objetos Field que representan todos los campos declarados en la clase, incluidos los campos privados.*/

        System.out.println("----------------Clase: '"+object.getClass().getSimpleName()+"'----------------");
        System.out.println("Campos:");
        Arrays.stream(atributos).forEach(a -> System.out.println("\t- " + a.getName()));
        System.out.println();

        return Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                /*Filtra los campos que tengan presente la anotación @JsonAtributo*/
                .map(f -> { /*Transformar los campos*/
                    /*-----------------1° Obtener el nombre del campo-----------------*/
                    f.setAccessible(true); /*Permite acceder al campo aunque este sea 'private'*/
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("") /*Nombre del campo*/
                            /*Si es igual a (vacío) ""*/
                            ? f.getName()
                            /*Entonces asigna el nombre que tiene el campo*/
                            : f.getAnnotation(JsonAtributo.class).nombre();
                            /*Si no se asigna el valor que contiene el campo en 'JsonAtributo'*/
                    try {
                   /*-----------------2° Convertir en MAYÚSCULA la 1° letra del valor del campo-----------------*/
                        Object valor = f.get(object);   /*Obtenemos un objeto que contiene el valor de campo*/
                        if ((f.getAnnotation(JsonAtributo.class).capitalizar()) /*Verificar que el campo tenga anotación, el atributo de la anotación y el tipo de valor del campo*/
                                && (valor instanceof String)){
                            String nuevo_valor = (String) valor;    /*Convertir el valor del campo a String*/
                            nuevo_valor = Arrays.stream(nuevo_valor.split(" ")) /*Se crea un nuevo Stream para trabajar con el valor del campo*/
                                    .map(palabra -> palabra.substring(0,1).toUpperCase() + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));  /*Juntar todos los elementos en uno solo concatenados con " "*/
                            f.set(object, nuevo_valor); /*Se asigna el nuevo valor al objeto campo*/
                        }
                        return "\"" + nombre + "\":\"" + f.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error al serializar a json: " + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)){
                        return a + b;
                    }
                    return a +", " + b;
                }).concat("}");
    }

}
