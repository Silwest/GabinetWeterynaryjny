/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import pl.gw.model.Supply;
import pl.gw.domain.SupplyType;
import pl.gw.model.Client;
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.ClientBean;
import pl.gw.model.management.SupplyBean;
import pl.gw.model.management.VeterinaryOfficeBean;

/**
 *
 * @author Putas
 */

@ManagedBean
public class CllientController implements Serializable {

    @Inject
    private ClientBean clientBean;

    private Client client = new Client();
    private List<Client> clientList;

    public CllientController() {
    }

    @PostConstruct
    public void init() {
        clientList = clientBean.findAll();
    }

    public void  addClient() {
        clientBean.save(client);
//        return "#";
    }

    public ClientBean getClientBean() {
        return clientBean;
    }

    public void setClientBean(ClientBean clientBean) {
        this.clientBean = clientBean;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Client> findAll() {
        return clientBean.findAll();
    }

    public Client findById(int value) {
        return clientBean.find(value);
    }
}
