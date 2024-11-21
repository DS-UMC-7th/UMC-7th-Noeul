package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content") // 기본 길이 255
    private String content;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "point")
    private Integer point;

    // market
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id")
    private Market market;

    // mission
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> missions;

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", endDate=" + endDate +
                ", point=" + point +
                '}';
    }
}
