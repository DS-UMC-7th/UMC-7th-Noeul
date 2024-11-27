package umc.spring.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.MissionInProgress;

public class UserMissionRequestDTO {
    @Getter
    public static class createDTO {
        @NotNull
        private Long userId;
        @NotNull
        @MissionInProgress(message = "미션은 이미 진행 중입니다.")
        private Long missionId;
    }
}
