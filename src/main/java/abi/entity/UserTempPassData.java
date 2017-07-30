package abi.entity;

import javax.persistence.*;

/**
 * Created by BS190 on 7/26/2017.
 */
@Entity
@Table
public class UserTempPassData {
    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private String userEmail;
    private String userTempPass;
    private String userNewpass;

    public String getUserNewpass() {
        return userNewpass;
    }

    public void setUserNewpass(String userNewpass) {
        this.userNewpass = userNewpass;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTempPass() {
        return userTempPass;
    }

    public void setUserTempPass(String userTempPass) {
        this.userTempPass = userTempPass;
    }


}
