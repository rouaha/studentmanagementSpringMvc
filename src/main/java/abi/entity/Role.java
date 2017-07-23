package abi.entity;


import javax.persistence.*;

/**
 * Created by BS190 on 7/17/2017.
 */
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private long roleId;
    private  String role;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
