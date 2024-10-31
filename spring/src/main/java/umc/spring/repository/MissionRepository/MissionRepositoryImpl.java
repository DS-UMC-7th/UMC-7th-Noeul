package umc.spring.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMission;
import umc.spring.domain.QUserMission;
import umc.spring.domain.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private QUserMission userMission = QUserMission.userMission;

    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(User user) {
        BooleanBuilder predicate = new BooleanBuilder();

        return jpaQueryFactory.select(mission)
                .from(userMission)
                .join(userMission.mission, mission)
                .where(userMission.user.eq(user))
                .fetch();
    }

}
