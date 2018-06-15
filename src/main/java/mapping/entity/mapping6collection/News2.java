package mapping.entity.mapping6collection;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "mews2", catalog = "mapping_6_collections")
public class News2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "tag2", schema = "mapping_6_collections")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "News{" +
                "\n\tid=" + id +
                ",\n\ttags=" + tags +
                "\n}";
    }
}
