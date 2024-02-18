package dom.andrei.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "devotions")
public class Devotion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "devotions_id_seq")
    private Long id;
    private String name;
}
