package mapping.entity.mapping6collection;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class AttachmentEmbedded implements Serializable {
    private String title;
    private String source;

    public AttachmentEmbedded(String title, String source) {
        this.title = title;
        this.source = source;
    }

    public AttachmentEmbedded() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "AttachmentEmbedded{" +
                "title='" + title + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
