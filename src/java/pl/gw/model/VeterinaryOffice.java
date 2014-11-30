/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
    
}
