package umc.spring.converter.UserMissionConverter;

import umc.spring.domain.UserMission;
import umc.spring.dto.user.UserMissionResponseDTO;

public class UserMissionConverter {
    // public static UserMission toMissio -> 연관관계 외 넣을 정보 없음

    public static UserMissionResponseDTO.createResponseDTO toCreateResponseDTO(UserMission userMission) {
        return UserMissionResponseDTO.createResponseDTO.builder()
                .userMissionId(userMission.getId())
                .marketId(userMission.getMission().getId())
                .userId(userMission.getUser().getId())
                .status(userMission.getStatus())
                .build();
    }
}
