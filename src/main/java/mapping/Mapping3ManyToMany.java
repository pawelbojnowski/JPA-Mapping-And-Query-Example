package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping3manytomany.Group;
import mapping.entity.mapping3manytomany.People;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class Mapping3ManyToMany extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        Group group1 = new Group();
        Group group2 = new Group();

        Set<Group> groups = new HashSet<Group>();
        groups.add(group1);
        groups.add(group2);

        People people = new People();
        people.setGroups(groups);

        entityManager.persist(people);

        entityManager.getTransaction().commit();
        entityManager.clear();

        executeJpaSql(entityManager, "select p from People p ", "People");
        executeJpaSql(entityManager, "select g from Group g ", "Group");
        EMF.close();
    }

}
