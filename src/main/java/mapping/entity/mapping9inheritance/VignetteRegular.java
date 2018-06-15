package mapping.entity.mapping9inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "mapping_9_inheritance")
public class VignetteRegular extends VignetteAbstract implements Serializable {

    @Column(name = "start_date")
    private Date startDate = new Date();
    @Column(name = "end_date")
    private Date endDate = new Date();

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "VignetteRegular{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
