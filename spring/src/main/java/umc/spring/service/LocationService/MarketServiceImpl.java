package umc.spring.service.LocationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.LocationNotFoundHandler;
import umc.spring.converter.MarketConverter.MarketConverter;
import umc.spring.domain.Location;
import umc.spring.domain.Market;
import umc.spring.dto.market.MarketRequestDTO;
import umc.spring.repository.LocationRepository.LocationRepository;
import umc.spring.repository.MarketRepository.MarketRepository;

@Service
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService{
    private final MarketRepository marketRepository;
    private final LocationRepository locationRepository;

    @Override
    public Market createMarket(MarketRequestDTO.@Valid createDTO request) {
        Market market = MarketConverter.toMarket(request);

        // locationId에 해당하는 location을 찾음
        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new LocationNotFoundHandler(ErrorStatus.LOCATION_NOT_FOUND));

        // 양방향 관계 넣어줌
        market.setLocation(location);
        return marketRepository.save(market);
    }
}
