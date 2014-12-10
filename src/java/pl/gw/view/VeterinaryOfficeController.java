/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.VeterinaryOfficeBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class VeterinaryOfficeController {

    @Inject
    private VeterinaryOfficeBean vetOfficeBean;
    private VeterinaryOffice vetOffice = new VeterinaryOffice();
    private List<VeterinaryOffice> vetOfficeList;

    @PostConstruct
    public void init() {
        vetOfficeList = vetOfficeBean.findAll();
    }
    
    public String addVetOffice(){
        vetOfficeBean.save(vetOffice);
        return "ADD_VET_OFFICE";
    }

    public VeterinaryOfficeBean getVetOfficeBean() {
        return vetOfficeBean;
    }

    public void setVetOfficeBean(VeterinaryOfficeBean vetOfficeBean) {
        this.vetOfficeBean = vetOfficeBean;
    }

    public VeterinaryOffice getVetOffice() {
        return vetOffice;
    }

    public void setVetOffice(VeterinaryOffice vetOffice) {
        this.vetOffice = vetOffice;
    }

    public List<VeterinaryOffice> getVetOfficeList() {
        return vetOfficeList;
    }

    public void setVetOfficeList(List<VeterinaryOffice> vetOfficeList) {
        this.vetOfficeList = vetOfficeList;
    }

}
