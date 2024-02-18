package dom.andrei.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@Data
@Builder
@RedisHash(value = "Battlefield", timeToLive = 60)
public class Battlefield {
    private Long id;
    private BattleParticipantInfo attacking;
    private BattleParticipantInfo defending;
    private Date startDate;
    private Date finishDate;

    @Data
    @Builder
    public static class BattleParticipantInfo {
        private final long villageId;
        private long deathCount;
    }
}
