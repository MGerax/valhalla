package dom.andrei.valhalla.repository;

import dom.andrei.valhalla.domain.Devotion;
import dom.andrei.valhalla.domain.Viking;
import org.springframework.data.repository.CrudRepository;

public interface DevotionRepository extends CrudRepository<Devotion, Long> {
}
