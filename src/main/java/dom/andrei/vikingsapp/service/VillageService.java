package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.controller.exception.ResourceNotFoundException;
import dom.andrei.vikingsapp.model.Village;

import java.util.Optional;
import java.util.Set;

public interface VillageService {
    long save(Village village);

    Optional<Village> findById(long id);

    Set<Village> findAll();

    void delete(long id) throws ResourceNotFoundException;
}
