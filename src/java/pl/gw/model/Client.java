/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.codec.digest.DigestUtils;
import pl.gw.model.usermanagement.Group;

/**
 *
 * @author Putas
 */
@Entity
@Table(name = "Client")
@NamedQueries(
        {
            @NamedQuery(name = "client.findAll",
                    query = "SELECT c FROM Client c"),
            @NamedQuery(name = "client.findById",
                    query = "SELECT c FROM Client c WHERE c.id = :id")
        }
)
public class Client implements Serializable {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private static final String FIND_ALL = "client.findAll";
    private static final String FIND_BY_ID = "client.findById";
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "firstName", length = 35)
    private String firstName;

    @Column(name = "phoneNumber", length = 9)
    private String phoneNumber;

    @Column(name = "pesel", length = 11)
    private Integer pesel;

    @Column(name = "street", length = 80)
    private String street;

    @Column(name = "zipCode")
    private Integer zipCode;

    @Column(name = "city")
    private Integer city;

    @Column(name = "email", length = 128)
    private String email;

    public Client() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
