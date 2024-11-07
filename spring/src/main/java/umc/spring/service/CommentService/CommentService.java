package umc.spring.service.CommentService;

import umc.spring.domain.Comment;

public interface CommentService {
    Comment createComment(String username, Long marketId, String msg, Float star);
}
