package umc.spring.service.CommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Comment;
import umc.spring.domain.Market;
import umc.spring.domain.User;
import umc.spring.repository.CommentRepository.CommentRepository;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.repository.UserRepository.UserRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentQueryServiceImpl implements CommentService{
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final MarketRepository marketRepository;

    @Override
    public Comment createComment(String username, Long marketId, String msg, Float star) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));

        Market market = marketRepository.findById(marketId)
                .orElseThrow(() -> new NoSuchElementException("market을 수 없습니다."));

        Comment createComment = Comment.builder()
                .content(msg)
                .star(star)
                .build();

        return commentRepository.save(createComment);

    }
}
