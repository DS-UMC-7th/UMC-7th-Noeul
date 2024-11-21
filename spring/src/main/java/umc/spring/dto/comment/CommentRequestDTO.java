package umc.spring.dto.comment;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.MarketExists;

public class CommentRequestDTO {
    @Getter
    public static class createDTO {
        @NotNull
        private Float star;
        @NotNull
        private String content;
        @NotNull
        private Long userId;
        @MarketExists(message = "리뷰를 작성하려는 가게가 존재하지 않습니다.") // 가게 존재 여부 확인
        private Long marketId;
    }
}
