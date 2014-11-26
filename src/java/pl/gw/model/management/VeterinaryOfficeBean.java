/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model.management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.gw.model.VeterinaryOffice;

/**
 *
 * @author Silwest
 */
@Stateless
public class VeterinaryOfficeBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public void save(VeterinaryOffice vetOffice) {
        em.persist(vetOffice);
    }

    public void update(VeterinaryOffice vetOffice) {
        em.merge(vetOffice);
    }

    public VeterinaryOffice find(String vetOfficeName) {
        TypedQuery<VeterinaryOffice> query = em.createNamedQuery(VeterinaryOffice.FIND_BY_NAME, VeterinaryOffice.class);
        query.setParameter("vetOfficeName", vetOfficeName);
        List<VeterinaryOffice> vetOfficeList = query.getResultList();
        if (vetOfficeList.isEmpty()) {
            return null;
        }
        return vetOfficeList.get(0);
    }

    public void remove(String vetOfficeName) {
        VeterinaryOffice vetOffice = this.find(vetOfficeName);
        if (vetOffice != null) {
            em.remove(vetOffice);
        }
    }

    public void remove(VeterinaryOffice vetOffice) {
        if (vetOffice != null && vetOffice.getName() != null && em.contains(vetOffice)) {
            em.remove(vetOffice);
        }
    }

    public List<VeterinaryOffice> findAll() {
        TypedQuery<VeterinaryOffice> query = em.createNamedQuery(VeterinaryOffice.FIND_ALL, VeterinaryOffice.class);
        return query.getResultList();
    }

    public void detach(VeterinaryOffice vetOffice) {
        em.detach(vetOffice);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
