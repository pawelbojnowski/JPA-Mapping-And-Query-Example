package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping8idclass.City;
import mapping.entity.mapping8idclass.IdClassEntity;

import javax.persistence.EntityManager;

public class Mapping8IdClass extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();

        City employee = new City();
        employee.setCountry("Poland");
        employee.setName("Warszawa");

        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.clear();

        IdClassEntity idClassEntity = new IdClassEntity("Poland", "Warszawa");

        City newClassEntity = entityManager.find(City.class, idClassEntity);
        System.out.println(idClassEntity);
        System.out.println(newClassEntity);

        entityManager.close();
        EMF.close();
    }

}
