package mapping.entity.mapping6collection;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "mews", catalog = "mapping_6_collections")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "tag", schema = "mapping_6_collections")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> tags;

    @ElementCollection(targetClass = Attachment.class)
    @CollectionTable(name = "attachment", schema = "mapping_6_collections")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Attachment> attachments; //  Serializable

    @ElementCollection(targetClass = AttachmentEmbedded.class)
    @CollectionTable(
            name = "attachments_embedded", schema = "mapping_6_collections",
            joinColumns = @JoinColumn(name = "attachmentEmbedded_id"))
    @AttributeOverride(name = "title",
            column = @Column(name = "title_of_attachment"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AttachmentEmbedded> attachmentEmbedded;

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

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<AttachmentEmbedded> getAttachmentEmbedded() {
        return attachmentEmbedded;
    }

    public void setAttachmentEmbedded(List<AttachmentEmbedded> attachmentEmbedded) {
        this.attachmentEmbedded = attachmentEmbedded;
    }

    @Override
    public String toString() {
        return "News{" +
                "\n\tid=" + id +
                ",\n\ttags=" + tags +
                ",\n\tattachments=" + attachments +
                ",\n\tattachmentEmbedded=" + attachmentEmbedded +
                "\n}";
    }
}
