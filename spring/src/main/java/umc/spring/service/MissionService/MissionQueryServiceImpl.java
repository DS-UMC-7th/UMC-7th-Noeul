package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Location;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.LocationRepository.LocationRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.User;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionQueryServiceImpl implements MissionService{
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findUserMission(String username, MissionStatus status, int offset, int limit) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));

        List<Mission> findUserMission = missionRepository.findByUserAndStatus(user, status, offset, limit);

        findUserMission.forEach(userMission -> System.out.println("User Mission : " + userMission));

        return findUserMission;
    }

    @Override
    public List<Mission> findMissionByLocation(String username, Long locationId, int offset, int limit) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new NoSuchElementException("location을 찾을 수 없습니다."));

        return missionRepository.findPossibleMission(user, location, offset, limit);
    }
}
