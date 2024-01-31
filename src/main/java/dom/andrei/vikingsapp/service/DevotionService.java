package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.controller.dto.DevotionSaveDTO;
import dom.andrei.vikingsapp.controller.exception.ResourceNotFoundException;
import dom.andrei.vikingsapp.model.Devotion;

import java.util.Optional;
import java.util.Set;

public interface DevotionService {
    long save(DevotionSaveDTO devotionDTO);

    Optional<Devotion> findById(long id);

    Set<Devotion> findAll();

    boolean delete(long id) throws ResourceNotFoundException;
}
