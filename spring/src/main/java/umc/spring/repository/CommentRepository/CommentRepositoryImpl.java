package umc.spring.repository.CommentRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Comment;
import umc.spring.domain.Market;
import umc.spring.domain.QComment;
import umc.spring.domain.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QComment comment = QComment.comment;

    @Override
    public List<Comment> findByUser(User user) {
        return jpaQueryFactory.selectFrom(comment)
                .where(comment.user.eq(user))
                .fetch();
    }

    @Override
    public List<Comment> findByMarket(Market market) {
        return jpaQueryFactory.selectFrom(comment)
                .where(comment.market.eq(market))
                .fetch();
    }
}
