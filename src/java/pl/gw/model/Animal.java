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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Putas
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT s FROM Animal s ORDER BY s.id ASC"),
    @NamedQuery(name = "Animal.findMaxID", query = "SELECT s.id FROM Animal s"),
    @NamedQuery(name = "Animal.findByLastName", query = "SELECT s FROM Animal s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Animal.findById", query = "SELECT s FROM Animal s WHERE s.id = :id"),})
public class Animal implements Serializable {

    public static final String FIND_ALL = "Animal.findAll";
    public static final String FIND_BY_ID = "Animal.findById";
    public static final String FIND_BY_LAST_NAME = "Animal.findByLastName";
    public static final String FIND_MAX_ID = "Animal.findMaxID";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client ownerID) {
        this.clientId = ownerID;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = false, nullable = false, length = 32)
    private String firstName;

    @Column(unique = false, nullable = false, length = 100)
    private String kind;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private Client clientId;
    
     @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER, targetEntity = Visit.class)
    private List<Visit> visit;

    public List<Visit> getVisit() {
        return visit;
    }

    public void setVisit(List<Visit> visit) {
        this.visit = visit;
    }

    public Animal() {

    }

    public Animal(String n, String i, String ad, String zc, String ph, String msc) {
//        this.firstName = i;
//        this.lastName = n;
//        this.adress = ad;
//        this.locality = msc;
//        this.zipCode = zc;
//        this.phoneNumber = ph;
    }

    @Override
    public String toString() {
//        return "Client{" + "id=" + id + "FirstName=" + firstName + " " + adress " + adress + " " + zipCode + " " + locality + " " + phoneNumber +'}';
        return "jeden";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
