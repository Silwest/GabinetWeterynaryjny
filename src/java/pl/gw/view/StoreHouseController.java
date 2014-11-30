/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import pl.gw.model.StoreHouse;
import pl.gw.model.Supply;
import pl.gw.model.management.StoreHouseBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class StoreHouseController implements Serializable {

    @Inject
    private StoreHouseBean storeHouseBean;

    @ManagedProperty("#{supplyController}")
    private SupplyController supplyController;

    private StoreHouse storeHouse = new StoreHouse();
    private List<Supply> allSupplies;

    @PostConstruct
    public void init() {
        allSupplies = supplyController.findAll();
    }

    public void check() {
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

    public SupplyController getSupplyController() {
        return supplyController;
    }

    public void setSupplyController(SupplyController supplyController) {
        this.supplyController = supplyController;
    }
}
