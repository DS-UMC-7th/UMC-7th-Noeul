package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MarketConverter.MarketConverter;
import umc.spring.converter.MissionConverter.MissionConverter;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.dto.market.MarketRequestDTO;
import umc.spring.dto.market.MarketResponseDTO;
import umc.spring.dto.mission.MissionRequestDTO;
import umc.spring.dto.mission.MissionResponseDTO;
import umc.spring.service.MissionService.MissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {
    private final MissionService missionService;

    // 가게에 미션 추가하기 API
    @PostMapping("")
    public ApiResponse<MissionResponseDTO.createResponseDTO> createMission(@RequestBody @Valid MissionRequestDTO.createDTO request){
        Mission mission = missionService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResponseDTO(mission));
    }
}
