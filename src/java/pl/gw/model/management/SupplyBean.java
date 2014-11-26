/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model.management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.gw.model.Supply;

/**
 *
 * @author Silwest
 */
@Stateless
public class SupplyBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public void save(Supply supply) {
        em.persist(supply);
    }

    public void update(Supply supply) {
        em.merge(supply);
    }

    public Supply find(String supplyName) {
        TypedQuery<Supply> query = em.createNamedQuery(Supply.FIND_BY_NAME, Supply.class);
        query.setParameter("supplyName", supplyName);
        List<Supply> supplyList = query.getResultList();
        if (supplyList.isEmpty()) {
            return null;
        }
        return supplyList.get(0);
    }

    public void remove(String supplyName) {
        Supply supply = this.find(supplyName);
        if (supply != null) {
            em.remove(supply);
        }
    }

    public void remove(Supply supply) {
        if (supply != null && supply.getName() != null && em.contains(supply)) {
            em.remove(supply);
        }
    }

    public void detach(Supply supply) {
        em.detach(supply);
    }

    public List<Supply> findAll() {
        TypedQuery<Supply> query = em.createNamedQuery(Supply.FIND_ALL, Supply.class);
        return query.getResultList();
    }
}
