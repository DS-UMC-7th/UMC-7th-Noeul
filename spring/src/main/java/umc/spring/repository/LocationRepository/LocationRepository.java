package umc.spring.repository.LocationRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
