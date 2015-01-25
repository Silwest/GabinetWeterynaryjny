/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model.management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.gw.model.Animal;
import pl.gw.model.Client;
import pl.gw.model.StoreHouse;


/**
 *
 * @author Putas
 */
@Stateless
public class AnimalBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public void save(Animal animal) {
//        TypedQuery<Client> query = em.createNamedQuery(Client.FIND_MAX_ID, Client.class);
//        System.out.println("NAPIS==== "+query.getFirstResult());
//        Integer id = query.getMaxResults();
//        System.out.println(id);
        
        em.persist(animal);
    }

    public void update(Animal animal) {
        em.merge(animal);
    }

    public List<Animal> findByLastName(String lastName) {
        TypedQuery<Animal> query = em.createNamedQuery(Animal.FIND_BY_LAST_NAME, Animal.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    public Animal find(Integer animalId) {
        TypedQuery<Animal> query = em.createNamedQuery(Animal.FIND_BY_ID, Animal.class);
        query.setParameter("id", animalId);
        List<Animal> animalList = query.getResultList();
        if (animalList.isEmpty()) {
            return null;
        }
        return animalList.get(0);
    }

    public void remove(Integer animaId) {
        Animal animal = this.find(animaId);
        if (animal != null) {
            em.remove(animal);
        }
    }

    public void remove(Animal animal) {
//        if (animal != null && animal.getId() != null && em.contains(animal)) {
//            em.remove(animal);
//        }
    }

    public void detach(Animal animal) {
        em.detach(animal);
    }

    public List<Animal> findAll() {
        TypedQuery<Animal> query = em.createNamedQuery(Animal.FIND_ALL, Animal.class);
        return query.getResultList();
    }

}
