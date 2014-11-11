/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gw.service.usermanagement;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import pl.gw.model.User;
import pl.gw.model.usermanagement.UserBean;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class UserLogin {
    @EJB
    private UserBean userBean;
    
    public void doCreate(){
        System.out.println("I'm here");
    }
}
