package abi.entity;


import javax.persistence.*;

/**
 * Created by BS190 on 7/5/2017.
 */
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name="serial_no")
    private int serialNo;

    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @Column(name="date_of_birth")
    private String db;
    @Column(name="s_age")
    private String age;

    @Column(name="student_id")
    private String studentId;


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
