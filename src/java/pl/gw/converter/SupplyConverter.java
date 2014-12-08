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
import pl.gw.model.management.SupplyBean;

/**
 *
 * @author Silwest
 */
@FacesConverter("supplyConverter")
public class SupplyConverter implements Converter {
    
    @Inject
    private SupplyBean supplyBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0) {
            
            try {
                Supply supply = supplyBean.findById(Integer.parseInt(value));
                return supply;
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
            return String.valueOf(((Supply) object).getId());
        } else {
            return null;
        }
    }

}
