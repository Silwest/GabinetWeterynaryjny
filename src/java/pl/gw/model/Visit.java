/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.primefaces.model.ScheduleEvent;

/**
 *
 * @author Putas
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v ORDER BY v.id asc"),
    @NamedQuery(name = "Visit.findById", query = "SELECT v FROM Visit v WHERE v.id = :id")})
public class Visit implements Serializable {

    public static final String FIND_ALL = "Visit.findAll";
    public static final String FIND_BY_ID = "Visit.findById";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public VeterinaryOffice getVeterinaryOffice() {
        return veterinaryOffice;
    }

    public void setVeterinaryOffice(VeterinaryOffice veterinaryOffice) {
        this.veterinaryOffice = veterinaryOffice;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public Integer getDrugsAmount() {
        return drugsAmount;
    }

    public void setDrugsAmount(Integer drugsAmount) {
        this.drugsAmount = drugsAmount;
    }

    public String getGadgets() {
        return gadgets;
    }

    public void setGadgets(String gadgets) {
        this.gadgets = gadgets;
    }

    public Integer getGadgetsAmount() {
        return gadgetsAmount;
    }

    public void setGadgetsAmount(Integer gadgetsAmount) {
        this.gadgetsAmount = gadgetsAmount;
    }

    public String getMedicalSupply() {
        return medicalSupply;
    }

    public void setMedicalSupply(String medicalSupply) {
        this.medicalSupply = medicalSupply;
    }

    public String getMedicalSupplyAmmount() {
        return medicalSupplyAmmount;
    }

    public void setMedicalSupplyAmmount(String medicalSupplyAmmount) {
        this.medicalSupplyAmmount = medicalSupplyAmmount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal")
    private Animal animal;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinaryOffice")
    private VeterinaryOffice veterinaryOffice;

    @Column(nullable = true, length = 500)
    private String diagnosis;

    @Column(nullable = true, length = 500)
    private String drugs;

    @Column(nullable = true, length = 500)
    private Integer drugsAmount;

    @Column(nullable = true, length = 500)
    private String gadgets;

    @Column(nullable = true, length = 500)
    private Integer gadgetsAmount;
    
    @Column(nullable = true, length = 500)
    private String medicalSupply;

    @Column(nullable = true, length = 500)
    private String medicalSupplyAmmount;
    
    @Column(nullable = true, length = 500)
    private Float price;
    

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Visit other = (Visit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
