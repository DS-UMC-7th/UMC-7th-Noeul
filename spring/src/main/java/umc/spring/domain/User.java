package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.SocialType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_type")
    private SocialType socialType;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "address", nullable = false, length = 40) // erd 20 -> 40으로 늘림
    private String address;

    // private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10)
    private Gender gender;

    @Column(name = "email")
    private String email;

    @Column(name = "point", columnDefinition = "BIGINT DEFAULT 0")
    private Long point = 0L; // 초기값 0

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "phone_valid")
    private String phoneValid;

    // 알림 권한 3개
    @Column(name = "new_event_agree")
    private String newEventAgree;

    @Column(name = "review_reply_alarm")
    private String reviewReplyAlarm;

    @Column(name = "inquiry_answer_alarm")
    private String inQuriyAnswerAlarm;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MemberStatus status;

    @Column(name = "inactive_date")
    private LocalDate inactiveDate;

    // comment
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // inquiry
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inquiry> inquiries;

    // alarm
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alarm> alarms;

    // food like
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodLike> foodLikes;

    // mission
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> missions;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", socialType=" + socialType +
                ", username='" + username + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                '}';
    }
}
