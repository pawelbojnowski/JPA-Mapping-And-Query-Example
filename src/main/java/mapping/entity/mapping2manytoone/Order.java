package mapping.entity.mapping2manytoone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "order", schema = "mapping_2_many_to_one")
// encja nadrzedna
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order", fetch = FetchType.EAGER)
    // wiazanie jedno kierunkowe
    // @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    // @JoinColumn(name = "item_id")
    private Set<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
