package umc.spring.repository.CommentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
}