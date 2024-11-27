package umc.spring.dto.comment;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Market;
import umc.spring.domain.User;

import java.util.List;

public class CommentResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createResponseDTO {
        private String writer;
        private Float star;
        private String content;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myCommentListDTO {
        List<myCommentDTO> commentList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myCommentDTO {
        private Long id;
        private String writer;
        private Float star;
        private String content;
        private String marketName;
    }
}
