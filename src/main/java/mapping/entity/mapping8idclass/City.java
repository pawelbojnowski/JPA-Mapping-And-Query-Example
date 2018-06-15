package mapping.entity.mapping8idclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(schema = "mapping_8_id_class")
@IdClass(IdClassEntity.class)
public class City implements Serializable {

    @Id
    private String country;
    @Id
    private String name;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
