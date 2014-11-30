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
import javax.persistence.OneToOne;

/**
 *
 * @author Silwest
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "StoreHouse.findAll", query = "SELECT s FROM StoreHouse s ORDER BY s.id ASC"),
    @NamedQuery(name = "StoreHouse.findByName", query = "SELECT s from StoreHouse s where s.supply.name = :supplyName"),
    @NamedQuery(name = "StoreHouse.findById", query = "SELECT s from StoreHouse s where s.id = :storeHouseId"),
    @NamedQuery(name = "StoreHouse.findByVetOfficeId", query = "SELECT s from StoreHouse s where s.vetOffice.id = :vetOfficeId"),
    @NamedQuery(name = "StoreHouse.findByVetOfficeName", query = "SELECT s from StoreHouse s where s.vetOffice.name = :vetOfficeName")
})
public class StoreHouse implements Serializable {

    public static final String FIND_ALL = "StoreHouse.findAll";
    public static final String FIND_BY_NAME = "StoreHouse.findByName";
    public static final String FIND_BY_ID = "StoreHouse.findById";
    public static final String FIND_BY_VET_OFFICE_ID = "StoreHouse.findByVetOfficeId";
    public static final String FIND_BY_VET_OFFICE_NAME = "StoreHouse.findByVetOfficeName";

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Supply supply;

    @Column(nullable = false)
    private Integer amount;

    @OneToOne
    private VeterinaryOffice vetOffice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public VeterinaryOffice getVetOffice() {
        return vetOffice;
    }

    public void setVetOffice(VeterinaryOffice vetOffice) {
        this.vetOffice = vetOffice;
    }

    @Override
    public String toString() {
        return "Id = " + this.getId()
                + ", supply = " + this.getSupply()
                + ", amount = " + this.getAmount()
                + ", vetofficce = " + this.getVetOffice();
    }

}
