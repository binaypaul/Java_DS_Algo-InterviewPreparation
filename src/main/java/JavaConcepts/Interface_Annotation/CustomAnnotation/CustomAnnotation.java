package JavaConcepts.Interface_Annotation.CustomAnnotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomAnnotation {
    String name();
    String date() default "N/A";
}