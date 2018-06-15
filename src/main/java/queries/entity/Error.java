package queries.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "error", schema = "queries")

@NamedQueries({
        @NamedQuery(name = "Error.all", query = "select e from Error e")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Error.all.native", query = "SELECT * FROM queries.error "),
        @NamedNativeQuery(name = "Error.allMapper.native", query = "SELECT id , name, description, createdDate  FROM queries.error")
})


@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Error",
                entities = {
                        @EntityResult(entityClass = Error.class
                                ,
                                fields = {
                                        @FieldResult(name = "id", column = "id"),
                                        @FieldResult(name = "name", column = "description"),
                                        @FieldResult(name = "description", column = "name"),
                                        @FieldResult(name = "createdDate", column = "createdDate"),
                                        @FieldResult(name = "errorType", column = "errorType"),
                                        @FieldResult(name = "level", column = "level"),
                                        @FieldResult(name = "parentError", column = "parent_error_id")

                                }
                        )}
        ),
        @SqlResultSetMapping(
                name = "SimpleError",
                entities = {
                        @EntityResult(entityClass = SimpleError.class
                                ,
                                fields = {
                                        @FieldResult(name = "id", column = "id"),
                                        @FieldResult(name = "name", column = "description"),
                                        @FieldResult(name = "description", column = "name"),
                                        @FieldResult(name = "createdDate", column = "createdDate")
                                }
                        )}
        ),
})
public class Error {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Date createdDate = new Date();
    private Integer level;
    @Enumerated
    private ErrorType errorType;

    @JoinColumn(name = "parent_error_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Error parentError;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "parentError", fetch = FetchType.EAGER)
    private Set<Error> childErrors;


    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public Error getParentError() {
        return parentError;
    }

    public void setParentError(Error parentError) {
        this.parentError = parentError;
    }

    public Set<Error> getChildErrors() {
        return childErrors;
    }

    public void setChildErrors(Set<Error> childErrors) {
        this.childErrors = childErrors;
    }

    @Override
    public String toString() {
        return "Error{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", level=" + level +
                ", errorType=" + errorType +
                ", parentError=" + (parentError != null ? parentError.id : "null") +
                ", childErrors=" + (childErrors != null ? childErrors.size() : "0") +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Error error = (Error) o;

        if (id != null ? !id.equals(error.id) : error.id != null) return false;
        if (name != null ? !name.equals(error.name) : error.name != null) return false;
        if (description != null ? !description.equals(error.description) : error.description != null) return false;
        if (createdDate != null ? !createdDate.equals(error.createdDate) : error.createdDate != null) return false;
        if (level != null ? !level.equals(error.level) : error.level != null) return false;
        if (errorType != error.errorType) return false;
        if (parentError != null ? !parentError.equals(error.parentError) : error.parentError != null) return false;
        return !(childErrors != null ? !childErrors.equals(error.childErrors) : error.childErrors != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (errorType != null ? errorType.hashCode() : 0);
        return result;
    }
}
