package umc.spring.service.CommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MarketNotFoundHandler;
import umc.spring.apiPayload.exception.handler.UserNotFoundException;
import umc.spring.converter.CommentConverter.CommentConverter;
import umc.spring.domain.Comment;
import umc.spring.domain.Market;
import umc.spring.domain.User;
import umc.spring.dto.comment.CommentRequestDTO;
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

    @Override
    public Comment createComment_2(CommentRequestDTO.@Valid createDTO request) {
        Comment comment = CommentConverter.toComment(request);

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));

        Market market = marketRepository.findById(request.getMarketId())
                .orElseThrow(() -> new MarketNotFoundHandler(ErrorStatus.MARKET_NOT_FOUND));

        comment.setUser(user);
        comment.setMarket(market);
        comment.setWriter(user.getUsername());
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getMyCommentList(Long userId, int page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));

        // 프론트가 1 이상으로 주므로
        Page<Comment> commentPage = commentRepository.findAllByUser(user, PageRequest.of(page - 1, 10));

        return commentPage;
    }
}
