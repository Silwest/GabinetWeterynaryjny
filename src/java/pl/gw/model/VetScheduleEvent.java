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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.primefaces.model.ScheduleEvent;

/**
 *
 * @author Silwest
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "VetScheduleEvent.findAll", query = "SELECT v FROM VetScheduleEvent v ORDER BY v.dbId asc"),
    @NamedQuery(name = "VetScheduleEvent.findByTitle", query = "SELECT v FROM VetScheduleEvent v WHERE v.title = :vetScheduleEventTitle"),
    @NamedQuery(name = "VetScheduleEvent.findById", query = "SELECT v FROM VetScheduleEvent v WHERE v.id = :vetScheduleEventId"),
    @NamedQuery(name = "VetScheduleEvent.findByVetScheduleModelId", query = "SELECT v FROM VetScheduleEvent v WHERE v.vetScheduleModel.id = :vetScheduleModelId")})
public class VetScheduleEvent implements Serializable, ScheduleEvent {

    public static final String FIND_ALL = "VetScheduleEvent.findAll";
    public static final String FIND_BY_TITLE = "VetScheduleEvent.findByTitle";
    public static final String FIND_BY_ID = "VetScheduleEvent.findById";
    public static final String FIND_BY_VET_SCHEDULE_MODEL_ID = "VetScheduleEvent.findByVetScheduleModelId";

    @Id
    @GeneratedValue
    private Integer dbId;
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VetScheduleModelId", nullable = false)
    private VetScheduleModel vetScheduleModel;
    private String title;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endDate;
    private boolean allDay;
    private String styleClass;
    @Transient
    private Object data;
    private boolean editable;
    private String description;

    public VetScheduleEvent() {
    }

    public VetScheduleEvent(String title) {
        this.title = title;
    }

    public VetScheduleEvent(String title, Date start, Date end) {
        this.title = title;
        this.startDate = start;
        this.endDate = end;
    }
        public VetScheduleEvent(Date start, Date end) {
        this.startDate = start;
        this.endDate = end;
    }

    public VetScheduleEvent(String title, Date start, Date end, VetScheduleModel model) {
        this.title = title;
        this.startDate = start;
        this.endDate = end;
        this.vetScheduleModel = model;
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public VetScheduleModel getVetScheduleModel() {
        return vetScheduleModel;
    }

    public void setVetScheduleModel(VetScheduleModel vetScheduleModel) {
        this.vetScheduleModel = vetScheduleModel;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    @Override
    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    @Override
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
//        return "VetScheduleEvent{" + "dbId=" + dbId + ", id=" + id + ", vetScheduleModel=" + vetScheduleModel + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", allDay=" + allDay + ", styleClass=" + styleClass + ", data=" + data + ", editable=" + editable + ", description=" + description + '}';
        return "VetScheduleEvent{" + "dbId=" + dbId + ", id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", allDay=" + allDay + ", styleClass=" + styleClass + ", data=" + data + ", editable=" + editable + ", description=" + description + '}';
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
        if (!Objects.equals(this.dbId, other.dbId)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.vetScheduleModel, other.vetScheduleModel)) {
            return false;
        }
        return true;
    }

}
