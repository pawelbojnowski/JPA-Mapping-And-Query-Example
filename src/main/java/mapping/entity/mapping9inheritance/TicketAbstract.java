package mapping.entity.mapping9inheritance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(schema = "mapping_9_inheritance")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TicketAbstract implements Serializable {

    @TableGenerator(name = "ticket_abstract", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1, schema = "mapping_9_inheritance")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ticket_abstract") //id  per table
    private int id;

    @Column(name = "created_date")
    private Date createdDate = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "TicketAbstract{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
