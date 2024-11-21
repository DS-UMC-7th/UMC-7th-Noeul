package umc.spring.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;

public class UserMissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createResponseDTO {
        private Long userMissionId;
        private Long userId;
        private Long marketId;
        private MissionStatus status;
    }
}
