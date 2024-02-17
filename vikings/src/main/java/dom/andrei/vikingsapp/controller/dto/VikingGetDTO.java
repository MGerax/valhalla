package dom.andrei.vikingsapp.controller.dto;

import dom.andrei.vikingsapp.model.Village;

import java.util.Date;

public record VikingGetDTO(long id, String name, String nickname, Date birthday, Village village) {
}
