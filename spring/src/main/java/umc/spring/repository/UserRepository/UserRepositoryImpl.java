package umc.spring.repository.UserRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.QUser;
import umc.spring.domain.User;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;

    @Override
    public Optional<User> findByUsername(String username) {
        User foundUser = jpaQueryFactory.selectFrom(user)
                .where(user.username.eq(username))
                .fetchOne();

        return Optional.ofNullable(foundUser);
    }
}