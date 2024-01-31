package dom.andrei.vikingsapp.repository;

import dom.andrei.vikingsapp.model.Devotion;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;

public interface DevotionRepository extends Repository<Devotion, Long> {
    Devotion save(Devotion devotion);

    Optional<Devotion> findById(long id);

    Set<Devotion> findAll();

    boolean delete(long id);
}
