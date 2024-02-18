package dom.andrei.controller;

import dom.andrei.model.Viking;
import dom.andrei.service.VikingService;
import dom.andrei.controller.dto.VikingGetDTO;
import dom.andrei.controller.dto.VikingSaveDTO;
import dom.andrei.controller.exception.ResourceNotFoundException;
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
public class VikingController {
    private final VikingService vikingService;

    @PostMapping("vikings")
    public long save(@RequestBody VikingSaveDTO vikingDTO) {
        var viking = new Viking();
        viking.setName(vikingDTO.name());
        viking.setNickname(vikingDTO.nickname());
        viking.setBirthday(vikingDTO.birthday());
        //viking.setVillage(vikingDTO.villageId());
        return vikingService.save(viking);
    }

    @GetMapping("vikings/{id}")
    public VikingGetDTO findById(@PathVariable long id) {
        Viking viking = vikingService.findById(id).orElseThrow(() ->
            new ResourceNotFoundException(HttpStatus.NOT_FOUND, "viking is not found"));
        return new VikingGetDTO(viking.getId(), viking.getName(), viking.getNickname(), viking.getBirthday(), viking.getVillage());
    }

    @GetMapping("vikings")
    public Set<VikingGetDTO> findAll() {
        return vikingService.findAll().stream().map(viking -> new VikingGetDTO(viking.getId(), viking.getName(),
            viking.getNickname(), viking.getBirthday(), viking.getVillage())).collect(Collectors.toSet());
    }

    @DeleteMapping("vikings/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        vikingService.delete(id);
    }
}
