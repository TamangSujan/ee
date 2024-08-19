package pro.sujan.ee.beans.validator;

import jakarta.validation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BeanValidator {
    public static <T> List<String> getErrorsOnValidation(T t){
        try(ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()){
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<T>> violations = validator.validate(t);
            return violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
        }
    }
}
