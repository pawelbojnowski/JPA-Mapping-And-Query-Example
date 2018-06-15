package queries.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "simple_error", schema = "queries")
public class SimpleError {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Date createdDate = new Date();


    public SimpleError() {
    }

    public SimpleError(String name, String description, Date createdDate) {
        System.out.println("SimpleError - constructor");
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "SimpleError{" +
                "createdDate=" + createdDate +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
