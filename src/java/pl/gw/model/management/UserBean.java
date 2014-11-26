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

/**
 *
 * @author Silwest
 */
@Stateless
public class UserBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL, User.class);
        return query.getResultList();
    }

    public void save(User user) {
        em.persist(user);
    }

    public void update(User user) {
        em.merge(user);
    }

    public void remove(String email) {
        User user = this.find(email);
        if (user != null) {
            em.remove(user);
        }
    }

    public void remove(User user) {
        if (user != null && user.getEmail() != null && em.contains(user)) {
            em.remove(user);
        }
    }

    public User find(String email) {
        return em.find(User.class, email);
    }

    public User findByVerKey(String verificationKey) {
        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_VER_KEY, User.class);
        query.setParameter("verificationKey", verificationKey);
        List<User> usersList = query.getResultList();
        if(usersList.isEmpty()){
            return null;
        }
        return usersList.get(0);
        
    }

    public void detach(User user) {
        em.detach(user);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
