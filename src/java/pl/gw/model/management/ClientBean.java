/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model.management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.gw.model.Client;
import pl.gw.model.StoreHouse;


/**
 *
 * @author Putas
 */
@Stateless
public class ClientBean {

    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    public void save(Client client) {
//        TypedQuery<Client> query = em.createNamedQuery(Client.FIND_MAX_ID, Client.class);
//        System.out.println("NAPIS==== "+query.getFirstResult());
//        Integer id = query.getMaxResults();
//        System.out.println(id);
        
        em.persist(client);
    }

    public void update(Client client) {
        em.merge(client);
    }

    public List<Client> findByLastName(String lastName) {
        TypedQuery<Client> query = em.createNamedQuery(Client.FIND_BY_LAST_NAME, Client.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    public Client find(Integer clientId) {
        TypedQuery<Client> query = em.createNamedQuery(Client.FIND_BY_ID, Client.class);
        query.setParameter("id", clientId);
        List<Client> clientList = query.getResultList();
        if (clientList.isEmpty()) {
            return null;
        }
        return clientList.get(0);
    }

    public void remove(Integer clientId) {
        Client client = this.find(clientId);
        if (client != null) {
            em.remove(client);
        }
    }

    public void remove(Client client) {
        if (client != null && client.getId() != null && em.contains(client)) {
            em.remove(client);
        }
    }

    public void detach(Client client) {
        em.detach(client);
    }

    public List<Client> findAll() {
        TypedQuery<Client> query = em.createNamedQuery(Client.FIND_ALL, Client.class);
        return query.getResultList();
    }

}
