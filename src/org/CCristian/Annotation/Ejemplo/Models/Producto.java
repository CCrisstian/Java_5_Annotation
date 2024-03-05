package org.CCristian.Annotation.Ejemplo.Models;

import org.CCristian.Annotation.Ejemplo.Init;
import org.CCristian.Annotation.Ejemplo.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {
/*------------------ATRIBUTOS------------------*/
    @JsonAtributo()
    private String nombre;  /*Si el atributo 'nombre' NO tiene valor dentro del 'JsonAtributo' toma el nombre de ese campo*/
    @JsonAtributo(nombre = "costo")   /*Si el atributo de la 'Anotación' tiene un valor se toma ese*/
    private Long precio;

    private LocalDate fecha;
/*------------------GETTER-SETTER------------------*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
/*------------------MÉTODOS------------------*/
    @Init
    private void init(){    /*Capitalizar atributo 'nombre'*/
       this.nombre = Arrays.stream(nombre.split(" ")) /*Se crea un nuevo Stream para trabajar con el valor del campo*/
                .map(palabra -> palabra.substring(0,1).toUpperCase() + palabra.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));  /*Juntar todos los elementos en uno solo concatenados con " "*/
    }
}
