package connection;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractAction {

    protected static final String NEW_LINE = "\n";
    protected static final String SIZE = "[size= ?]";
    protected static final String SEPARATOR =
            "----------------------------------------------------------------------------------------------------------------------------------------------------------";
    protected static final String SEPARATOR_STARS =
            "\n********************************************************************************************************************************************************\n";

    protected static void executeJpaSql(EntityManager entityManager, String sql, String text) {
        System.out.println(NEW_LINE);
        List<Object> list = entityManager.createQuery(sql).getResultList();
        printResult(text, list);
    }

    protected static void printResult(String text, List list) {
        System.out.println(text + SIZE.replace("?", String.valueOf(list.size())));
        System.out.println(SEPARATOR);
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println(SEPARATOR);
    }

    protected static void executeNativeSql(EntityManager entityManager, String sql, String text) {
        System.out.println(NEW_LINE);
        List<Object> list = entityManager.createNativeQuery(sql).getResultList();
        System.out.println(text + SIZE.replace("?", String.valueOf(list.size())));
        System.out.println(SEPARATOR);
        for (Object o : list) {
            Object[] row = (Object[]) o;
            for (Object c : row) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
        System.out.println(SEPARATOR);
    }
}
