package dom.andrei.controller.mapper;

import dom.andrei.controller.dto.BattlefieldGetDTO;
import dom.andrei.controller.dto.BattlefieldSaveDTO;
import dom.andrei.model.Battlefield;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattlefieldMapperTest {
    @Test
    void test_toDto() {
        Date startDate = new Date();
        Date finishDate = new Date();
        Battlefield from = Battlefield.builder()
            .id(1L)
            .attacking(Battlefield.BattleParticipantInfo.builder()
                .villageId(11L)
                .deathCount(101L)
                .build())
            .defending(Battlefield.BattleParticipantInfo.builder()
                .villageId(12L)
                .deathCount(102L)
                .build())
            .startDate(startDate)
            .finishDate(finishDate)
            .build();

        BattlefieldGetDTO actualDto = BattlefieldMapper.INSTANCE.toDto(from);

        assertAll(
            () -> assertEquals(from.getId(), actualDto.getId()),
            () -> assertEquals(from.getStartDate(), actualDto.getStartDate()),
            () -> assertEquals(from.getAttacking().getVillageId(), actualDto.getAttacking().villageId()),
            () -> assertEquals(from.getAttacking().getDeathCount(), actualDto.getAttacking().deathCount()),
            () -> assertEquals(from.getDefending().getVillageId(), actualDto.getDefending().villageId()),
            () -> assertEquals(from.getDefending().getDeathCount(), actualDto.getDefending().deathCount())
        );

    }

    @Test
    void test_fromDto() {
        long villageAttackingId = 11;
        long villageDefendingId = 12;
        Date currentDate = new Date();
        BattlefieldSaveDTO from = new BattlefieldSaveDTO(villageAttackingId, villageDefendingId);

        Battlefield actual = BattlefieldMapper.INSTANCE.fromDto(from);

        assertAll(
            () -> assertNull(actual.getId()),
            () -> assertTrue(currentDate.before(actual.getStartDate())), // TODO: try to avoid floating if it is so
            () -> assertNull(actual.getFinishDate()),
            () -> assertEquals(villageAttackingId, actual.getAttacking().getVillageId()),
            () -> assertEquals(0, actual.getAttacking().getDeathCount()),
            () -> assertEquals(villageDefendingId, actual.getDefending().getVillageId()),
            () -> assertEquals(0, actual.getDefending().getDeathCount())
        );
    }
}