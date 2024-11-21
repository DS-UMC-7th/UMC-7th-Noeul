package umc.spring.repository.MarketRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    boolean existsById(Long id);

}
