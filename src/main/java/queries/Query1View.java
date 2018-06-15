package queries;

import connection.AbstractAction;
import connection.EMF;
import queries.entity.ErrorView;

import javax.persistence.EntityManager;
import java.util.List;

public class Query1View extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        List<ErrorView> jpaQl = entityManager.createQuery("select r from ErrorView r", ErrorView.class).getResultList();
        printResult("ErrorView", jpaQl);
        entityManager.clear();


//        java.sql.SQLException: The target table error_view of the INSERT is not insertable-into
//        ErrorView errorView = new ErrorView();
//        errorView.setId(222);
//        entityManager.persist(errorView);


        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();

    }

}
