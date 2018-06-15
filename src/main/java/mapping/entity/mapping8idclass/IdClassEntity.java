package mapping.entity.mapping8idclass;

import java.io.Serializable;


public class IdClassEntity implements Serializable {

    private String country;
    private String name;

    public IdClassEntity(String country, String name) {
        this.country = country;
        this.name = name;
    }

    public IdClassEntity() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IdClassEntity that = (IdClassEntity) o;

        if (country != null ? !country.equals(that.country) : that.country != null) {
            return false;
        }
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IdClassEntity{" +
                "country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
