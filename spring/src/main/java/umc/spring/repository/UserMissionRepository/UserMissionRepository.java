package umc.spring.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.UserMission;
import umc.spring.domain.enums.MissionStatus;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);

}
