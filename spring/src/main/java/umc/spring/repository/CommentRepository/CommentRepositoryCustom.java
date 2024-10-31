package umc.spring.repository.CommentRepository;

import umc.spring.domain.Comment;
import umc.spring.domain.Market;
import umc.spring.domain.User;

import java.util.List;

public interface CommentRepositoryCustom {
    List<Comment> findByUser(User user);
    List<Comment> findByMarket(Market market);
}
