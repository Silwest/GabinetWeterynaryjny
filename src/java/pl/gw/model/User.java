/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.apache.commons.codec.digest.DigestUtils;
import pl.gw.model.usermanagement.Group;

/**
 *
 * @author Silwest
 */
@Entity
@Table(name = "USERS")
@Cacheable(false)
@NamedQueries({
    @NamedQuery(name = "User.findUserByEmail",
            query = "SELECT u from User u where u.email = :email"),
    @NamedQuery(name = "User.findUserByVerKey",
            query = "SELECT u from User u where u.verificationKey = :verificationKey")
})

public class User implements Serializable {

    public static final String FIND_BY_EMAIL = "User.findUserByEmail";
    public static final String FIND_BY_VER_KEY = "User.findUserByVerKey";

    @Id
    @Column(unique = true, nullable = false, length = 128)
    private String email;

    @Column(nullable = false, length = 128)
    private String firstName;
    @Column(nullable = false, length = 128)
    private String lastName;
    @Column(nullable = false, length = 128)
    private String password;

    @Transient
    private String passwordConfirmation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date registeredOn;

    @ElementCollection(targetClass = Group.class)
    @CollectionTable(name = "USERS_GROUPS",
            joinColumns = @JoinColumn(name = "email", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email", "groupname"})
            })

    @Enumerated(EnumType.STRING)
    @Column(name = "groupname", length = 64, nullable = false)
    private List<Group> groups;

    @Column(nullable = true, length = 128)
    private String verificationKey;

    @Column(nullable = true, length = 64)
    private String theme = "bootstrap";

    @Column()
    private boolean activated = false;

    public User() {
    }

    @PrePersist
    public void init() {
        if (this.getPassword() == null || this.getPasswordConfirmation().length() == 0
                || !this.getPasswordConfirmation().equals(this.getPassword())) {
            FacesMessage facesMesage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hasla sie nie zgadzaja.", "Hasla sie nie zgadzaja.");
            throw new ValidatorException(facesMesage);
        }
        String decryptedPassword = DigestUtils.sha512Hex(this.getPassword());
        String key = DigestUtils.sha256Hex(this.getEmail() + "." + this.getPassword());

        this.setVerificationKey(key);
        this.setPassword(decryptedPassword);
        this.setPasswordConfirmation(decryptedPassword);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getVerificationKey() {
        return verificationKey;
    }

    public void setVerificationKey(String verficationKey) {
        this.verificationKey = verficationKey;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "User [email" + this.email + ", firstName" + this.firstName
                + ", lastName" + this.lastName + ", password=" + this.password
                + ", registeredOn=" + this.registeredOn + ", groups"
                + this.groups + "]";
    }
}
