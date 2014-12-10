/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Silwest
 */
@Entity
public class VetScheduleModel implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vetScheduleModel")
    private Set<VetScheduleEvent> events;
    @OneToOne
    private VeterinaryOffice vetOffice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<VetScheduleEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<VetScheduleEvent> events) {
        this.events = events;
    }

    public VeterinaryOffice getVetOffice() {
        return vetOffice;
    }

    public void setVetOffice(VeterinaryOffice vetOffice) {
        this.vetOffice = vetOffice;
    }

    @Override
    public String toString() {
        return "VetScheduleModel{" + "id=" + id + ", events=" + events + ", vetOffice=" + vetOffice + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final VetScheduleModel other = (VetScheduleModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.vetOffice, other.vetOffice)) {
            return false;
        }
        return true;
    }
    
}
