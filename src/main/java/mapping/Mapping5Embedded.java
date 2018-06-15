package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping5embedded.id.User;
import mapping.entity.mapping5embedded.id.UserIdentifier;
import mapping.entity.mapping5embedded.object.Line;
import mapping.entity.mapping5embedded.object.Point;

import javax.persistence.EntityManager;

public class Mapping5Embedded extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();

        embeddedObject(entityManager);
        embeddedId(entityManager);

        entityManager.close();
        EMF.close();
    }

    private static void embeddedObject(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        Line line = new Line();
        line.setStartPoint(new Point(0, 1));
        line.setEndPoint(new Point(3, 4));

        entityManager.persist(line);
        executeJpaSql(entityManager, "select l from Line l ", "Line");
        executeNativeSql(entityManager, "select id, x, y, end_x, end_y from mapping_5_embedded.line ", "Line - native");
        entityManager.getTransaction().commit();
    }

    private static void embeddedId(EntityManager entityManager) {

        User user = new User();
        user.setUserIdentifier(new UserIdentifier("example@email.com", 2123456789));
        User user2 = new User();
        user2.setUserIdentifier(new UserIdentifier("example@email.com", 1123456789));

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.persist(user2);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        executeJpaSql(entityManager, "select o from User o ", "User");

    }

}
