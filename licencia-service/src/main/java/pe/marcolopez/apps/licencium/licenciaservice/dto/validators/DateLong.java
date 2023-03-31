package pe.marcolopez.apps.licencium.licenciaservice.dto.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateLongValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateLong {

    String message() default "Fecha en formato Long incorrecta, debe tener 12 caracteres";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
