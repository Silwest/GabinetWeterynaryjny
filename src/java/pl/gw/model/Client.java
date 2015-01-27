/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import pl.gw.domain.SupplyType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.primefaces.model.ScheduleEvent;

/**
 *
 * @author Putas
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT s FROM Client s ORDER BY s.id ASC"),
    @NamedQuery(name = "Client.findMaxID", query = "SELECT s.id FROM Client s"),
    @NamedQuery(name = "Client.findByLastName", query = "SELECT s FROM Client s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Client.findById", query = "SELECT s FROM Client s WHERE s.id = :id"),})
public class Client implements Serializable {

    public static final String FIND_ALL = "Client.findAll";
    public static final String FIND_BY_ID = "Client.findById";
    public static final String FIND_BY_LAST_NAME = "Client.findByLastName";
    public static final String FIND_MAX_ID = "Client.findMaxID";

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = false, nullable = false, length = 32)
    private String lastName;

    @Column(unique = false, nullable = false, length = 32)
    private String firstName;

    @Column(unique = false, nullable = false, length = 100)
    private String adress;

    @Column(unique = false, nullable = false, length = 6)
    private String zipCode;

    @Column(unique = false, nullable = false, length = 100)
    private String locality;

    @Column(unique = true, nullable = false, length = 9)
    private String phoneNumber;

    @OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER, targetEntity = Animal.class)
    private List<Animal> animals;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, targetEntity = Visit.class)
    private List<Visit> visit;

    public List<Visit> getVisit() {
        return visit;
    }

    public void setVisit(List<Visit> visit) {
        this.visit = visit;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Client() {

    }

    public Client(String n, String i, String ad, String zc, String ph, String msc) {
        this.firstName = i;
        this.lastName = n;
        this.adress = ad;
        this.locality = msc;
        this.zipCode = zc;
        this.phoneNumber = ph;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", FirstName=" + firstName + " " + lastName + ", adress " + adress + " " + zipCode + " " + locality + " " + phoneNumber + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
