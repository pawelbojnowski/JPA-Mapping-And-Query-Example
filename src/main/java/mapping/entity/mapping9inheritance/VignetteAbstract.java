package mapping.entity.mapping9inheritance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(schema = "mapping_9_inheritance")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VignetteAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id  per table
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
        return "VignetteAbstract{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
