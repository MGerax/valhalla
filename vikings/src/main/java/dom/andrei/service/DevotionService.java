package dom.andrei.service;

import dom.andrei.model.Devotion;
import dom.andrei.controller.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.Set;

public interface DevotionService {
    long save(Devotion devotion);

    Optional<Devotion> findById(long id);

    Set<Devotion> findAll();

    void delete(long id) throws ResourceNotFoundException;
}
