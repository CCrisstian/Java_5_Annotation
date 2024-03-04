<h1 align="center">Annotation</h1>
<p>En Java, la anotación, o <b>'annotation'</b> en inglés, es una forma de proporcionar metadatos sobre elementos del código fuente. Las anotaciones se introdujeron en Java 5 y son utilizadas para agregar información adicional a clases, métodos, campos y otros elementos del código. Estos metadatos pueden ser utilizados por el compilador, tiempo de ejecución u otras herramientas para realizar acciones específicas.</p>
<p>Las anotaciones se definen precediendo el elemento al que se aplican con el símbolo "@" seguido del nombre de la anotación. Pueden tener parámetros que permiten configurar su comportamiento.</p>
Por ejemplo:

```java
@Deprecated
public class MiClase {
    // código de la clase
}
```
-  `@Deprecated`: Se utiliza para marcar la clase como obsoleta, lo que significa que se desaconseja su uso en futuras versiones y se espera que se reemplace con una alternativa más nueva.
<h2 align="center">@Target</h2>
<p>La anotación <b>'@Target'</b> en Java se utiliza para especificar a qué tipos de elementos del programa puede aplicarse una anotación personalizada. En otras palabras, @Target ayuda a restringir el alcance de una anotación, indicando qué elementos del código pueden ser anotados con esa anotación particular.</p>
<p>La anotación <b>'@Target'</b> se aplica a la declaración de la anotación personalizada. Se debe proporcionar un parámetro que consiste en un array de constantes de enumeración del tipo <b>'ElementType'</b>. Estos elementos de enumeración representan los posibles destinos a los que se puede aplicar la anotación personalizada.</p>

Ejemplo de cómo se usa `@Target`
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MiAnotacion {
    // Definición de la anotación
}
```
Los posibles valores para `ElementType` incluyen:
-  `ANNOTATION_TYPE`: Se refiere a otra anotación. Puede ser aplicada a la declaración de una anotación.
-  `FIELD`: Se refiere a un campo, es decir, una variable de instancia en una clase.
-  `TYPE`: Se refiere a un tipo, que incluye clases, interfaces y enumeraciones.
-  `CONSTRUCTOR`: Se refiere a un constructor de una clase.
-  `METHOD`: Se refiere a un método.
-  `LOCAL_VARIABLE`: Se refiere a una variable local en un método.
-  `MODULE`: Se refiere a un módulo en Java, ya que Java 9 introdujo el concepto de módulos.
-  `PACKAGE`: Se refiere a un paquete.
-  `PARAMETER`: Se refiere a un parámetro de un método.
-  `RECORD_COMPONENT`: Se refiere a un componente de un registro (record) en Java, que es una característica introducida en Java 14.
-  `TYPE_PARAMETER`: Se refiere a un parámetro de tipo genérico de una clase, interfaz, método o constructor.
-  `TYPE_USE`: Se refiere a un uso de un tipo. Puede ser aplicada en cualquier lugar donde se utilice un tipo, como en la declaración de una variable, el retorno de un método, etc.
<h2 align="center">@Retention</h2>
<p>La anotación <b>'@Retention'</b> en Java se utiliza para especificar cuánto tiempo la anotación personalizada debe ser retenida o conservada. En otras palabras, <b>'@Retention'</b> define la duración durante la cual la información asociada con la anotación estará disponible.</p>

`@Retention` toma un parámetro que consiste en una constante de enumeración del tipo `RetentionPolicy`. Los valores posibles para `RetentionPolicy` son:
-  `SOURCE`: La anotación se retiene solo en el código fuente y no se conserva en el archivo de clases compilado ni está disponible durante la ejecución.
-  `CLASS`: La anotación se retiene en el archivo de clases compilado, pero no está disponible durante la ejecución. Este es el valor predeterminado si no se especifica `@Retention`.
-  `RUNTIME`: La anotación se retiene en el archivo de clases compilado y está disponible durante la ejecución. Esto significa que se puede acceder a la anotación mediante reflexión en tiempo de ejecución.

Ejemplo de cómo se utiliza `@Retention`
```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MiAnotacion {
    // Definición de la anotación
}
```
En este ejemplo, la anotación @MiAnotacion se retiene durante la ejecución, lo que permite acceder a la información asociada con la anotación en tiempo de ejecución mediante reflexión.
<h2 align="center">@Documented</h2>
<p>La anotación <b>'@Documented'</b> en Java es una anotación de marcador que se utiliza para indicar que las anotaciones personalizadas con esta anotación deben ser incluidas en la documentación generada automáticamente. Es decir, cuando se genera la documentación del código utilizando herramientas como Javadoc, las anotaciones marcadas con <b>'@Documented'</b> se incluirán en la documentación para que los desarrolladores puedan consultarlas.</p>

Esta anotación no tiene parámetros y se utiliza de la siguiente manera:
```java
import java.lang.annotation.Documented;

@Documented
public @interface MiAnotacion {
    // Definición de la anotación
}

```
<p>En este ejemplo, la anotación @MiAnotacion está marcada con <b>'@Documented'</b>, lo que significa que cualquier uso de esta anotación en el código fuente será documentado en la salida de Javadoc.</p>
<p>Es importante destacar que <b>'@Documented'</b> no cambia el comportamiento o la funcionalidad de la anotación en sí; simplemente afecta a la generación de documentación. Si una anotación personalizada no está marcada con <b>'@Documented'</b>, su presencia y detalles pueden no aparecer en la documentación generada.</p>
