package org.CCristian.Annotation.Ejemplo;

import java.lang.annotation.*;

@Documented

@Target({ElementType.FIELD})  /*Esta anotación se va a aplicar sobre atributos*/
@Retention(RetentionPolicy.RUNTIME)    /*Sobre que contexto se va a aplicar la anotación*/
public @interface JsonAtributo {

/*------------------ATRIBUTOS------------------*/
    /*Atributos de Configuración*/
    String nombre() default "";     /*default (valor por defecto)*/
    boolean capitalizar() default false;
}
