package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.controller.dto.DevotionSaveDTO;
import dom.andrei.vikingsapp.model.Devotion;
import dom.andrei.vikingsapp.repository.DevotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DevotionServiceImpl implements DevotionService {
    private final DevotionRepository devotionRepository;

    @Override
    public long save(@RequestBody DevotionSaveDTO devotionDTO) {
        var devotion = new Devotion();
        devotion.setName(devotionDTO.getName());
        return devotionRepository.save(devotion).getId();
    }

    @Override
    public Optional<Devotion> findById(long id) {
        return devotionRepository.findById(id);
    }

    @Override
    public Set<Devotion> findAll() {
        return devotionRepository.findAll();
    }

    @Override
    public boolean delete(long id) {
        return devotionRepository.delete(id);
    }
}
