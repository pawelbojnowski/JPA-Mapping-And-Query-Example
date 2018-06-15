package mapping.entity.mapping2manytoone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "item", schema = "mapping_2_many_to_one")
//encja podrzedna/wlasciciel
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Date creationDate = new Date();

    @JoinColumn(name = "order_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    // przy wiazaniu jedno kieerunkowym brak mozliwosc kaskadowosci
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", order=" + order.getId() +
                '}';
    }
}
