package org.CCristian.Annotation.Ejemplo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)/*Esta anotación se va a aplicar sobre métodos*/
public @interface Init {

}
