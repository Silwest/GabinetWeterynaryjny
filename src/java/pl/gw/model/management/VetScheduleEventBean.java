/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model.management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.gw.model.VetScheduleEvent;

/**
 *
 * @author Silwest
 */
@Stateless
public class VetScheduleEventBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public void save(VetScheduleEvent vetScheduleEvent) {
        em.persist(vetScheduleEvent);
    }

    public void update(VetScheduleEvent vetScheduleEvent) {
        em.merge(vetScheduleEvent);
    }

    public VetScheduleEvent findById(Integer vetScheduleEventId) {
        return em.find(VetScheduleEvent.class, vetScheduleEventId);
    }

    public VetScheduleEvent findById(String vetScheduleEventId) {
        TypedQuery<VetScheduleEvent> query = em.createNamedQuery(VetScheduleEvent.FIND_BY_ID, VetScheduleEvent.class);
        query.setParameter("vetScheduleEventId", vetScheduleEventId);
        List<VetScheduleEvent> vetScheduleEventList = query.getResultList();
        if (vetScheduleEventList.isEmpty()) {
            return null;
        }
        return vetScheduleEventList.get(0);
    }

    public VetScheduleEvent find(String vetScheduleEventTitle) {
        TypedQuery<VetScheduleEvent> query = em.createNamedQuery(VetScheduleEvent.FIND_BY_TITLE, VetScheduleEvent.class);
        query.setParameter("vetScheduleEventTitle", vetScheduleEventTitle);
        List<VetScheduleEvent> vetScheduleEventList = query.getResultList();
        if (vetScheduleEventList.isEmpty()) {
            return null;
        }
        return vetScheduleEventList.get(0);
    }

    public void remove(String vetScheduleEventModel) {
        VetScheduleEvent vetScheduleEvent = this.find(vetScheduleEventModel);
        if (vetScheduleEvent != null) {
            em.remove(vetScheduleEvent);
        }
    }

    public void remove(VetScheduleEvent vetScheduleEvent) {
        if (vetScheduleEvent != null && vetScheduleEvent.getId() != null && em.contains(vetScheduleEvent)) {
            em.remove(vetScheduleEvent);
        }
    }

    public void detach(VetScheduleEvent vetScheduleEvent) {
        em.detach(vetScheduleEvent);
    }

    public List<VetScheduleEvent> findAll() {
        TypedQuery<VetScheduleEvent> query = em.createNamedQuery(VetScheduleEvent.FIND_ALL, VetScheduleEvent.class);
        return query.getResultList();
    }
}
