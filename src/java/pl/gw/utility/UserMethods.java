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

    /**
     * zwraca obecnego usera contextowego
     * @return nazwa Usera
     */
    public static String getCurrentUser() {
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }
    
    /**
     * adding new message
     * @param severity
     * @param msg
     * @param msg_pop 
     */
    public static void addMessage(FacesMessage.Severity severity ,String msg, String msg_pop){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(severity, msg, msg_pop));
    }
}
