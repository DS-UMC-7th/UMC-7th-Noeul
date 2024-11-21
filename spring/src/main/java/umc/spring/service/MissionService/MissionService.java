package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;
import java.util.Optional;

public interface MissionService {
    Optional<Mission> findMission(Long id);
    List<Mission> findUserMission(String username, MissionStatus status, int offset, int limit);
    List<Mission> findMissionByLocation(String username, Long locationId, int offset, int limit);
}
