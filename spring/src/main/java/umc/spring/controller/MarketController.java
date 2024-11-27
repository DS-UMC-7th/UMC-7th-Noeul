package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.CommentConverter.CommentConverter;
import umc.spring.converter.MarketConverter.MarketConverter;
import umc.spring.converter.MissionConverter.MissionConverter;
import umc.spring.domain.Comment;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.dto.market.MarketRequestDTO;
import umc.spring.dto.market.MarketResponseDTO;
import umc.spring.dto.mission.MissionResponseDTO;
import umc.spring.service.LocationService.MarketServiceImpl;
import umc.spring.validation.annotation.CheckPage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
public class MarketController {
    private final MarketServiceImpl marketService;
    // 특정 지역에 가게 추가하기 API
    @PostMapping("")
    public ApiResponse<MarketResponseDTO.createResponseDTO> createMarket(@RequestBody @Valid MarketRequestDTO.createDTO request){
        Market market = marketService.createMarket(request);
        return ApiResponse.onSuccess(MarketConverter.toCreateResponseDTO(market));
    }

    // 내가 작성한 리뷰 목록 API (페이징)
    @Operation(summary = "market에 해당하는 미션 조회 API",description = "market id에 해당하는 미션을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MARKET001", description = "가게를 찾을 수 없습니다.",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
//    @Parameters({
//            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다! (토큰이 없어서 임시로 이걸로 받음)")
//    })
    @GetMapping("/mission/{marketId}")
    public ApiResponse<MissionResponseDTO.marketMissionListResponseDTO> marketMission(
            @PathVariable("marketId") Long marketId,
            @RequestParam("page") @CheckPage int page
    ){
        Page<Mission> missions = marketService.getMarketMission(marketId, page);
        return ApiResponse.onSuccess(MissionConverter.marketMissionListResponseDTO(missions));
    }
}
