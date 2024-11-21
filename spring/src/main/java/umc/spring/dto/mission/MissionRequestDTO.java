package umc.spring.dto.mission;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class createDTO {
        @NotNull
        private String content;
        @NotNull
        @Min(1)
        @Max(5)
        private Integer point;
        @NotNull
        private Long marketId;
    }
}
