package org.CCristian.Annotation.Ejemplo;

import org.CCristian.Annotation.Ejemplo.Models.Producto;
import org.CCristian.Annotation.Ejemplo.Procesador.JsonSerializador;

import java.time.LocalDate;

public class Ejemplo_Annotation {
    public static void main(String[] args) {

        Producto producto = new Producto();
        producto.setFecha(LocalDate.now());
        producto.setNombre("mesa de centro ROBLE");
        producto.setPrecio(1000L);

        System.out.println("Json = " + JsonSerializador.convertir_a_Json(producto));
    }
}
