package umc.spring.repository.MissionRepository;

import umc.spring.domain.Location;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    // 내가 진행중, 진행 완료한 미션 모아서 보는 쿼리(페이징 포함)
    List<Mission> findByUserAndStatus(User user, MissionStatus status, int offset, int limit);
    List<Mission> findPossibleMission(User user, Location location, int offset, int limit);

}
