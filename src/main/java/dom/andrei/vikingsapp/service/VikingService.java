package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.controller.exception.ResourceNotFoundException;
import dom.andrei.vikingsapp.model.Viking;

import java.util.Optional;
import java.util.Set;

public interface VikingService {
    long save(Viking viking);

    Optional<Viking> findById(long id);

    Set<Viking> findAll();

    void delete(long id) throws ResourceNotFoundException;
}
