/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.utility.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import pl.gw.model.Supply;
import pl.gw.model.management.SupplyBean;

/**
 *
 * @author Silwest
 */
@FacesValidator(value = "supplyUniquenessValidator")
public class SupplyUniquenessValidator implements Validator {

    @Inject
    private SupplyBean suppltBean;

    /**
     * sprawdza czy nazwa zasobu jest unikalna
     * @param context
     * @param component
     * @param value nazwa zasobu
     * @throws ValidatorException 
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String supplyName = value.toString();
        Supply supply = suppltBean.find(supplyName);
        if (supply != null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Podany lek istnieje juz w bazie danych.",
                    "Podany lek istnieje juz w bazie danych.");
            throw new ValidatorException(fm);
        }

    }
}
