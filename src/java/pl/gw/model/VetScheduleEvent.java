/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Silwest
 */
@Entity
public class VetScheduleEvent implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VetScheduleModelId")
    private VetScheduleModel vetScheduleModel;
    private String title;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endDate;
    private boolean allDay;
    private String styleClass;
//    private Object data;
    private boolean editable;
    private String description;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VetScheduleModel getVetScheduleModel() {
        return vetScheduleModel;
    }

    public void setVetScheduleModel(VetScheduleModel vetScheduleModel) {
        this.vetScheduleModel = vetScheduleModel;
    }
    
    @Override
    public String toString() {
        return "VetScheduleEvent{" + "id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", allDay=" + allDay + ", styleClass=" + styleClass + ", editable=" + editable + ", description=" + description + '}';
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
        final VetScheduleEvent other = (VetScheduleEvent) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        return true;
    }
    
}
