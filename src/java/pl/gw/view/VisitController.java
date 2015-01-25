/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import pl.gw.model.VetScheduleEvent;
import pl.gw.model.management.VetScheduleEventBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class VisitController {
    
    @ManagedProperty(value = "#{param.id}")
    private String visitId;
    @Inject
    private VetScheduleEventBean vetScheduleEventBean;
    
    private VetScheduleEvent event = new VetScheduleEvent();
            
    
    @PostConstruct
    public void initi(){
        event = vetScheduleEventBean.findById(Integer.parseInt(visitId));
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public VetScheduleEventBean getVetScheduleEventBean() {
        return vetScheduleEventBean;
    }

    public void setVetScheduleEventBean(VetScheduleEventBean vetScheduleEventBean) {
        this.vetScheduleEventBean = vetScheduleEventBean;
    }

    public VetScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(VetScheduleEvent event) {
        this.event = event;
    }
    
}
