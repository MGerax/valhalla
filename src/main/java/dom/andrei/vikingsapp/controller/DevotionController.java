package dom.andrei.vikingsapp.controller;

import dom.andrei.vikingsapp.controller.dto.DevotionDTO;
import dom.andrei.vikingsapp.controller.exception.ResourceNotFoundException;
import dom.andrei.vikingsapp.model.Devotion;
import dom.andrei.vikingsapp.service.DevotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DevotionController {
    private final DevotionService devotionService;

    @PostMapping("devotion")
    public long save(@RequestBody DevotionDTO devotionDTO) {
        return devotionService.save(devotionDTO);
    }

    @GetMapping("devotion/{id}")
    public Devotion save(@PathVariable long id) {
        return devotionService.findById(id).orElseThrow(() ->
            new ResourceNotFoundException(HttpStatus.NOT_FOUND, "devotion is not found"));
    }
}
