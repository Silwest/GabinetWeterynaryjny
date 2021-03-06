/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.utility.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Silwest
 */
@FacesValidator(value = "passwordComplexityValidator")
public class PasswordComplexityValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String componentValue = value.toString();
        pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
        matcher = pattern.matcher(componentValue);

        if (!matcher.find()) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Haslo musi zawierac minimum 8 znakow w tym 1 duza litere, 1 mala litere, 1 cyfre.", 
                    "Haslo musi zawierac minimum 8 znakow w tym 1 duza litere, 1 mala litere, 1 cyfre.");
            throw new ValidatorException(facesMessage);
        }
    }

}
