package umc.spring.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.MissionRepository.MissionRepository;
import umc.spring.MissionRepository.UserRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.User;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionService{
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findUserMission(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));

        List<Mission> findUserMission = missionRepository.dynamicQueryWithBooleanBuilder(user);

        findUserMission.forEach(userMission -> System.out.println("User Mission : " + userMission));

        return findUserMission;
    }
}
