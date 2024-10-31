package umc.spring.MissionRepository;

import umc.spring.domain.Mission;
import umc.spring.domain.User;

import java.util.List;

public interface MissionRepositoryCustom {
    // 내가 진행중, 진행 완료한 미션 모아서 보는 쿼리(페이징 포함)
    List<Mission> dynamicQueryWithBooleanBuilder(User user);
}
