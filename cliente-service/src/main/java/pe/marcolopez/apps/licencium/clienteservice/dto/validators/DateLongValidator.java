package pe.marcolopez.apps.licencium.clienteservice.dto.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
    Reference:
    - https://www.baeldung.com/spring-mvc-custom-validator
 */
public class DateLongValidator implements ConstraintValidator<DateLong, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        System.out.println("### value long date -> " + value);
        return value != null && value.toString().length() == 12;
    }
}
