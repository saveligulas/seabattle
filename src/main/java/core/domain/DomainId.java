package core.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies the fields of a domain class that function as its domain.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DomainId {

    /**
     * Optional domain name to specify which domain this ID belongs to.
     * @return the domain name
     */
    String domain() default "";

    /**
     * Specifies whether this ID should be validated according to domain rules.
     * @return true if validation should be applied, false otherwise
     */
    boolean validate() default true;

    /**
     * Validator class to use for domain ID validation.
     * @return validator class name
     */
    String validator() default "";

    /**
     * Description of the domain ID's purpose or meaning.
     * @return description of the ID
     */
    String description() default "";
}
