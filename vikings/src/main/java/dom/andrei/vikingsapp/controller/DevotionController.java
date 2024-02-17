package dom.andrei.vikingsapp.controller;

import dom.andrei.vikingsapp.controller.dto.DevotionGetDTO;
import dom.andrei.vikingsapp.controller.dto.DevotionSaveDTO;
import dom.andrei.vikingsapp.controller.exception.ResourceNotFoundException;
import dom.andrei.vikingsapp.model.Devotion;
import dom.andrei.vikingsapp.service.DevotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DevotionController {
    private final DevotionService devotionService;

    @PostMapping("devotions")
    public long save(@RequestBody DevotionSaveDTO devotionDTO) {
        var devotion = new Devotion();
        devotion.setName(devotionDTO.getName());
        return devotionService.save(devotion);
    }

    @GetMapping("devotions/{id}")
    public DevotionGetDTO findById(@PathVariable long id) {
        Devotion devotion = devotionService.findById(id).orElseThrow(() ->
            new ResourceNotFoundException(HttpStatus.NOT_FOUND, "devotion is not found"));
        return new DevotionGetDTO(devotion.getId(), devotion.getName());
    }

    @GetMapping("devotions")
    public Set<DevotionGetDTO> findAll() {
        return devotionService.findAll().stream().map(devotion ->
            new DevotionGetDTO(devotion.getId(), devotion.getName())).collect(Collectors.toSet());
    }

    @DeleteMapping("devotions/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        devotionService.delete(id);
    }
}
