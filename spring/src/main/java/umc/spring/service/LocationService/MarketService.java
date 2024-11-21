package umc.spring.service.LocationService;

import jakarta.validation.Valid;
import umc.spring.domain.Market;
import umc.spring.dto.market.MarketRequestDTO;

public interface MarketService {
    public Market createMarket(MarketRequestDTO.@Valid createDTO request);
}
