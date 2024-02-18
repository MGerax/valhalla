package dom.andrei.repository;

import dom.andrei.model.Battlefield;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattlefieldRepository extends CrudRepository<Battlefield, Long> {
}
