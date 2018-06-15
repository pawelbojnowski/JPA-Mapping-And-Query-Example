package mapping.entity.mapping9inheritance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "client", schema = "mapping_9_inheritance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ClientAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        return "ClientAbstract{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
