package dom.andrei.service;

import dom.andrei.repository.BattlefieldRepository;
import dom.andrei.model.Battlefield;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BattlefieldServiceImpl implements BattlefieldService {
    private final BattlefieldRepository battlefieldRepository;

    @Override
    public long save(Battlefield battlefield) {
        return battlefieldRepository.save(battlefield).getId();
    }

    @Override
    public Optional<Battlefield> findById(long id) {
        return battlefieldRepository.findById(id);
    }

    @Override
    public Set<Battlefield> findAll() {
        return StreamSupport.stream(battlefieldRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public void delete(long id) {
        battlefieldRepository.deleteById(id);
    }
}
