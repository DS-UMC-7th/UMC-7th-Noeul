package umc.spring.converter.MarketConverter;

import umc.spring.domain.Market;
import umc.spring.dto.market.MarketRequestDTO;
import umc.spring.dto.market.MarketResponseDTO;

import java.time.LocalTime;

public class MarketConverter {
    public static MarketResponseDTO.createResponseDTO toCreateResponseDTO(Market market) {
        return MarketResponseDTO.createResponseDTO.builder()
        // .locationId() -> 양방향 매핑 여기서 x
                .marketId(market.getId())
                .name(market.getName())
                .type(market.getType())
                .startTime(market.getStartTime())
                .endTime(market.getEndTime())
                .address(market.getAddress())
                .build();
    }

    public static Market toMarket(MarketRequestDTO.createDTO request) {
        return Market.builder()
                // .location -> 양방향 여기서 x
                .name(request.getName())
                .type(request.getType())
//                .startTime(request.getStartTime())
//                .endTime(request.getEndTime())
                .address(request.getAddress())
                .build();
    }
}
