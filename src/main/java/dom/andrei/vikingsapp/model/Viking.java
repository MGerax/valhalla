package dom.andrei.vikingsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "vikings")
public class Viking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vikings_id_seq")
    private Long id;
    private String name;
    private String nickname;
    private Date birthday;
    //??? private Viking parent;
    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;
}
