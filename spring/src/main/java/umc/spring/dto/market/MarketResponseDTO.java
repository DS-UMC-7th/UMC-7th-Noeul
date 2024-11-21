package umc.spring.dto.market;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

public class MarketResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createResponseDTO {
        private Long locationId;
        private Long marketId;
        private String name;
        private String type; // 중식당인지 일식인지 ... -> 일단 텍스트 입력으로 가정
        private LocalTime startTime;
        private LocalTime endTime;
        private String address;

    }
}
