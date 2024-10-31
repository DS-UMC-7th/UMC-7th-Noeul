package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QUserMission userMission = QUserMission.userMission;

    @Override
    public List<Mission> findByUserAndStatus(User user, MissionStatus status, int offset, int limit) {
        BooleanBuilder predicate = new BooleanBuilder();

        // 사용자가 설정한 값으로 필터링
        predicate.and(userMission.user.eq(user));

        // status가 null이 아닌 경우
        if (status != null) {
            predicate.and(userMission.status.eq(status));
        }

        return jpaQueryFactory.select(mission)
                .from(userMission)
                .join(userMission.mission, mission)
                .where(predicate)
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    @Override
    public List<Mission> findPossibleMission(User user, Location location, int offset, int limit) {
        BooleanBuilder predicate = new BooleanBuilder();

        // 1. 지역에 해당하는 미션만 필터링
        predicate.and(mission.market.location.eq(location));

        // 2. 사용자가 도전하지 않은 미션만 필터링
        predicate.and(
                jpaQueryFactory.selectOne()
                        .from(userMission)
                        .where(userMission.user.eq(user)
                                .and(userMission.mission.eq(mission)))
                        .notExists()
        );

        // 3. 쿼리 실행
        return jpaQueryFactory.selectFrom(mission)
                .where(predicate)
                .offset(offset)
                .limit(limit)
                .fetch();
    }

}

