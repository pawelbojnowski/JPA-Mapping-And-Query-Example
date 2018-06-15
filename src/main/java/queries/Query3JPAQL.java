package queries;

import connection.AbstractAction;
import connection.EMF;
import queries.entity.Error;
import queries.entity.ErrorType;

import javax.persistence.EntityManager;
import java.util.List;

public class Query3JPAQL extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        List<Error> result = entityManager.createQuery("select r from Error r", Error.class).getResultList();
        printResult("Error", result);

        List<Integer> resultId = entityManager.createQuery("select r.id from Error r", Integer.class).getResultList();
        printResult("Error.id", resultId);

        List<Error> resultWhere = entityManager.createQuery("select  r from Error r where r.id>2 ", Error.class).getResultList();
        printResult("resultWhere id > 2", resultWhere);

        List<ErrorType> resultGroupBy = entityManager.createQuery("select r.errorType from Error r GROUP BY r.errorType", ErrorType.class).getResultList();
        printResult("result Group By errorType", resultGroupBy);

        List<Error> resultOrderBy = entityManager.createQuery("select r from Error r order by r.id desc", Error.class).getResultList();
        printResult("result resultOrderBy By id", resultOrderBy);

        List<Error> resultIn = entityManager.createQuery("select r from Error r where r.id in (2,3,5,4)", Error.class).getResultList();
        printResult("result In id", resultIn);

        List<Error> resultLike = entityManager.createQuery("select r from Error r where r.name like 'NaMe 1' ", Error.class).getResultList();
        printResult("result like id", resultLike);

        List<Error> resultHaving = entityManager.createQuery("select r from Error r left join r.childErrors ce group by r HAVING count(ce) > 0 ", Error.class).getResultList();
        printResult("result having id", resultHaving);

        List<Error> resultJoin = entityManager.createQuery("select distinct r from Error r left join r.childErrors", Error.class).getResultList();
        printResult("result like id", resultJoin);


        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();

    }

}
