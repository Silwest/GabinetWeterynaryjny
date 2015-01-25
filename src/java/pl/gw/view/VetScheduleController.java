/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

/**
 *
 * @author Silwest
 */
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.apache.commons.lang3.time.DateUtils;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import pl.gw.model.VetScheduleEvent;
import pl.gw.model.VetScheduleModel;
import pl.gw.model.management.VetScheduleEventBean;
import pl.gw.model.management.VetScheduleModelBean;
import pl.gw.utility.UserMethods;

@ManagedBean
@ViewScoped
public class VetScheduleController implements Serializable {

    @Inject
    private VetScheduleModelBean vetScheduleModelBean;

    @Inject
    private VetScheduleEventBean vetScheduleEventBean;

    private VetScheduleModel eventModel;
    private VetScheduleEvent event = new VetScheduleEvent();

    @PostConstruct
    public void init() {
        eventModel = vetScheduleModelBean.find(1);
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            event.setId(UUID.randomUUID().toString());
            event.setVetScheduleModel(eventModel);
            event.setEditable(true);
            vetScheduleEventBean.save(event);
            eventModel.addEvent(event);
            UserMethods.addMessage(FacesMessage.SEVERITY_INFO, "Wizyta została dodana!", "Nazwa" + event.getTitle());
        } else {
            vetScheduleEventBean.update(event);
            eventModel.updateEvent(event);
        }
        event = new VetScheduleEvent();
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (VetScheduleEvent) selectEvent.getObject();
    }
    
    public void removeEvent(ActionEvent actionEvent) {
        System.out.println(event.getDbId());
        vetScheduleEventBean.remove(event);
        eventModel.deleteEvent(event);
        UserMethods.addMessage(FacesMessage.SEVERITY_INFO, "Event wyrzucony", "Day delta:" + event.getTitle() + ", Minute delta:" + event.getTitle());
    }
    
    public void onDateSelect(SelectEvent selectEvent) {
        // @TODO: Start and End date change
//        Date startDate = (Date) selectEvent.getObject();
        Date endDate = (Date) selectEvent.getObject();
//        event = new VetScheduleEvent("", DateUtils.addHours(startDate, 7), DateUtils.addHours(endDate, 8));
        event = new VetScheduleEvent("", (Date) selectEvent.getObject(), DateUtils.addHours(endDate, 1));
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        VetScheduleEvent dbEvent = vetScheduleEventBean.findById(event.getScheduleEvent().getId());
        dbEvent.setStartDate(event.getScheduleEvent().getStartDate());
        dbEvent.setEndDate(event.getScheduleEvent().getEndDate());
        vetScheduleEventBean.update(dbEvent);
        UserMethods.addMessage(FacesMessage.SEVERITY_INFO, "Czas został zmieniony.", dbEvent.getTitle());
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        VetScheduleEvent dbEvent = vetScheduleEventBean.findById(event.getScheduleEvent().getId());
        dbEvent.setStartDate(event.getScheduleEvent().getStartDate());
        dbEvent.setEndDate(event.getScheduleEvent().getEndDate());
        vetScheduleEventBean.update(dbEvent);
        UserMethods.addMessage(FacesMessage.SEVERITY_INFO, "Czas został zmieniony.",dbEvent.getTitle());
    }

    public VetScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(VetScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public VetScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(VetScheduleEvent event) {
        this.event = event;
    }

    public VetScheduleModelBean getVetScheduleModelBean() {
        return vetScheduleModelBean;
    }

    public void setVetScheduleModelBean(VetScheduleModelBean vetScheduleModelBean) {
        this.vetScheduleModelBean = vetScheduleModelBean;
    }

    public VetScheduleEventBean getVetScheduleEventBean() {
        return vetScheduleEventBean;
    }

    public void setVetScheduleEventBean(VetScheduleEventBean vetScheduleEventBean) {
        this.vetScheduleEventBean = vetScheduleEventBean;
    }
}
