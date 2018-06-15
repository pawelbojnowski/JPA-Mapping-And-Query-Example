package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping2manytoone.Item;
import mapping.entity.mapping2manytoone.Order;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class Mapping2ManyToOne extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();

        addListItemsToOrder(entityManager);
        System.out.println(SEPARATOR_STARS);
        addOrderToItem(entityManager);
        EMF.close();
    }

    private static void addListItemsToOrder(EntityManager entityManager) {
        Item item = new Item();
        item.setTitle("addListItemsToOrder");

        Set<Item> list = new HashSet<Item>();
        list.add(item);

        Order order = new Order();
        order.setItems(list);
        item.setOrder(order);

        entityManager.getTransaction().begin();
        entityManager.persist(item);

        entityManager.getTransaction().commit();
        entityManager.clear();

        executeJpaSql(entityManager, "select o from Order o ", "Order");
        executeJpaSql(entityManager, "select i from Item i ", "Item");
    }

    private static void addOrderToItem(EntityManager entityManager) {

        entityManager.getTransaction().begin();

        Order order = new Order();

        Item item = new Item();
        item.setTitle("addOrderToItem");
        item.setOrder(order);

        entityManager.persist(item);
        entityManager.getTransaction().commit();
        entityManager.clear();

        executeJpaSql(entityManager, "select o from Order o ", "Order");
        executeJpaSql(entityManager, "select o from Item o ", "Item");

    }
}
