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
import pl.gw.model.VetScheduleModel;

/**
 *
 * @author Silwest
 */
@Stateless
public class VetScheduleModelBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public void save(VetScheduleModel vetScheduleModel) {
        em.persist(vetScheduleModel);
    }

    public void update(VetScheduleModel vetScheduleModel) {
        em.merge(vetScheduleModel);
    }

    public VetScheduleModel find(String vetScheduleModelVetOfficeName) {
        TypedQuery<VetScheduleModel> query = em.createNamedQuery(VetScheduleModel.FIND_BY_VET_OFFICE_NAME, VetScheduleModel.class);
        query.setParameter("vetOfficeName", vetScheduleModelVetOfficeName);
        List<VetScheduleModel> vetScheduleModelList = query.getResultList();
        if (vetScheduleModelList.isEmpty()) {
            return null;
        }
        return vetScheduleModelList.get(0);
    }

    public List<VetScheduleEvent> getEvents(VetScheduleModel model) {
        TypedQuery<VetScheduleEvent> query = em.createQuery(VetScheduleEvent.FIND_BY_VET_SCHEDULE_MODEL_ID, VetScheduleEvent.class);
        query.setParameter("vetScheduleModelId", model.getId());
        List<VetScheduleEvent> vetScheduleEventList = query.getResultList();
        return vetScheduleEventList;
    }

    public VetScheduleModel find(Integer vetScheduleModelId) {
        return em.find(VetScheduleModel.class, vetScheduleModelId);
    }

    public List<VetScheduleModel> findAll() {
        TypedQuery<VetScheduleModel> query = em.createNamedQuery(VetScheduleModel.FIND_ALL, VetScheduleModel.class);
        return query.getResultList();
    }

    public void remove(String vetScheduleModelVetOffice) {
        VetScheduleModel vetScheduleModel = this.find(vetScheduleModelVetOffice);
        if (vetScheduleModel != null) {
            em.remove(vetScheduleModel);
        }
    }

    public void remove(VetScheduleModel vetScheduleModel) {
        if (vetScheduleModel != null && vetScheduleModel.getId() != null && em.contains(vetScheduleModel)) {
            em.remove(vetScheduleModel);
        }
    }

    public void detach(VetScheduleModel vetScheduleModel) {
        em.detach(vetScheduleModel);
    }

}
