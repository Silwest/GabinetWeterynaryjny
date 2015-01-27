/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import pl.gw.model.Supply;
import pl.gw.model.VeterinaryOffice;
import pl.gw.model.management.SupplyBean;
import pl.gw.model.management.VeterinaryOfficeBean;

/**
 *
 * @author Putas
 */
@FacesConverter("veterinaryOfficeConverter")
public class VeterinaryOfficeConverter implements Converter {
    
    @Inject
    private VeterinaryOfficeBean veterinaryOfficeBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0) {
            
            try {
                System.out.println("SSSSSSSSSSS");
                VeterinaryOffice veterinaryOffice = veterinaryOfficeBean.findById(Integer.parseInt(value));
                return veterinaryOffice;
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion error", "Zly wybor."));
            }
        } else {
            return null;
        }
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
