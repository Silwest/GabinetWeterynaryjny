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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Silwest
 */
@FacesValidator(value = "emailAdressValidator")
public class EmailAdressValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String componentValue = value.toString();

        try {
            InternetAddress emailAddres = new InternetAddress(componentValue);
            emailAddres.validate();
        } catch (AddressException exception) {
            FacesMessage facesMesage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Podaj poprawny email.", "Podaj poprawny email.");
            throw new ValidatorException(facesMesage);
        }
    }

}
