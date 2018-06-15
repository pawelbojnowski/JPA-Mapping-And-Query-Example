package mapping.entity.mapping1baseentity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_car_custom_generator_id", schema = "mapping_1_base_entity")
public class CarCustomGeneratorId {

    @Id
    @GenericGenerator(name = "seq_id", strategy = "mapping.entity.mapping1baseentity.CustomGenerator")
    @GeneratedValue(generator = "seq_id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarUUID{" +
                "id='" + id + '\'' +
                '}';
    }
}
