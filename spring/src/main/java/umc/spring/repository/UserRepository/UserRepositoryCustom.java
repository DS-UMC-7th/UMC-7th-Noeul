package umc.spring.repository.UserRepository;

import umc.spring.domain.User;

import java.util.Optional;

public interface UserRepositoryCustom {
    // 유저 조회
    Optional<User> findByUsername(String username);
}
