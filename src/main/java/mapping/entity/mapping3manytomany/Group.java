package mapping.entity.mapping3manytomany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "group", schema = "mapping_3_many_to_many")
//encjca podrzedna
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<People> peoples;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(Set<People> peoples) {
        this.peoples = peoples;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", peoples=" + peoples.size() +
                '}';
    }
}
