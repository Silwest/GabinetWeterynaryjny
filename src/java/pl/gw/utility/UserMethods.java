/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Silwest
 */
public class UserMethods {

    public static String getCurrentUser() {
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }
    
    public static void addMessage(FacesMessage.Severity severity ,String msg, String msg_pop){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(severity, msg, msg_pop));
    }
}
