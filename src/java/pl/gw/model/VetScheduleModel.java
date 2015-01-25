/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Silwest
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "VetScheduleModel.findAll", query = "SELECT v FROM VetScheduleModel v ORDER BY v.id ASC"),
    @NamedQuery(name = "VetScheduleModel.findVetScheduleModelByVetOfficeName", query = "SELECT v FROM VetScheduleModel v WHERE v.vetOffice.name = :vetOfficeName"),})
public class VetScheduleModel implements Serializable, ScheduleModel {

    public final static String FIND_ALL = "VetScheduleModel.findAll";
    public final static String FIND_BY_VET_OFFICE_NAME = "VetScheduleModel.findVetScheduleModelByVetOfficeName";

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "vetScheduleModel", fetch = FetchType.EAGER, targetEntity = VetScheduleEvent.class, cascade = CascadeType.REMOVE)
    private List<ScheduleEvent> events;
    @OneToOne
    private VeterinaryOffice vetOffice;

    public VetScheduleModel() {
        events = new ArrayList<>();
    }

    @Override
    public void addEvent(ScheduleEvent event) {
        events.add(event);
    }

    @Override
    public boolean deleteEvent(ScheduleEvent event) {
        return events.remove(event);
    }

    @Override
    public List<ScheduleEvent> getEvents() {
        return events;
    }

    @Override
    public ScheduleEvent getEvent(String id) {
        for (ScheduleEvent event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public void updateEvent(ScheduleEvent event) {
        int index = -1;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(event.getId())) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            events.set(index, event);
        }
    }

    @Override
    public int getEventCount() {
        return events.size();
    }

    @Override
    public void clear() {
        events = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VeterinaryOffice getVetOffice() {
        return vetOffice;
    }

    public void setVetOffice(VeterinaryOffice vetOffice) {
        this.vetOffice = vetOffice;
    }

    public void setEvents(List<ScheduleEvent> events) {
        this.events = events;
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
