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
<h2 align="center">'Field'</h2>
<p>En Java, <b>'Field'</b> es una clase que pertenece al paquete <b>java.lang.reflect</b> y se utiliza para representar campos (variables de instancia) de una clase. Esta clase proporciona métodos para obtener y manipular información sobre los campos de una clase en tiempo de ejecución.</p>

Métodos proporcionados por la clase `Field`:
-  `get()`: Devuelve el valor del campo para el objeto dado. Necesita recibir como argumento una instancia del objeto al que pertenece el campo.
-  `set()`: Asigna un nuevo valor al campo para el objeto dado. Requiere dos argumentos: una instancia del objeto al que pertenece el campo y el nuevo valor a asignar.
-  `getName()`: Devuelve el nombre del campo como una cadena de texto.
-  `getType()`: Devuelve un objeto `Class` que representa el tipo de datos del campo.
-  `getModifiers()`: Devuelve un entero que representa los modificadores del campo. Puede utilizarse junto con la clase `Modifier` para analizar los modificadores.
-  `equals(Object obj)`: Compara el campo con otro objeto para verificar si son iguales.
-  `hashCode()`: Devuelve el código hash del campo.
-  `toString()`: Devuelve una representación en cadena del campo, que incluye su nombre y tipo.
-  `getClass()`: Devuelve la clase Class que representa la clase en la que se declara el campo.
-  `getClass().getDeclaredFields()`: Devuelve un array de objetos `Field` que representan todos los campos declarados en la clase, incluidos los campos privados.
-  `getClass().getFields()`: Devuelve un array de objetos Field que representan todos los campos públicos de la clase y de sus superclases.
-  `getClass().getAnnotationsByType(Class<T> annotationClass)`: Devuelve un array de anotaciones del tipo especificado que están presentes en el campo.
-  `getClass().getDeclaredAnnotationsByType(Class<T> annotationClass)`: Similar a `getAnnotationsByType`, pero solo busca en las anotaciones declaradas directamente en la clase, sin considerar las heredadas.
-  `set(Object obj, Object value)`: Asigna un nuevo valor al campo para el objeto dado. Puede ser utilizado para modificar el valor de un campo, incluso si es privado.
-  `setAccessible(boolean flag)`: Establece la accesibilidad del campo. Si `flag` es `true`, el campo se vuelve accesible incluso si es privado, lo cual puede ser útil para evitar restricciones de acceso. Puede lanzar una excepción `SecurityException` si la seguridad no lo permite.
-  `setBoolean(Object obj, boolean z)`: Asigna un valor booleano al campo para el objeto dado.
-  `setByte(Object obj, byte b)`: Asigna un valor byte al campo para el objeto dado.
-  `setChar(Object obj, char c)`: Asigna un valor char al campo para el objeto dado.
-  `setDouble(Object obj, double d)`: Asigna un valor double al campo para el objeto dado.
-  `setFloat(Object obj, float f)`: Asigna un valor float al campo para el objeto dado.
-  `setInt(Object obj, int i)`: Asigna un valor int al campo para el objeto dado.
-  `setLong(Object obj, long L)`: Asigna un valor long al campo para el objeto dado.
-  `setShort(Object obj, short s)`: Asigna un valor short al campo para el objeto dado.
-  `trySetAccessible()`: Intenta establecer la accesibilidad del campo a `true` sin lanzar excepciones de seguridad. Este método es específico de algunas implementaciones de Java y no es parte de la especificación estándar de Java.
<p>Estos métodos permiten inspeccionar y manipular campos de clases en tiempo de ejecución, proporcionando flexibilidad para trabajar con la estructura de la clase.</p>
<h2 align="center">'Method'</h2>
<p>En Java, la clase <b>'Method'</b> pertenece al paquete java.lang.reflect y se utiliza para representar un método de una clase en tiempo de ejecución. Permite acceder y manipular información sobre los métodos de una clase, así como invocar esos métodos dinámicamente.</p>

Métodos más comunes proporcionados por la clase `Method`:
-  `getName()`: Devuelve el nombre del método.
-  `getReturnType()`: Devuelve un objeto Class que representa el tipo de retorno del método.
-  `getParameterTypes()`: Devuelve un array de objetos Class que representan los tipos de parámetros del método.
-  `getModifiers()`: Devuelve un entero que representa los modificadores del método.
-  `invoke(Object obj, Object... args)`: Invoca el método en el objeto proporcionado con los argumentos dados y devuelve el resultado.
-  `isVarArgs()`: Devuelve true si el método utiliza la sintaxis de argumentos variables (varargs), false en caso contrario.
-  `isBridge()`: Devuelve true si el método es un puente introducido por el compilador para admitir la interoperabilidad entre versiones genéricas y no genéricas.
-  `isSynthetic()`: Devuelve true si el método es sintético, es decir, fue generado por el compilador y no aparece en el código fuente original.
-  `getAnnotation(Class<T> annotationClass)`: Devuelve la anotación del tipo especificado presente en este método, o null si no está presente.
-  `getDeclaredAnnotations()`: Devuelve un array de todas las anotaciones presentes en este método.
-  `getExceptionTypes()`: Devuelve un array de objetos Class que representan los tipos de excepciones declaradas lanzadas por el método.
-  `getGenericReturnType()`: Devuelve un objeto Type que representa el tipo de retorno del método, incluyendo información sobre genéricos si está presente.
-  `getGenericParameterTypes()`: Devuelve un array de objetos Type que representan los tipos de parámetros del método, incluyendo información sobre genéricos si está presente.
-  `toString()`: Devuelve una representación en cadena del método, que incluye su nombre, tipos de parámetros y tipo de retorno.
<p>Estos métodos permiten inspeccionar y manipular métodos de una clase en tiempo de ejecución, lo que puede ser útil para implementar lógica dinámica y trabajar con métodos de manera más flexible.</p>
