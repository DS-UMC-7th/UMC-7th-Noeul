package umc.spring.service.MarketService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Location;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.repository.CommentRepository.CommentRepository;
import umc.spring.repository.LocationRepository.LocationRepository;
import umc.spring.repository.MarketRepository.MarketRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.UserRepository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberService{
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final MissionRepository missionRepository;

}
