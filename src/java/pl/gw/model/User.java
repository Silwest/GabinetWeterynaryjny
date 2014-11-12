/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gw.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import pl.gw.model.usermanagement.Group;
import pl.gw.model.usermanagement.dto.UserDTO;

/**
 *
 * @author Silwest
 */
@Entity
@Table(name = "USERS")
@Cacheable(false)
@NamedQuery(name = "User.findUserByEmail", query = "SELECT u from User u where u.email = :email")
public class User implements Serializable {

    public static final String FIND_BY_EMAIL = "User.findUserByEmail";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false, length = 128)
    private String email;

    @Column(nullable = false, length = 128)
    private String firstName;
    @Column(nullable = false, length = 128)
    private String lastName;
    @Column(nullable = false, length = 128)
    private String password;

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

    public User() {

    }

    public User(UserDTO user) {
        if (user.getPassword1() == null || user.getPassword1().length() == 0
                || !user.getPassword1().equals(user.getPassword2())) {
            throw new RuntimeException("Password 1 and Password 2 have to be equal (typo?)");
        }

        this.email = user.getEmail();
        this.firstName = user.getFName();
        this.lastName = user.getLName();
        this.password = user.getPassword1();
        this.registeredOn = new Date();
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

    @Override
    public String toString() {
        return "User [email" + this.email + ", firstName" + this.firstName
                + ", lastName" + this.lastName + ", password=" + this.password
                + ", registeredOn=" + this.registeredOn + ", groups"
                + this.groups + "]";
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User user = (User) obj;
            return user.getId() == this.getId();
        }
        return false;
    }
    
    

}