package dom.andrei.controller.dto;

import java.util.Date;

public record VikingSaveDTO(String name, String nickname, Date birthday, Long villageId) {
}
