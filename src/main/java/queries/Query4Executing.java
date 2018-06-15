package queries;

import connection.AbstractAction;
import connection.EMF;
import queries.entity.Error;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.List;

public class Query4Executing extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();
        final int id = 2;

        //list of object - can be empty
        List<Error> result = entityManager.createQuery("select r from Error r", Error.class).getResultList();
        printResult("Error", result);

        //if we expect specific result and exist :)
        {
            Error singleResult = entityManager.createQuery("select r from Error r where id=1", Error.class).getSingleResult();
            System.out.println(singleResult);
        }

        //if we expect specific result BUT EXIST :(
        try {
            Error singleResult = entityManager.createQuery("select r from Error r where id=111", Error.class).getSingleResult();
            System.out.println(singleResult);
        } catch (NoResultException e) {
            System.out.println("NoResultException");
        }

        //if we expect specific result (one) BUT a query allows return mor than one:(
        try {
            Error singleResult = entityManager.createQuery("select r from Error r where r.description like '%description %' ", Error.class).getSingleResult();
            System.out.println(singleResult);
        } catch (NonUniqueResultException e) {
            System.out.println("NonUniqueResultException");
        }

        //execution update/delete
        entityManager.createQuery("Update from Error r set r.name = 'nowa nazwa'").executeUpdate();
        entityManager.clear();
        printResult("Error", result);
        List<Error> update = entityManager.createQuery("select r from Error r", Error.class).getResultList();
        printResult("Error", update);


        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();

    }

}
