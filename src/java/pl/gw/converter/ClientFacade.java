/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.converter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.gw.model.Client;

/**
 *
 * @author Putas
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {
    @PersistenceContext(unitName = "GabinetWeterynaryjnyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
}
