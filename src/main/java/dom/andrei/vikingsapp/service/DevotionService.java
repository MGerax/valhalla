package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.controller.dto.DevotionDTO;
import dom.andrei.vikingsapp.model.Devotion;

import java.util.Optional;

public interface DevotionService {
    long save(DevotionDTO devotionDTO);

    Optional<Devotion> findById(long id);
}
