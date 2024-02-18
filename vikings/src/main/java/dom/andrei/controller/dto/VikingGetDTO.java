package dom.andrei.controller.dto;

import dom.andrei.model.Village;

import java.util.Date;

public record VikingGetDTO(long id, String name, String nickname, Date birthday, Village village) {
}
