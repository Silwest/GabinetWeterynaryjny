/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import pl.gw.model.Supply;
import pl.gw.domain.SupplyType;
import pl.gw.model.management.SupplyBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class SupplyController {

    @EJB
    private SupplyBean supplyBean;
    
    private Supply supply = new Supply();
    private List<Supply> supplyList;
    
    public SupplyController() {
    }
    
    @PostConstruct
    public void init(){
        supply.setPrice(new Double(0));
        supplyList = supplyBean.findAll();
    }
    
    public String addDrug(){
        supply.setSupplyType(SupplyType.DRUG);
        supplyBean.save(supply);
        return "STORE_HOUSE_ADD_SUPPLY";
    }
    public String addGadget() {
        supply.setSupplyType(SupplyType.GADGET);
        supplyBean.save(supply);
        return "STORE_HOUSE_ADD_SUPPLY";
    }
    public String addMedicalSupply() {
        supply.setSupplyType(SupplyType.MEDICALSUPPLY);
        supplyBean.save(supply);
        return "STORE_HOUSE_ADD_SUPPLY";
    }

    public SupplyBean getSupplyBean() {
        return supplyBean;
    }

    public void setSupplyBean(SupplyBean supplyBean) {
        this.supplyBean = supplyBean;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public List<Supply> getSupplyList() {
        return supplyList;
    }

    public void setSupplyList(List<Supply> supplyList) {
        this.supplyList = supplyList;
    }
}
