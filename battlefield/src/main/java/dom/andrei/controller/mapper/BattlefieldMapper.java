package dom.andrei.controller.mapper;

import dom.andrei.controller.dto.BattlefieldGetDTO;
import dom.andrei.controller.dto.BattlefieldSaveDTO;
import dom.andrei.model.Battlefield;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface BattlefieldMapper {
    BattlefieldMapper INSTANCE = Mappers.getMapper(BattlefieldMapper.class);

    BattlefieldGetDTO toDto(Battlefield from);

    default Battlefield fromDto(BattlefieldSaveDTO from) {
        return Battlefield.builder()
            .startDate(new Date())
            .attacking(Battlefield.BattleParticipantInfo.builder()
                .villageId(from.villageAttackingId())
                .build())
            .defending(Battlefield.BattleParticipantInfo.builder()
                .villageId(from.villageDefendingId())
                .build())
            .build();
    }
}
