package umc.spring.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MarketNotFoundHandler;
import umc.spring.apiPayload.exception.handler.MissionNotFoundHandler;
import umc.spring.apiPayload.exception.handler.UserNotFoundException;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.UserMission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.dto.mission.MissionRequestDTO;
import umc.spring.dto.user.UserMissionRequestDTO;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.repository.UserRepository.UserRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserQueryServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public User getUserInfo(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));

        return user;
    }

    @Override
    public UserMission createUserMission(UserMissionRequestDTO.@Valid createDTO request) {
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionNotFoundHandler(ErrorStatus.MISSION_NOT_FOUOND));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));

        UserMission userMission = UserMission.builder()
                .mission(mission)
                .user(user)
                .status(MissionStatus.INPROGRESS)
                .build();

        return userMissionRepository.save(userMission);

    }
}
