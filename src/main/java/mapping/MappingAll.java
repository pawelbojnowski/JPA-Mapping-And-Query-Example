package mapping;

import connection.AbstractAction;

public class MappingAll extends AbstractAction {

    public static void main(String... arg) {
        Mapping1BasicEntity.main();
        Mapping2ManyToOne.main();
        Mapping3ManyToMany.main();
        Mapping4OneToOne.main();
        Mapping5Embedded.main();
        Mapping6Collections.main();
        Mapping7CollectionsMap.main();
        Mapping8IdClass.main();
        Mapping9Inheritance.main();
        Mapping10SecondaryTable.main();
    }

}
