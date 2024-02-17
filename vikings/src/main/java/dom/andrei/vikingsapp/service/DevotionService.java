package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.controller.exception.ResourceNotFoundException;
import dom.andrei.vikingsapp.model.Devotion;

import java.util.Optional;
import java.util.Set;

public interface DevotionService {
    long save(Devotion devotion);

    Optional<Devotion> findById(long id);

    Set<Devotion> findAll();

    void delete(long id) throws ResourceNotFoundException;
}
