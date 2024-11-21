package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.validation.annotation.MarketExists;

// Validator 클래스 정의
@RequiredArgsConstructor
public class MarketExistenceValidator implements ConstraintValidator<MarketExists, Long> {

    private final MarketRepository marketRepository;

    @Override
    public boolean isValid(Long marketId, ConstraintValidatorContext context) {
        if (marketId == null) {
            return true; // marketId가 null인 경우 검증 통과
        }

        // 가게가 존재하는지 확인
        return marketRepository.existsById(marketId);
    }
}
