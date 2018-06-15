package mapping.entity.mapping1baseentity;

import javax.persistence.*;

@Entity
@Table(name = "t_car", schema = "mapping_1_basic_entity")
//@Access(AccessType.FIELD)
public class Car {

    // ID RULES
    //    • Primitive Java types: byte, int, short, long, char
    //    • Wrapper classes of primitive Java types: Byte, Integer, Short, Long, Character
    //    • String: java.lang.String
    //    • Large numeric type: java.math.BigInteger
    //    • Temporal types: java.util.Date, java.sql.Date
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "c_name_of_producer", nullable = false, columnDefinition = "text")
    private String brand;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(columnDefinition = "text")
    private String model;

    @Transient
    private String someValue = "some value";

    @Enumerated(EnumType.STRING) //default ORDINAL
    private CarTyp carTyp;

    @Enumerated(EnumType.ORDINAL) //default ORDINAL
    private CarTyp carTyp2;

    // TYPE RULES
    //    • Primitive Java types: byte, int, short, long, boolean, char, float, double
    //    • Wrapper classes of primitive Java types: Byte, Integer, Short, Long, Boolean,
    //    Character, Float, Double
    //    • Byte and character array types: byte[], Byte[], char[], Character[]
    //    • Large numeric types: java.math.BigInteger, java.math.BigDecimal
    //    • Strings: java.lang.String
    //    • Java temporal types: java.util.Date, java.util.Calendar
    //    • JDBC temporal types: java.sql.Date, java.sql.Time, java.sql.Timestamp
    //    • Enumerated types: Any system or user-defined enumerated type
    //    • Serializable objects: Any system or user-defined serializable type

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public CarTyp getCarTyp() {
        return carTyp;
    }

    public void setCarTyp(CarTyp carTyp) {
        this.carTyp = carTyp;
    }

    public CarTyp getCarTyp2() {
        return carTyp2;
    }

    public void setCarTyp2(CarTyp carTyp2) {
        this.carTyp2 = carTyp2;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", someValue='" + someValue + '\'' +
                ", carTyp=" + carTyp +
                ", carTyp2=" + carTyp2 +
                '}';
    }
}
