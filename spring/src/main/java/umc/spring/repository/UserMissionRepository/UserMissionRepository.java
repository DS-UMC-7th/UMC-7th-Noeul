package umc.spring.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.UserMission;
import umc.spring.domain.enums.MissionStatus;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);

    @Query("SELECT um.mission FROM UserMission um WHERE um.user = :user AND um.status = 'INPROGRESS'")
    Page<Mission> findAllInProgressMissionsByUser(@Param("user") User user, Pageable pageable);



}
