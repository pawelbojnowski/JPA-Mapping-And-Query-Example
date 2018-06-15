package mapping.entity.mapping9inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "mapping_9_inheritance")
public class TicketRegular extends TicketAbstract implements Serializable {

    private Integer name;

    @Column(name = "start_date")
    private Date startDate = new Date();
    @Column(name = "end_Date")
    private Date endDate = new Date();

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

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
        return "TicketRegular{" +
                "name=" + name +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
