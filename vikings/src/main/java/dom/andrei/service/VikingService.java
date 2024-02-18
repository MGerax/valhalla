package dom.andrei.service;

import dom.andrei.controller.exception.ResourceNotFoundException;
import dom.andrei.model.Viking;

import java.util.Optional;
import java.util.Set;

public interface VikingService {
    long save(Viking viking);

    Optional<Viking> findById(long id);

    Set<Viking> findAll();

    void delete(long id) throws ResourceNotFoundException;
}
