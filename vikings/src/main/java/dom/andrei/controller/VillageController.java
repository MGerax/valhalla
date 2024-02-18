package dom.andrei.controller;

import dom.andrei.model.Village;
import dom.andrei.controller.dto.VillageGetDTO;
import dom.andrei.controller.dto.VillageSaveDTO;
import dom.andrei.controller.exception.ResourceNotFoundException;
import dom.andrei.service.VillageService;
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
public class VillageController {
    private final VillageService villageService;

    @PostMapping("villages")
    public long save(@RequestBody VillageSaveDTO villageDTO) {
        var village = new Village();
        village.setName(villageDTO.name());
        village.setPopulation(villageDTO.population());
        return villageService.save(village);
    }

    @GetMapping("villages/{id}")
    public VillageGetDTO findById(@PathVariable long id) {
        Village village = villageService.findById(id).orElseThrow(() ->
            new ResourceNotFoundException(HttpStatus.NOT_FOUND, "village is not found"));
        return new VillageGetDTO(village.getId(), village.getName(), village.getPopulation());
    }

    @GetMapping("villages")
    public Set<VillageGetDTO> findAll() {
        return villageService.findAll().stream().map(village ->
            new VillageGetDTO(village.getId(), village.getName(), village.getPopulation())).collect(Collectors.toSet());
    }

    @DeleteMapping("villages/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        villageService.delete(id);
    }
}
