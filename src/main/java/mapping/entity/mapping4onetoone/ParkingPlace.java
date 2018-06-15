package mapping.entity.mapping4onetoone;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "mapping_4_one_to_one")
//encja podrzedna
public class ParkingPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "parkingPlace", cascade = CascadeType.ALL)
    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "id=" + id +
                ", vehicle=" + vehicle.getId() +
                '}';
    }
}
