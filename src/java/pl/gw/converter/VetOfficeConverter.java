/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.VeterinaryOfficeBean;

/**
 *
 * @author Silwest
 */
@FacesConverter(value = "vetOfficeConverter")
public class VetOfficeConverter implements Converter{

    @Inject
    private VeterinaryOfficeBean vetOfficeBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        VeterinaryOffice vetOffice = vetOfficeBean.find(Integer.parseInt(value));
        System.out.println(vetOffice.toString());
        return vetOffice;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
            return String.valueOf(((VeterinaryOffice) object).getId());
        } else {
            return null;
        }
    }
    
}
