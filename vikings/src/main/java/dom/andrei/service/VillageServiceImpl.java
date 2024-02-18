package dom.andrei.service;

import dom.andrei.model.Village;
import dom.andrei.repository.VillageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class VillageServiceImpl implements VillageService {
    private final VillageRepository villageRepository;

    @Override
    public long save(Village village) {
        return villageRepository.save(village).getId();
    }

    @Override
    public Optional<Village> findById(long id) {
        return villageRepository.findById(id);
    }

    @Override
    public Set<Village> findAll() {
        return StreamSupport.stream(villageRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public void delete(long id) {
        villageRepository.deleteById(id);
    }
}
