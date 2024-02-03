package dom.andrei.vikingsapp.service;

import dom.andrei.vikingsapp.model.Viking;
import dom.andrei.vikingsapp.repository.VikingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class VikingServiceImpl implements VikingService {
    private final VikingRepository vikingRepository;

    @Override
    public long save(Viking viking) {
        return vikingRepository.save(viking).getId();
    }

    @Override
    public Optional<Viking> findById(long id) {
        return vikingRepository.findById(id);
    }

    @Override
    public Set<Viking> findAll() {
        return StreamSupport.stream(vikingRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public void delete(long id) {
        vikingRepository.deleteById(id);
    }
}
