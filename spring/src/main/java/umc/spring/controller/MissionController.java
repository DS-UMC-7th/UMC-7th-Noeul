package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
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
import umc.spring.validation.annotation.CheckPage;

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

    // 내가 진행중인 미션 목록
    @Operation(summary = "내가 진행중인 미션 조회 API",description = "내가 진행중인 미션을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "USER001", description = "유저를 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @GetMapping("/in-progress/{userId}")
    public ApiResponse<MissionResponseDTO.marketMissionListResponseDTO> marketMission(
            @PathVariable("userId") Long userId,
            @RequestParam("page") @CheckPage int page
    ){
        Page<Mission> missions = missionService.getMarketMission(userId, page);
        return ApiResponse.onSuccess(MissionConverter.marketMissionListResponseDTO(missions));
    }
}
