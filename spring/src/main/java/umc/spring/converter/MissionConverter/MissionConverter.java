package umc.spring.converter.MissionConverter;

import org.springframework.data.domain.Page;
import umc.spring.converter.CommentConverter.CommentConverter;
import umc.spring.domain.Mission;
import umc.spring.dto.comment.CommentResponseDTO;
import umc.spring.dto.mission.MissionRequestDTO;
import umc.spring.dto.mission.MissionResponseDTO;

import java.util.List;

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

    public static MissionResponseDTO.missionMissionResponseDTO missionMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.missionMissionResponseDTO.builder()
                .id(mission.getId())
                .endDate(mission.getEndDate())
                .point(mission.getPoint())
                .content(mission.getContent())
                .build();
    }

    public static MissionResponseDTO.marketMissionListResponseDTO marketMissionListResponseDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.missionMissionResponseDTO> missionMissionResponseDTOS = missionPage.stream()
                .map(MissionConverter::missionMissionResponseDTO).toList();

        return MissionResponseDTO.marketMissionListResponseDTO.builder()
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(missionMissionResponseDTOS.size())
                .marketMissionResponseDTO(missionMissionResponseDTOS)
                .build();
    }
}
