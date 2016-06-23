package com.company.model;

import javax.persistence.*;
import javax.xml.registry.infomodel.User;
import java.sql.Date;

/**
 * Created by Administrator on 2016/6/23.
 */
@Entity
@Table(name = "user", schema = "", catalog = "test")
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private String hometown;
    private String gender;
    private Date birthday;
    private Date inarmydate;
    private Date outarmydate;
    private String department;

    public UserEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id",unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "hometown")
    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "inarmydate")
    public Date getInarmydate() {
        return inarmydate;
    }

    public void setInarmydate(Date inarmydate) {
        this.inarmydate = inarmydate;
    }

    @Basic
    @Column(name = "outarmydate")
    public Date getOutarmydate() {
        return outarmydate;
    }

    public void setOutarmydate(Date outarmydate) {
        this.outarmydate = outarmydate;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (hometown != null ? !hometown.equals(that.hometown) : that.hometown != null) return false;
        if (inarmydate != null ? !inarmydate.equals(that.inarmydate) : that.inarmydate != null) return false;
        if (outarmydate != null ? !outarmydate.equals(that.outarmydate) : that.outarmydate != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (hometown != null ? hometown.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (inarmydate != null ? inarmydate.hashCode() : 0);
        result = 31 * result + (outarmydate != null ? outarmydate.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

}
