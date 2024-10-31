package umc.spring.MissionService;

import umc.spring.domain.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionService {
    Optional<Mission> findMission(Long id);
    List<Mission> findUserMission(String username);
}
