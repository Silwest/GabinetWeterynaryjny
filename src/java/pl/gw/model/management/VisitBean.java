/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gw.model.management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.gw.model.User;
import pl.gw.model.Visit;

/**
 *
 * @author Putas
 */
@Stateless
public class VisitBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public List<Visit> findAll() {
        TypedQuery<Visit> query = em.createNamedQuery(Visit.FIND_ALL, Visit.class);
        return query.getResultList();
    }

    public void save(Visit visit) {
        em.persist(visit);
    }

    public void update(Visit visit) {
        em.merge(visit);
    }


    public void detach(Visit visit) {
        em.detach(visit);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
