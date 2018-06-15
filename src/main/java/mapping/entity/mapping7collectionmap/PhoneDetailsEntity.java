package mapping.entity.mapping7collectionmap;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(schema = "mapping_7_collections_map", name = "phone_Details_Entity")
public class PhoneDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private String description;
    @ManyToOne
    private Employee employee;

    public PhoneDetailsEntity(Integer number, String description, Employee employee) {
        this.number = number;
        this.description = description;
        this.employee = employee;
    }

    public PhoneDetailsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "PhoneDetailsEntity{" +
                "id=" + id +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", employee=" + employee +
                '}';
    }
}
