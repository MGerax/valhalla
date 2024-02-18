package dom.andrei.controller;

import dom.andrei.controller.dto.BattlefieldGetDTO;
import dom.andrei.controller.dto.BattlefieldSaveDTO;
import dom.andrei.controller.exception.ResourceNotFoundException;
import dom.andrei.controller.mapper.BattlefieldMapper;
import dom.andrei.model.Battlefield;
import dom.andrei.service.BattlefieldService;
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
public class BattlefieldController {
    private final BattlefieldService battlefieldService;
    private final BattlefieldMapper mapper;

    @PostMapping("battlefields")
    public long save(@RequestBody BattlefieldSaveDTO battlefieldDTO) {
        return battlefieldService.save(mapper.fromDto(battlefieldDTO));
    }

    @GetMapping("battlefields/{id}")
    public BattlefieldGetDTO findById(@PathVariable long id) {
        Battlefield battlefield = battlefieldService.findById(id).orElseThrow(() ->
            new ResourceNotFoundException(HttpStatus.NOT_FOUND, "battlefield is not found"));
        return mapper.toDto(battlefield);
    }

    @GetMapping("battlefields")
    public Set<BattlefieldGetDTO> findAll() {
        return battlefieldService.findAll().stream().map(mapper::toDto).collect(Collectors.toSet());
    }

    @DeleteMapping("battlefields/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        battlefieldService.delete(id);
    }
}
