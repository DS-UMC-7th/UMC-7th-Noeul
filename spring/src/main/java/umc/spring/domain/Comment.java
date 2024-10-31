package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "writer", length = 20)
    private String writer;

    @Column(name = "star")
    private Float star;

    @Column(name = "content") // 기본 255자
    private String content;

    // market
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id")
    private Market market;

    // user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // comment image
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentImage> commentImages;

    // comment reply
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentReply> commentReplies;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", star=" + star +
                ", content='" + content + '\'' +
                ", market=" + market +
                ", user=" + user +
                ", commentImages=" + commentImages +
                ", commentReplies=" + commentReplies +
                '}';
    }
}
