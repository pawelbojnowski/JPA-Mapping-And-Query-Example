package mapping.entity.mapping4onetoone;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle", schema = "mapping_4_one_to_one")
//encja nadrzedna/wlasciciel
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_place_id")
    @PrimaryKeyJoinColumn
    private ParkingPlace parkingPlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingPlace getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", parkingPlace=" + parkingPlace.toString() +
                '}';
    }
}
