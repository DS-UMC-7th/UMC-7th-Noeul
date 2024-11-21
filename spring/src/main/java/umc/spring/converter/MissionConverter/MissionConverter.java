package umc.spring.converter.MissionConverter;

import umc.spring.domain.Mission;
import umc.spring.dto.mission.MissionRequestDTO;
import umc.spring.dto.mission.MissionResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.createDTO request) {
        return Mission.builder()
                .content(request.getContent())
                .point(request.getPoint())
                .build();
    }

    public static MissionResponseDTO.createResponseDTO toCreateResponseDTO(Mission mission) {
        return MissionResponseDTO.createResponseDTO.builder()
                .content(mission.getContent())
                .point(mission.getPoint())
                .build();
    }
}
