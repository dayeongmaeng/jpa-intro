package hellojpa;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Addreess {

    private String city;
    private String street;
    private String zipcode;

    public Addreess() {
    }

    public Addreess(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addreess addreess = (Addreess) o;
        return Objects.equals(city, addreess.city) && Objects.equals(street, addreess.street) && Objects.equals(zipcode, addreess.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
