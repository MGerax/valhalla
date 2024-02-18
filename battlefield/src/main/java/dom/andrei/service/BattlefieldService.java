package dom.andrei.service;

import dom.andrei.controller.exception.ResourceNotFoundException;
import dom.andrei.model.Battlefield;

import java.util.Optional;
import java.util.Set;

public interface BattlefieldService {
    long save(Battlefield battlefield);

    Optional<Battlefield> findById(long id);

    Set<Battlefield> findAll();

    void delete(long id) throws ResourceNotFoundException;
}
