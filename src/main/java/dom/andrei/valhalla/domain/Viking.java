package dom.andrei.valhalla.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "vikings")
public class Viking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date birthday;
    @ManyToMany
    @JoinTable(
            name = "viking_devotion_map",
            joinColumns = @JoinColumn(name = "viking_id"),
            inverseJoinColumns = @JoinColumn(name = "devotion_id"))
    private Set<Devotion> devotions;

    @Override
    public String toString() {
        return String.format("{'id': %s," +
                " 'name': %s," +
                " 'birthday': %s," +
                " 'devotion': [%s]}", this.id, this.name, this.birthday, this.devotions);
    }
}
