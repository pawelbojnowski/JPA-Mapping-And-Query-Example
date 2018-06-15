package mapping.entity.mapping7collectionmap;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class PhoneDetailsEmbedded implements Serializable {

    private Integer number;
    private String description;

    public PhoneDetailsEmbedded(Integer number, String description) {
        this.number = number;
        this.description = description;
    }

    public PhoneDetailsEmbedded() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PhoneDetailsEmbedded{" +
                "number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
