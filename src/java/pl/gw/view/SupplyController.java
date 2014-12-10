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
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.SupplyBean;
import pl.gw.model.management.VeterinaryOfficeBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class SupplyController implements Serializable {

    @EJB
    private SupplyBean supplyBean;

    private Supply supply = new Supply();
    private List<Supply> supplyList;

    public SupplyController() {
    }

    @PostConstruct
    public void init() {
        supplyList = supplyBean.findAll();
    }

    public String addDrug() {
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

    public List<Supply> findAll() {
        return supplyBean.findAll();
    }

    public Supply findById(int value) {
        return supplyBean.findById(value);
    }
}
