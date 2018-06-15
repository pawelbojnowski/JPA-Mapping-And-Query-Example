package mapping.entity.mapping5embedded.id;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class UserIdentifier implements Serializable {

    private String email;
    private Integer pesel;

    public UserIdentifier() {

    }

    public UserIdentifier(String email, Integer pesel) {
        this.email = email;
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "UserIdentifier{" +
                "email='" + email + '\'' +
                ", pesel=" + pesel +
                '}';
    }
}
