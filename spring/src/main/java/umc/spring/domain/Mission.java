package umc.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import umc.spring.domain.common.BaseEntity;

import java.time.LocalDate;

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
}
