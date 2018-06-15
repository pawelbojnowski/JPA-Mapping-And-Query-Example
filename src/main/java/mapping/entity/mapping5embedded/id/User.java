package mapping.entity.mapping5embedded.id;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(schema = "mapping_5_embedded")
public class User implements Serializable {

    @EmbeddedId
    private UserIdentifier userIdentifier;

    private Date date = new Date();

    public UserIdentifier getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(UserIdentifier userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserIdentifier=" + userIdentifier +
                ", date=" + date +
                '}';
    }
}
