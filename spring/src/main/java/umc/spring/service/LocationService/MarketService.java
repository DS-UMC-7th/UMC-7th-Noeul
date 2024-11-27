package umc.spring.service.LocationService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.dto.market.MarketRequestDTO;

public interface MarketService {
    public Market createMarket(MarketRequestDTO.@Valid createDTO request);
    Page<Mission> getMarketMission(Long marketId, int page);

}
