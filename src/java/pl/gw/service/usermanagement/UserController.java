/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gw.service.usermanagement;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pl.gw.model.User;
import pl.gw.model.usermanagement.UserBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
@RequestScoped
public class UserController implements Serializable{

    @EJB
    private UserBean userBean;
    private User user = new User();

    public String doCreateUser() {
        user.setRegisteredOn(new Date());
        userBean.save(user);
        return "auth/listUsers.xhtml";
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
    
    public UserController(){
    
    }
    
}
