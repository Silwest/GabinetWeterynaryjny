/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gw.service.usermanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pl.gw.model.User;
import pl.gw.model.usermanagement.Group;
import pl.gw.model.usermanagement.UserBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
@RequestScoped
public class UserController implements Serializable {

    @EJB
    private UserBean userBean;
    private User user = new User();
    private FacesContext facesContext = null;

    public String doCreateUser() {

        List<Group> groups = new ArrayList<Group>();

        groups.add(Group.ADMINISTRATOR);

        user.setGroups(groups);
        user.setRegisteredOn(new Date());
        try {
            userBean.save(user);
        } catch (RuntimeException exception){
            facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Problem ze stworzeniem konta" + exception.getMessage(), exception.getMessage()));
        }

        return "../base.xhtml";
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

    public UserController() {

    }

}
