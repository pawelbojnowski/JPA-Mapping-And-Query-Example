package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EMF {

    private static String MYSQL = "PersistenceUnitMYSQL";
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static EntityManager instanceEntityManager() {
        if (emf == null || (emf != null && !emf.isOpen())) {
            emf = Persistence.createEntityManagerFactory(MYSQL);
        }
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
