package dom.andrei.vikingsapp.repository;

import dom.andrei.vikingsapp.model.Viking;
import org.springframework.data.repository.CrudRepository;

public interface VikingRepository extends CrudRepository<Viking, Long> {
}
