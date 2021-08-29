package dom.andrei.valhalla.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dom.andrei.valhalla.repository.VikingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VikingController {
    @Autowired
    private VikingRepository vikingRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "vikings", produces = MediaType.APPLICATION_JSON_VALUE)
    String getVikings() {
        return vikingRepository.findAll().toString();
    }
}
