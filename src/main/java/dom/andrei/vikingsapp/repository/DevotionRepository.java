package dom.andrei.vikingsapp.repository;

import dom.andrei.vikingsapp.model.Devotion;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface DevotionRepository extends Repository<Devotion, Long> {
    Devotion save(Devotion devotion);

    Optional<Devotion> findById(long id);
}
