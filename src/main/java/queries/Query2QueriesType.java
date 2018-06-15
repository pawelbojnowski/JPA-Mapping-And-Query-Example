package queries;

import connection.AbstractAction;
import connection.EMF;
import queries.entity.Error;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Query2QueriesType extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        //Dynamic - jpa ql
        List<Error> jpaQl = entityManager.createQuery("select r from Error r", Error.class).getResultList();
        printResult("JPA QL", jpaQl);
        entityManager.clear();

        //Dynamic - natywne
        List<Object> nativeQuery = entityManager.createNativeQuery("select * from queries.error ").getResultList();
        printResult("Native", nativeQuery);
        entityManager.clear();

        List<Error> nativeQueryToEntity = entityManager.createNativeQuery("select * from queries.error as r ", Error.class).getResultList(); // automatyczna konversja
        printResult("Native - convert to Error", nativeQueryToEntity);
        entityManager.clear();

        //Defined in entity - JPA QL
        List<Error> namedQuery = entityManager.createNamedQuery("Error.all", Error.class).getResultList();
        printResult("Named JPA QL", namedQuery);
        entityManager.clear();

        //Defined - naive
        List namedNativeQuery = entityManager.createNamedQuery("Error.all.native").getResultList();
        printResult("Named native", namedNativeQuery);
        entityManager.clear();

        //Defined - CriteriaQuery (select r from Error r)
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Error> cq = cb.createQuery(Error.class);
        Root<Error> pet = cq.from(Error.class);
        cq.select(pet);
        TypedQuery<Error> q = entityManager.createQuery(cq); //select generatedAlias0 from Error as generatedAlias0
        List<Error> criteriaQuery = q.getResultList();

        printResult("Criteria query", criteriaQuery);

        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();

    }

}
