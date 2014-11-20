/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import pl.gw.domain.Theme;
import pl.gw.service.ThemeService;
import pl.gw.service.usermanagement.UserController;
import pl.gw.utility.UserMethods;

/**
 *
 * @author Silwest
 */
@ManagedBean
public class ThemeSwitcherBean implements Serializable {

    @ManagedProperty("#{themeService}")
    private ThemeService service;
    @ManagedProperty(value = "#{userController}")
    UserController userController;

    private String theme;
    private List<Theme> themes;
    private String currentUser;

    @PostConstruct
    public void init() {
        themes = service.getThemes();
        currentUser = UserMethods.getCurrentUser();
        theme = userController.getTheme(currentUser);
    }

    public void saveTheme() {
        userController.updateTheme(currentUser, theme);
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setService(ThemeService service) {
        this.service = service;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCurrentUser() {
        return currentUser;
    }
    
    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
