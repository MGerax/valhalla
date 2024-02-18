package dom.andrei.controller.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Builder
@Value
public class BattlefieldGetDTO {
    long id;
    BattleParticipantInfo attacking;
    BattleParticipantInfo defending;
    Date startDate;
    Date finishDate;

    @Builder
    public record BattleParticipantInfo(long villageId, long deathCount) {}
}
