package mapping.entity.mapping3manytomany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "people", schema = "mapping_3_many_to_many")
//encja nadrzedna/wlasciciel
public class People implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "group_people", schema = "mapping_3_many_to_many",
            joinColumns = @JoinColumn(name = "people_ID"),
            inverseJoinColumns = @JoinColumn(name = "group_ID"))

    private Set<Group> groups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", groups=" + groups.size() +
                '}';
    }
}
