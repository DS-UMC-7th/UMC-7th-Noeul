package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MarketExistenceValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션을 필드 및 매개변수에 적용하도록 설정
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MarketExistenceValidator.class) // 검증 로직을 처리할 Validator 지정
public @interface MarketExists {
    String message() default "리뷰를 작성하려는 가게가 존재하지 않습니다."; // 기본 메시지

    Class<?>[] groups() default {}; // 그룹

    Class<? extends Payload>[] payload() default {}; // 페이로드
}