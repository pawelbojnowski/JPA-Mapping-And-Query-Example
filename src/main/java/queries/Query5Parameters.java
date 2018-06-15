package queries;

import connection.AbstractAction;
import connection.EMF;
import queries.entity.Error;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Query5Parameters extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();
        final int id = 2;


        String sql = "select r from Error r where r.id = " + id;
        List<Error> result_not_professional = entityManager.createQuery(sql, Error.class).getResultList();
        printResult("Error bad way", result_not_professional);


        Query query = entityManager.createQuery("select r from Error r where r.id = :id", Error.class);
        query.setParameter("id", id);

        List<Error> result_String_key = query.getResultList();
        printResult("Error string key", result_String_key);

        Query query2 = entityManager.createQuery("select r from Error r where r.id = ?1", Error.class);
        query2.setParameter(1, id);

        List<Error> result_number_key = query2.getResultList();
        printResult("Error number key", result_number_key);


        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();

    }

}
