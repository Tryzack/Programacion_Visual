package paquete;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface ColumnAnnotation {
	
	String Campo();
	boolean LlavePrimaria();
	
}