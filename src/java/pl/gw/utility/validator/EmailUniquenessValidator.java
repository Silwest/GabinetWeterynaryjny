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
import pl.gw.model.User;
import pl.gw.model.management.UserBean;

/**
 *
 * @author Silwest
 */
@FacesValidator(value = "emailUniquenessValidator")
public class EmailUniquenessValidator implements Validator {

    @Inject
    private UserBean userBean;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = value.toString();
        User user = userBean.find(email);
        if (user != null) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Niestety podany email jest juz zajety.",
                    "Niestety podany email jest juz zajety.");
            throw new ValidatorException(facesMessage);
        }
    }

}
