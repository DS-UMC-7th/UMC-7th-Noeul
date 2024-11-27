package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MissionInProgressValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MissionInProgressValidator.class) // 검증 로직을 처리할 Validator 지정
public @interface MissionInProgress {
    String message() default "미션은 이미 진행 중입니다."; // 기본 메시지

    Class<?>[] groups() default {}; // 그룹

    Class<? extends Payload>[] payload() default {}; // 페이로드
}
