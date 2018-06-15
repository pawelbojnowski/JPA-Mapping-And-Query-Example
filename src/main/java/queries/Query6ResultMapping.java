package queries;

import connection.AbstractAction;
import connection.EMF;
import queries.entity.Error;
import queries.entity.SimpleError;
import queries.utils.ErrorModel;

import javax.persistence.EntityManager;
import java.util.List;

public class Query6ResultMapping extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();


        //pojo class - ErrorModel is NOT entity class
        List<ErrorModel> errorModel = entityManager.createQuery("select new queries.utils.ErrorModel(r.id, r.name, r.description, r.createdDate) from Error r", ErrorModel.class).getResultList();
        printResult("1. ErrorModel", errorModel);
        entityManager.clear();

        List<Error> errorMapper = entityManager.createNativeQuery("SELECT *  FROM queries.error ", "Error").getResultList();
        printResult("2. Error", errorMapper);

        List<SimpleError> simpleErrorsMapper = entityManager.createNativeQuery("SELECT   id , name, description, createdDate  FROM queries.error ", "SimpleError").getResultList();
        printResult("3. Simple Error dynamic query", simpleErrorsMapper);
        entityManager.clear();


        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();

    }

}
