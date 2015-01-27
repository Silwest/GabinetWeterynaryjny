/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import pl.gw.model.VetScheduleEvent;
import pl.gw.model.management.VetScheduleEventBean;
import org.apache.commons.lang3.time.DateUtils;
import pl.gw.model.Client;
import pl.gw.model.Visit;
import pl.gw.model.management.VisitBean;

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
    @Inject
    private VisitBean visitBean;
    private Visit visit = new Visit();
    private List<Visit> visitList;

    public VisitBean getVisitBean() {
        return visitBean;
    }

    public void setVisitBean(VisitBean visitBean) {
        this.visitBean = visitBean;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    private VetScheduleEvent event = new VetScheduleEvent(new Date(), DateUtils.addHours(new Date(), 1));

    @PostConstruct
    public void initi() {
        if (visitId != null) {
            event = vetScheduleEventBean.findById(Integer.parseInt(visitId));
        } else {

        }
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
