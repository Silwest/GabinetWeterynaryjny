/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model.management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.gw.model.StoreHouse;

/**
 *Enterprise Java Bean dla encji StoreHouse
 * @author Silwest
 */
@Stateless
public class StoreHouseBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    /**
     * zapisz
     * @param storeHouse encja magazynowa
     */
    public void save(StoreHouse storeHouse) {
        em.persist(storeHouse);
    }

    /**
     * uaktualnij dane magazynowe
     * @param storeHouse 
     */
    public void update(StoreHouse storeHouse) {
        em.merge(storeHouse);
    }

    /**
     * znajdz po nazwie
     * @param vetOfficeName
     * @return 
     */
    public List<StoreHouse> findByVetOfficeName(String vetOfficeName) {
        TypedQuery<StoreHouse> query = em.createNamedQuery(StoreHouse.FIND_BY_VET_OFFICE_NAME, StoreHouse.class);
        query.setParameter("vetOfficeName", vetOfficeName);
        return query.getResultList();
    }

    /**
     * znajdz po Id
     * @param storeHouseId
     * @return 
     */
    public StoreHouse find(Integer storeHouseId) {
        TypedQuery<StoreHouse> query = em.createNamedQuery(StoreHouse.FIND_BY_ID, StoreHouse.class);
        query.setParameter("storeHouseId", storeHouseId);
        List<StoreHouse> storeHouseList = query.getResultList();
        if (storeHouseList.isEmpty()) {
            return null;
        }
        return storeHouseList.get(0);
    }

    /**
     * usuń encję magazynową - wyszukanie po Id
     * @param storeHouseId 
     */
    public void remove(Integer storeHouseId) {
        StoreHouse storeHouse = this.find(storeHouseId);
        if (storeHouse != null) {
            em.remove(storeHouse);
        }
    }

    /**
     * usuń encję magazynową
     * @param storeHouse 
     */
    public void remove(StoreHouse storeHouse) {
        if (storeHouse != null && storeHouse.getId() != null && em.contains(storeHouse)) {
            em.remove(storeHouse);
        }
    }

    /**
     * odłącz encję od contextu
     * @param storeHouse 
     */
    public void detach(StoreHouse storeHouse) {
        em.detach(storeHouse);
    }

    /**
     * zwróc listę wszystkich zasobów
     * @return 
     */
    public List<StoreHouse> findAll() {
        TypedQuery<StoreHouse> query = em.createNamedQuery(StoreHouse.FIND_ALL, StoreHouse.class);
        return query.getResultList();
    }

}
