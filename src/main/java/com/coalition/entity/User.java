package com.coalition.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author:abc
 * @Description:
 * @params:$params$
 * @return: $returns$
 * @Date: $date$ $time$
 */

@Entity
@Table(name = "t_user")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//id生成策略自动增长
    //配置uuid，本来jpa是不支持uuid的，但借用hibernate的方法可以实现。
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "user_id")
    private String userId;
    @Column(name = "staff_id")
    private String staffId;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private String phone;
    private String nominator;
    private String batch;
    @Column(name = "nominator_notes")
    private String nominatorNotes;
    @Column(name = "nominee_notes")
    private String nomineeNotes;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNominator() {
        return nominator;
    }

    public void setNominator(String nominator) {
        this.nominator = nominator;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getNominatorNotes() {
        return nominatorNotes;
    }

    public void setNominatorNotes(String nominatorNotes) {
        this.nominatorNotes = nominatorNotes;
    }

    public String getNomineeNotes() {
        return nomineeNotes;
    }

    public void setNomineeNotes(String nomineeNotes) {
        this.nomineeNotes = nomineeNotes;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
