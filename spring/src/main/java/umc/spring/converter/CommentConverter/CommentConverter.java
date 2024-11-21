package umc.spring.converter.CommentConverter;

import umc.spring.domain.Comment;
import umc.spring.dto.comment.CommentRequestDTO;
import umc.spring.dto.comment.CommentResponseDTO;

public class CommentConverter {

    public static Comment toComment(CommentRequestDTO.createDTO request) {
        return Comment.builder()
                .content(request.getContent())
                .star(request.getStar())
                .build();
    }

    public static CommentResponseDTO.createResponseDTO toCreateResponseDTO(Comment comment) {
        return CommentResponseDTO.createResponseDTO.builder()
                .writer(comment.getWriter())
                .star(comment.getStar())
                .content(comment.getContent())
                .build();
    }
}
