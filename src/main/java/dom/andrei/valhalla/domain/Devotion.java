package dom.andrei.valhalla.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "devotions")
public class Devotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("name")
    private String name;

    @Override
    public String toString() {
        return String.format("{'id': %s," +
                " 'name': %s}", this.id, this.name);
    }
}
