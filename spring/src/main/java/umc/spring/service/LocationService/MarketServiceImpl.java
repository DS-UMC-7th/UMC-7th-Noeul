package umc.spring.service.LocationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.LocationNotFoundHandler;
import umc.spring.apiPayload.exception.handler.MarketNotFoundHandler;
import umc.spring.converter.MarketConverter.MarketConverter;
import umc.spring.domain.*;
import umc.spring.dto.market.MarketRequestDTO;
import umc.spring.repository.LocationRepository.LocationRepository;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService{
    private final MarketRepository marketRepository;
    private final LocationRepository locationRepository;
    private final MissionRepository missionRepository;

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

    @Override
    public Page<Mission> getMarketMission(Long marketId, int page) {
        Market market = marketRepository.findById(marketId)
                .orElseThrow(() -> new MarketNotFoundHandler(ErrorStatus.MARKET_NOT_FOUND));

        // 프론트가 1 이상으로 주므로
        Page<Mission> missionPage = missionRepository.findAllByMarket(market, PageRequest.of(page - 1, 10));

        return missionPage;
    }
}
