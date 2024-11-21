package umc.spring.dto.market;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalTime;

public class MarketRequestDTO {
    @Getter
    public static class createDTO {

        @NotNull(message = "Location ID cannot be null")
        private Long locationId;

        @NotNull(message = "Name cannot be null")
        @Size(min = 1, message = "Name must not be empty")
        private String name;

        @NotNull(message = "Type cannot be null")
        @Size(min = 1, message = "Type must not be empty")
        private String type;

//        @NotNull(message = "Start time cannot be null")
//        private LocalTime startTime;
//
//        @NotNull(message = "End time cannot be null")
//        private LocalTime endTime;

        @NotNull(message = "Address cannot be null")
        @Size(min = 1, message = "Address must not be empty")
        private String address;
    }
}
