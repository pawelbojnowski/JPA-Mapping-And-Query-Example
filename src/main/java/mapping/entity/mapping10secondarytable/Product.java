package mapping.entity.mapping10secondarytable;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "mapping_10_secondary_table")
@SecondaryTable(name = "category", schema = "mapping_10_secondary_table",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id_product"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(table = "category", name = "name")
    private String CategoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CategoryName='" + CategoryName + '\'' +
                '}';
    }
}
