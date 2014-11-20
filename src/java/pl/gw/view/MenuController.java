/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class MenuController {
    
    public MenuController(){
        
    }
    
    public void save(){
        addMessage("Succes", "Data saved");
    }
    public void update(){
        addMessage("Success", "Data updated");
    }
    public void delete(){
        addMessage("Success", "Item deleted");
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
