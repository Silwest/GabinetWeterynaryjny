/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import pl.gw.model.StoreHouse;
import pl.gw.model.Supply;
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.StoreHouseBean;
import pl.gw.model.management.SupplyBean;
import pl.gw.model.management.VeterinaryOfficeBean;

/**
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

    public StoreHouseController() {
    }

    @PostConstruct
    public void init() {
        allVetOffices = vetOfficeBean.findAll();
        allSupplies = supplyBean.findAll();
        allStoreHouse = storeHouseBean.findAll();
    }

    public String addStoreHouse() {
        System.out.println("ADDSTOREHOUSE: " + storeHouse.toString());
        storeHouseBean.save(storeHouse);
        return "STORE_HOUSE";
    }

    public void check() {
        System.out.println("KRUWAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("storeHousetheme" + storeHouse.toString());
    }

    public StoreHouseBean getStoreHouseBean() {
        return storeHouseBean;
    }

    public void setStoreHouseBean(StoreHouseBean storeHouseBean) {
        this.storeHouseBean = storeHouseBean;
    }

    public StoreHouse getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    public List<Supply> getAllSupplies() {
        return allSupplies;
    }

    public void setAllSupplies(List<Supply> allSupplies) {
        this.allSupplies = allSupplies;
    }

    public VeterinaryOfficeBean getVetOfficeBean() {
        return vetOfficeBean;
    }

    public void setVetOfficeBean(VeterinaryOfficeBean vetOfficeBean) {
        this.vetOfficeBean = vetOfficeBean;
    }

    public List<VeterinaryOffice> getAllVetOffices() {
        return allVetOffices;
    }

    public void setAllVetOffices(List<VeterinaryOffice> allVetOffices) {
        this.allVetOffices = allVetOffices;
    }

    public SupplyBean getSupplyBean() {
        return supplyBean;
    }

    public void setSupplyBean(SupplyBean supplyBean) {
        this.supplyBean = supplyBean;
    }

    public List<StoreHouse> getAllStoreHouse() {
        return allStoreHouse;
    }

    public void setAllStoreHouse(List<StoreHouse> allStoreHouse) {
        this.allStoreHouse = allStoreHouse;
    }

    public List<StoreHouse> getFilteredStoreHouse() {
        return filteredStoreHouse;
    }

    public void setFilteredStoreHouse(List<StoreHouse> filteredStoreHouse) {
        this.filteredStoreHouse = filteredStoreHouse;
    }

}
