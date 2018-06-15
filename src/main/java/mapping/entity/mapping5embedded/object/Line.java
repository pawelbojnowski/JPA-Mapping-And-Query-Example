package mapping.entity.mapping5embedded.object;

import javax.persistence.*;


@Entity
@Table(schema = "mapping_5_embedded")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Point startPoint;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "x", column = @Column(name = "end_x")), @AttributeOverride(name = "y", column = @Column(name = "end_y"))})
    private Point endPoint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
