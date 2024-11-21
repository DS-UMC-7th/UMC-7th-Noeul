package umc.spring.service.UserService;

import jakarta.validation.Valid;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.UserMission;
import umc.spring.dto.mission.MissionRequestDTO;
import umc.spring.dto.user.UserMissionRequestDTO;

public interface UserService {
    User getUserInfo(String username);

    UserMission createUserMission(UserMissionRequestDTO.@Valid createDTO request);
}
