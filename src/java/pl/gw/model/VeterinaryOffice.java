/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Silwest
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "VeterinaryOffice.findAll", query = "SELECT v FROM VeterinaryOffice v ORDER BY v.id ASC"),
    @NamedQuery(name = "VeterinaryOffice.findVetOfficeByName", query = "SELECT v FROM VeterinaryOffice v WHERE v.name = :vetOfficeName"),})
public class VeterinaryOffice implements Serializable {

    public static final String FIND_ALL = "VeterinaryOffice.findAll";
    public static final String FIND_BY_NAME = "VeterinaryOffice.findVetOfficeByName";
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false, length = 64)
    private String adress;

    @Column(length = 6)
    private String zipCode;
    
    
    @OneToMany(mappedBy = "veterinaryOfficeId", fetch = FetchType.EAGER, targetEntity = User.class)
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
     @OneToMany(mappedBy = "veterinaryOffice", fetch = FetchType.EAGER, targetEntity = Visit.class)
    private List<Visit> visits;

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
    
    
    
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

    @Override
    public String toString() {
        return "VeterinaryOffice{" + "id=" + id + ", name=" + name + ", adress=" + adress + ", zipCode=" + zipCode + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VeterinaryOffice other = (VeterinaryOffice) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        return true;
    }
    
}
