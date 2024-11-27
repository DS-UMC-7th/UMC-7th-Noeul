package umc.spring.converter.CommentConverter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Comment;
import umc.spring.dto.comment.CommentRequestDTO;
import umc.spring.dto.comment.CommentResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static CommentResponseDTO.myCommentDTO myCommentDTO(Comment comment) {
        return CommentResponseDTO.myCommentDTO.builder()
                .id(comment.getId())
                .writer(comment.getWriter())
                .marketName(comment.getMarket().getName())
                .star(comment.getStar())
                .content(comment.getContent())
                .build();
    }

    public static CommentResponseDTO.myCommentListDTO myCommentListDTO (Page<Comment> comments) {
        List<CommentResponseDTO.myCommentDTO> commentDTOList = comments.stream()
                .map(CommentConverter::myCommentDTO).toList();

        return CommentResponseDTO.myCommentListDTO.builder()
                .isFirst(comments.isFirst())
                .isLast(comments.isLast())
                .totalPage(comments.getTotalPages())
                .totalElements(comments.getTotalElements())
                .listSize(commentDTOList.size())
                .commentList(commentDTOList)
                .build();
    }
}
