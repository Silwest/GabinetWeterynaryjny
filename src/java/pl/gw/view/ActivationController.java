/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import pl.gw.model.User;
import pl.gw.model.management.UserBean;

/**
 *
 * 
 * @author Silwest
 */
@ManagedBean
@RequestScoped
public class ActivationController {

    @ManagedProperty(value = "#{param.key}")
    private String verKey;
    @Inject
    private UserBean userBean;
    private boolean valid;

    @PostConstruct
    public void init() {
        User user = userBean.findByVerKey(verKey);
        if (user == null) {
            valid = false;
        } else {
            System.out.println("Shehe");
            // TODO: W admin page powinni byc wszyscy uzytkownicy oczekujacy na akceptacje, To admin ustawie flage activated
            user.setActivated(true);
            user.setVerificationKey(null);
            userBean.update(user);
            valid = true;
        }
    }

    public String getVerKey() {
        return verKey;
    }

    public void setVerKey(String verKey) {
        this.verKey = verKey;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
