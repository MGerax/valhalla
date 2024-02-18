package dom.andrei.service;

import dom.andrei.model.Village;
import dom.andrei.controller.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.Set;

public interface VillageService {
    long save(Village village);

    Optional<Village> findById(long id);

    Set<Village> findAll();

    void delete(long id) throws ResourceNotFoundException;
}
