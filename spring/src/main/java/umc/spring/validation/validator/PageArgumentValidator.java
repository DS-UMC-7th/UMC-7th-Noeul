package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.validation.annotation.CheckPage;

public class PageArgumentValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null) {
            return true;
        }

        // page가 1 이상이어야 함
        if (page < 1) {
            return false;
        }

        return true;
    }
}
