package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping10secondarytable.Product;

import javax.persistence.EntityManager;

//http://www.java2s.com/Tutorial/Java/0355__JPA/0340__Secondary-Table.htm
public class Mapping10SecondaryTable extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        Product secondaryTable = new Product();
        secondaryTable.setName("Product name");
        secondaryTable.setCategoryName("Category of product");
        entityManager.merge(secondaryTable);

        entityManager.getTransaction().commit();

        executeJpaSql(entityManager, "select p from Product p", "Product");

        entityManager.close();
        EMF.close();
    }

}
