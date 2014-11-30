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
import pl.gw.model.Supply;
import pl.gw.view.SupplyController;

/**
 *
 * @author Silwest
 */
@FacesConverter("supplyConverter")
public class SupplyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0) {
            
            try {
                SupplyController supplyController = (SupplyController) context.getExternalContext().getApplicationMap().get("supplyController");
                Supply supply = supplyController.findById(Integer.parseInt(value));
                System.out.println("CONVERTER:" + supply.toString());
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
