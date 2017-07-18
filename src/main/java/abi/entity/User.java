package abi.entity;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by BS190 on 7/9/2017.
 */
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private  long userId;
    private String email;
    private String name;
    private String lastName;
    private  int active;
    private  String password;
    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL,fetch =FetchType.EAGER)
   // @JoinTable(name="user_roles",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
