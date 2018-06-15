package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping4onetoone.ParkingPlace;
import mapping.entity.mapping4onetoone.Vehicle;

import javax.persistence.EntityManager;

public class Mapping4OneToOne extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        Vehicle vehicle = new Vehicle();
        ParkingPlace parkingPlace = new ParkingPlace();

        entityManager.merge(vehicle);
        entityManager.merge(parkingPlace);

        entityManager.getTransaction().commit();
        entityManager.clear();

        executeJpaSql(entityManager, "select pp from ParkingPlace pp", "ParkingPlace");
        executeJpaSql(entityManager, "select v from Vehicle v", "Vehicle");

        entityManager.clear();
        EMF.close();
    }

}
