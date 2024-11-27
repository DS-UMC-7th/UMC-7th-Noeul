package umc.spring.service.MissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MarketNotFoundHandler;
import umc.spring.apiPayload.exception.handler.UserNotFoundException;
import umc.spring.converter.MissionConverter.MissionConverter;
import umc.spring.domain.Location;
import umc.spring.domain.Market;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.dto.mission.MissionRequestDTO;
import umc.spring.repository.LocationRepository.LocationRepository;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.UserMissionRepository.UserMissionRepository;
import umc.spring.repository.UserRepository.UserRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.User;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionQueryServiceImpl implements MissionService{
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final MarketRepository marketRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findUserMission(String username, MissionStatus status, int offset, int limit) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));

        List<Mission> findUserMission = missionRepository.findByUserAndStatus(user, status, offset, limit);

        findUserMission.forEach(userMission -> System.out.println("User Mission : " + userMission));

        return findUserMission;
    }

    @Override
    public List<Mission> findMissionByLocation(String username, Long locationId, int offset, int limit) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new NoSuchElementException("location을 찾을 수 없습니다."));

        return missionRepository.findPossibleMission(user, location, offset, limit);
    }

    @Override
    public Mission createMission(MissionRequestDTO.@Valid createDTO request) {
        Market market = marketRepository.findById(request.getMarketId())
                .orElseThrow(() -> new MarketNotFoundHandler(ErrorStatus.MARKET_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request);

        mission.setMarket(market);

        return missionRepository.save(mission);
    }

    @Override
    public Page<Mission> getMarketMission(Long userId, int page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorStatus.USER_NOT_FOUND));

        // 프론트가 1 이상으로 주므로
        Page<Mission> missionPage = userMissionRepository.findAllInProgressMissionsByUser(user, PageRequest.of(page - 1, 10));

        return missionPage;
    }
}
