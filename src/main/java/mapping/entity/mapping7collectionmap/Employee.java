package mapping.entity.mapping7collectionmap;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Map;


@Entity
@Table(schema = "mapping_7_collections_map")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "_1_string_string", schema = "mapping_7_collections_map")
    @MapKeyColumn(name = "phone_type") //klucz
    @Column(name = "number")
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    private Map<String, String> phoneNumbers;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "_2_enum_string", schema = "mapping_7_collections_map")
    @MapKeyColumn(name = "phone_type")
    @Column(name = "number")
    @MapKeyEnumerated(EnumType.STRING) // must
    private Map<PhoneType, String> phoneNumbersEnum;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "_3_String_embeded", schema = "mapping_7_collections_map")
    @MapKeyColumn(name = "phone_type")
    @Column(name = "number")
    private Map<String, PhoneDetailsEmbedded> phoneDetailsEmbeddedList;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "_4_String_entity", schema = "mapping_7_collections_map")
    @MapKeyColumn(name = "phone_type")
    @OneToMany(cascade = CascadeType.ALL)
    private Map<String, PhoneDetailsEntity> phoneDetailsEntityList;

    @ElementCollection
    @CollectionTable(name = "_5_entity_string", schema = "mapping_7_collections_map")
    @MapKeyJoinColumn(name = "employee_id")
    @Column(name = "number")
    private Map<PhoneDetailsEntity2, String> phoneDetailsEntityAsKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Map<PhoneType, String> getPhoneNumbersEnum() {
        return phoneNumbersEnum;
    }

    public void setPhoneNumbersEnum(Map<PhoneType, String> phoneNumbersEnum) {
        this.phoneNumbersEnum = phoneNumbersEnum;
    }

    public Map<String, PhoneDetailsEmbedded> getPhoneDetailsEmbeddedList() {
        return phoneDetailsEmbeddedList;
    }

    public void setPhoneDetailsEmbeddedList(Map<String, PhoneDetailsEmbedded> phoneDetailsEmbeddeds) {
        this.phoneDetailsEmbeddedList = phoneDetailsEmbeddeds;
    }

    public Map<String, PhoneDetailsEntity> getPhoneDetailsEntityList() {
        return phoneDetailsEntityList;
    }

    public void setPhoneDetailsEntityList(Map<String, PhoneDetailsEntity> phoneDetailsEntitys) {
        this.phoneDetailsEntityList = phoneDetailsEntitys;
    }

    public Map<PhoneDetailsEntity2, String> getPhoneDetailsEntityAsKey() {
        return phoneDetailsEntityAsKey;
    }

    public void setPhoneDetailsEntityAsKey(Map<PhoneDetailsEntity2, String> phoneDetailsEntitysAsKey) {
        this.phoneDetailsEntityAsKey = phoneDetailsEntitysAsKey;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phoneNumbers=" + phoneNumbers +
                ", phoneNumbersEnum=" + phoneNumbersEnum +
                ", phoneDetailsEmbeddedList=" + phoneDetailsEmbeddedList +
                ", phoneDetailsEntityList=" + phoneDetailsEntityList +
                ", phoneDetailsEntityAsKey=" + phoneDetailsEntityAsKey +
                '}';
    }
}
