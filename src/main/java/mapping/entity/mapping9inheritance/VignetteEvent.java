package mapping.entity.mapping9inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "mapping_9_inheritance")
public class VignetteEvent extends VignetteAbstract implements Serializable {

    @Column(name = "dead_line")
    private Date deadline;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
