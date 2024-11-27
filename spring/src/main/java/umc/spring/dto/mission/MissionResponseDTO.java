package umc.spring.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class MissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createResponseDTO {
        private String content;
        private Integer point;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class missionMissionResponseDTO {
        private Long id;
        private String content;
        private Integer point;
        private LocalDate endDate;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class marketMissionListResponseDTO {
        private List<MissionResponseDTO.missionMissionResponseDTO> marketMissionResponseDTO;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private  Boolean isFirst;
        private Boolean isLast;
    }
}
