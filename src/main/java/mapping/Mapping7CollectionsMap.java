package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping7collectionmap.*;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

public class Mapping7CollectionsMap extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        Employee employee2 = new Employee();

        Map<String, String> phone = new HashMap<String, String>();
        phone.put("one", "1234560");
        phone.put("two", "1234560");
        phone.put("zero", "1234560");

        Map<String, String> phone2 = new HashMap<String, String>();
        phone2.put("one", "1234560");
        phone2.put("two", "1234560");
        phone2.put("zero", "1234560");

        Map<PhoneType, String> phoneEnum = new HashMap<PhoneType, String>();
        phoneEnum.put(PhoneType.HOME, "1234560");
        phoneEnum.put(PhoneType.MOBILE, "1234560");

        Map<String, PhoneDetailsEmbedded> phoneEmbedded = new HashMap<String, PhoneDetailsEmbedded>();
        phoneEmbedded.put("one", new PhoneDetailsEmbedded(123456, "Phone details"));
        phoneEmbedded.put("two", new PhoneDetailsEmbedded(123456, "Phone details"));
        phoneEmbedded.put("zero", new PhoneDetailsEmbedded(123456, "Phone details"));

        Map<String, PhoneDetailsEntity> phoneDetailsEntity = new HashMap<String, PhoneDetailsEntity>();
        phoneDetailsEntity.put("one", new PhoneDetailsEntity(123456, "Phone details", employee2));
        phoneDetailsEntity.put("two", new PhoneDetailsEntity(123456, "Phone details", employee2));
        phoneDetailsEntity.put("zero", new PhoneDetailsEntity(123456, "Phone details", employee2));

        Map<PhoneDetailsEntity2, String> phoneDetailsEntityAsKey = new HashMap<PhoneDetailsEntity2, String>();
        phoneDetailsEntityAsKey.put(entityManager.merge(new PhoneDetailsEntity2(123456, "Phone details", employee2)), "1_level");
        phoneDetailsEntityAsKey.put(entityManager.merge(new PhoneDetailsEntity2(123456, "Phone details", employee2)), "2_level");
        phoneDetailsEntityAsKey.put(entityManager.merge(new PhoneDetailsEntity2(123456, "Phone details", employee2)), "3_level");

        employee2.setPhoneNumbers(phone);
        employee2.setPhoneNumbersEnum(phoneEnum);
        employee2.setPhoneDetailsEmbeddedList(phoneEmbedded);
        employee2.setPhoneDetailsEntityList(phoneDetailsEntity);
        employee2.setPhoneDetailsEntityAsKey(phoneDetailsEntityAsKey);

        entityManager.persist(employee2);

        entityManager.clear();

        executeJpaSql(entityManager, "select e from Employee e", "Employee");
        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();
    }

}
