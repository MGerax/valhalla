package dom.andrei.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "villages")
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "villages_id_seq")
    private Long id;
    private String name;
    private Integer population;
}
