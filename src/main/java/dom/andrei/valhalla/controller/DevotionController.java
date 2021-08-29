package dom.andrei.valhalla.controller;

import dom.andrei.valhalla.domain.Devotion;
import dom.andrei.valhalla.repository.DevotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("devotions")
public class DevotionController {
    @Autowired
    private DevotionRepository devotionRepository;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    String getDevotions() {
        return devotionRepository.findAll().toString();
    }

    @PostMapping
    String createDevotion(@RequestBody Devotion newDevotion) {
        return devotionRepository.save(newDevotion).toString();
    }

    @DeleteMapping("/{id}")
    void deleteDevotion(@PathVariable long id) {
        devotionRepository.deleteById(id);
    }
}
