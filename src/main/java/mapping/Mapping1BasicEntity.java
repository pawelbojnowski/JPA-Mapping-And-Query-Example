package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping1baseentity.CarUUID;

import javax.persistence.EntityManager;

public class Mapping1BasicEntity extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();
//
//        Car car_bmw = new Car();
//        car_bmw.setBrand("BMW");
//        car_bmw.setModel("5 / F10");
//        entityManager.persist(car_bmw);
//
//        Car car_ferrari = new Car();
//        car_ferrari.setBrand("Ferrari");
//        car_ferrari.setModel("LaFerrari");
//        entityManager.persist(car_ferrari);

//
//        //uuid
//        String sql = "select c from Car c";
//        executeJpaSql(entityManager, sql, "Car");

        entityManager.persist(new CarUUID());
        entityManager.persist(new CarUUID());
        entityManager.persist(new CarUUID());


        String sql_uuid = "select c from CarUUID c";
        executeJpaSql(entityManager, sql_uuid, "CarUUID");

        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();

    }

}
