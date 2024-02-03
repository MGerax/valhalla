package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.model.Devotion;
import dom.andrei.vikingsapp.repository.DevotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DevotionServiceImpl implements DevotionService {
    private final DevotionRepository devotionRepository;

    @Override
    public long save(@RequestBody Devotion devotion) {
        return devotionRepository.save(devotion).getId();
    }

    @Override
    public Optional<Devotion> findById(long id) {
        return devotionRepository.findById(id);
    }

    @Override
    public Set<Devotion> findAll() {
        return StreamSupport.stream(devotionRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public void delete(long id) {
        devotionRepository.deleteById(id);
    }
}
