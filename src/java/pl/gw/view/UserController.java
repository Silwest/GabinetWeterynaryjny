/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gw.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import pl.gw.model.User;
import pl.gw.model.usermanagement.EmailSessionBean;
import pl.gw.model.usermanagement.Group;
import pl.gw.model.usermanagement.UserBean;
import pl.gw.utility.UserMethods;

/**
 *
 * @author Silwest
 */
@ManagedBean
@RequestScoped
public class UserController implements Serializable {

    @EJB
    private UserBean userBean;
    @Inject
    private EmailSessionBean esb;
    
    private User user = new User();

    private FacesContext facesContext = null;

    public String doCreateUser() {
        List<Group> groups = new ArrayList<>();
        // TODO: Zmienic grupe przyznawana z defaultu
        groups.add(Group.ADMINISTRATOR);

        user.setGroups(groups);
        user.setRegisteredOn(new Date());
        try {
            userBean.save(user);
            // TODO: zmiana localhosta na serwer
            esb.sendEmail(user.getEmail(), "[Gabinet Weterynaryjny]", "Kliknij w wiadomosc localhost:8080/public/accountActivation.xhtml?key=" + user.getVerificationKey());
            facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Konto zostalo stworzone.", "Konto zostalo stworzone."));
        } catch (RuntimeException exception) {
            exception.getStackTrace();
            System.out.println("Blad UserController!!! \n\n\n");
        }

        return "HOME";
    }

    public void updateTheme(String userEmail, String theme) {
        user = userBean.find(userEmail);
        user.setTheme(theme);
        userBean.update(user);
    }

    public UserController() {

    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTheme(String userEmail) {
        if (userEmail == null) {
            return "bootstrap";
        }
        user = userBean.find(userEmail);
        return user.getTheme();
    }
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        if (request.getSession(false) != null) {
            request.getSession(false).invalidate();
        }
        UserMethods.addMessage(FacesMessage.SEVERITY_INFO, "Zostales wylogowany.", "Zostales wylogowany.");
        return "HOME";
    }
}
