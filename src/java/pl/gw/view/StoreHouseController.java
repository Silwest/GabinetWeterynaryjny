/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import pl.gw.model.StoreHouse;
import pl.gw.model.Supply;
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.StoreHouseBean;
import pl.gw.model.management.SupplyBean;
import pl.gw.model.management.VeterinaryOfficeBean;
import pl.gw.utility.UserMethods;

/**
 * Kontroler do zarządzania encjami magazynowymi
 * 
 * @author Silwest
 */
@ManagedBean
@ViewScoped
public class StoreHouseController implements Serializable {

    @Inject
    private StoreHouseBean storeHouseBean;
    @Inject
    private VeterinaryOfficeBean vetOfficeBean;
    @Inject
    private SupplyBean supplyBean;

    private StoreHouse storeHouse = new StoreHouse();
    private List<Supply> allSupplies;
    private List<StoreHouse> allStoreHouse;
    private List<VeterinaryOffice> allVetOffices;
    private List<StoreHouse> filteredStoreHouse;

    /**
     * Konstruktor
     */
    public StoreHouseController() {
    }

    /**
     * inicjalizacja
     */
    @PostConstruct
    public void init() {
        allVetOffices = vetOfficeBean.findAll();
        allSupplies = supplyBean.findAll();
        allStoreHouse = storeHouseBean.findAll();
    }

    /**
     * metoda dodaje element do magazynu
     * @return 
     */
    public String addStoreHouse() {
        storeHouseBean.save(storeHouse);
        UserMethods.addMessage(FacesMessage.SEVERITY_INFO, "Lek został dodany.", "Lek został dodany");
        return "STORE_HOUSE";
    }

    /**
     * edytuj dany wiersz
     * @param event obiekt
     */
    public void rowEdit(RowEditEvent event) {
        StoreHouse updatedStoreHouse = (StoreHouse) event.getObject();
        try {
            storeHouseBean.update(updatedStoreHouse);
            UserMethods.addMessage(FacesMessage.SEVERITY_INFO, "Lek został uaktualniony.", "Lek został uaktualniony.");
        } catch (Exception e) {
            UserMethods.addMessage(FacesMessage.SEVERITY_FATAL, "Wystąpił bląd.", "Wystąpił bląd.");
        }
    }

    /**
     * getter storeHouseBean
     * @return storeHouseBean
     */
    public StoreHouseBean getStoreHouseBean() {
        return storeHouseBean;
    }

    /**
     * setter storeHouseBean
     * @param storeHouseBean 
     */
    public void setStoreHouseBean(StoreHouseBean storeHouseBean) {
        this.storeHouseBean = storeHouseBean;
    }

     /**
     * getter storeHouseBean
     * @return storeHouseBean
     */
    public StoreHouse getStoreHouse() {
        return storeHouse;
    }

     /**
     * setter storeHouseBean
     * @param storeHouseBean 
     */
    public void setStoreHouse(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

     /**
     * getter allSupplies
     * @return allSupplies
     */
    public List<Supply> getAllSupplies() {
        return allSupplies;
    }

     /**
     * setter allSupplies
     * @param allSupplies 
     */
    public void setAllSupplies(List<Supply> allSupplies) {
        this.allSupplies = allSupplies;
    }

     /**
     * getter vetOfficeBean
     * @return vetOfficeBean
     */
    public VeterinaryOfficeBean getVetOfficeBean() {
        return vetOfficeBean;
    }

     /**
     * setter vetOfficeBean
     * @param vetOfficeBean 
     */
    public void setVetOfficeBean(VeterinaryOfficeBean vetOfficeBean) {
        this.vetOfficeBean = vetOfficeBean;
    }

     /**
     * getter allVetOffices
     * @return allVetOffices
     */
    public List<VeterinaryOffice> getAllVetOffices() {
        return allVetOffices;
    }

     /**
     * setter allVetOffices
     * @param allVetOffices 
     */
    public void setAllVetOffices(List<VeterinaryOffice> allVetOffices) {
        this.allVetOffices = allVetOffices;
    }

     /**
     * getter supplyBean
     * @return supplyBean
     */
    public SupplyBean getSupplyBean() {
        return supplyBean;
    }

     /**
     * setter supplyBean
     * @param supplyBean 
     */
    public void setSupplyBean(SupplyBean supplyBean) {
        this.supplyBean = supplyBean;
    }

    
     /**
     * getter allStoreHouse
     * @return allStoreHouse
     */
    public List<StoreHouse> getAllStoreHouse() {
        return allStoreHouse;
    }

     /**
     * setter allStoreHouse
     * @param allStoreHouse 
     */
    public void setAllStoreHouse(List<StoreHouse> allStoreHouse) {
        this.allStoreHouse = allStoreHouse;
    }

    
     /**
     * getter filteredStoreHouse
     * @return filteredStoreHouse
     */
    public List<StoreHouse> getFilteredStoreHouse() {
        return filteredStoreHouse;
    }

     /**
     * setter filteredStoreHouse
     * @param filteredStoreHouse 
     */
    public void setFilteredStoreHouse(List<StoreHouse> filteredStoreHouse) {
        this.filteredStoreHouse = filteredStoreHouse;
    }

}
