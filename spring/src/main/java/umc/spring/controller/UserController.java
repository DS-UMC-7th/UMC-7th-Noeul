package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter.MissionConverter;
import umc.spring.converter.UserMissionConverter.UserMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.UserMission;
import umc.spring.dto.mission.MissionRequestDTO;
import umc.spring.dto.mission.MissionResponseDTO;
import umc.spring.dto.user.UserMissionRequestDTO;
import umc.spring.dto.user.UserMissionResponseDTO;
import umc.spring.service.MissionService.MissionService;
import umc.spring.service.UserService.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 진행중인 미션 만들기
    @PostMapping("")
    public ApiResponse<UserMissionResponseDTO.createResponseDTO> createMission(@RequestBody @Valid UserMissionRequestDTO.createDTO request){
        UserMission userMission = userService.createUserMission(request);
        return ApiResponse.onSuccess(UserMissionConverter.toCreateResponseDTO(userMission));
    }
}
