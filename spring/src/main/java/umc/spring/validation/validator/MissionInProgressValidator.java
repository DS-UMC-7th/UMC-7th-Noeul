package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.domain.Mission;
import umc.spring.domain.UserMission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;

import lombok.RequiredArgsConstructor;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.validation.annotation.MissionInProgress;

@RequiredArgsConstructor
public class MissionInProgressValidator implements ConstraintValidator<MissionInProgress, Long> {

    private final umc.spring.repository.UserMissionRepository.UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        if (missionId == null) {
            return true; // missionId가 null이면 검증 통과
        }

        // 이미 진행 중인 미션이 있는지 확인
        boolean isMissionInProgress = userMissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.INPROGRESS);

        // 미션이 이미 진행 중이라면 false 반환
        return !isMissionInProgress;
    }
}
