package umc.spring.service.CommentService;

import jakarta.validation.Valid;
import umc.spring.domain.Comment;
import umc.spring.dto.comment.CommentRequestDTO;

public interface CommentService {
    Comment createComment(String username, Long marketId, String msg, Float star);

    Comment createComment_2(CommentRequestDTO.@Valid createDTO request);
}
