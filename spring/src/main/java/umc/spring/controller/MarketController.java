package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MarketConverter.MarketConverter;
import umc.spring.domain.Market;
import umc.spring.dto.market.MarketRequestDTO;
import umc.spring.dto.market.MarketResponseDTO;
import umc.spring.service.LocationService.MarketServiceImpl;

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
}
