package com.company.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2016/7/16.
 */
@Entity
@Table(name = "user", schema = "", catalog = "test")
public class UserEntity {



    public UserEntity(Integer c57, int id, String username, String password, String hometown, String gender, Date birthday, String realname, Date outarmydate, String department, String avatar, Integer tel, String idnum, String email, String xueli, String hunyin, String xuexing, Integer jiankangzheng, Integer hight, Integer weight, Integer wishsalary, String address, Integer addressnum, String hujiaddress, Integer hujiaddressnum, String huji, String shenfen, String worktime, Integer workhours, Double starttime, Double distance, String wishoffer, String vehicle, String a11, String a12, String a13, String a14, String a15, String a21, String a22, String a23, String a24, String a25, String a31, String a32, String a33, String a34, String a35, String z1, String z2, Integer z3, Integer z4, String z5, String b11, Date b12, String b13, String b14, Integer b15, String b21, Date b22, String b23, String b24, Integer b25, String b31, Date b32, String b33, String b34, Integer b35, String b41, Date b42, String b43, String b44, Integer b45, String b51, Date b52, String b53, String b54, Integer b55, String c11, Date c12, Integer c13, String c14, String c15, String c16, Integer c17, String c21, Date c22, Integer c23, String c24, String c25, String c26, Integer c27, String c31, Date c32, Integer c33, String c34, String c35, String c36, Integer c37, String c41, Date c42, Integer c43, String c44, String c45, String c46, Integer c47, String c51, Date c52, Integer c53, String c54, String c55, String c56) {
        this.c57 = c57;
        this.id = id;
        this.username = username;
        this.password = password;
        this.hometown = hometown;
        this.gender = gender;
        this.birthday = birthday;
        this.realname = realname;
        this.outarmydate = outarmydate;
        this.department = department;
        this.avatar = avatar;
        this.tel = tel;
        this.idnum = idnum;
        this.email = email;
        this.xueli = xueli;
        this.hunyin = hunyin;
        this.xuexing = xuexing;
        this.jiankangzheng = jiankangzheng;
        this.hight = hight;
        this.weight = weight;
        this.wishsalary = wishsalary;
        this.address = address;
        this.addressnum = addressnum;
        this.hujiaddress = hujiaddress;
        this.hujiaddressnum = hujiaddressnum;
        this.huji = huji;
        this.shenfen = shenfen;
        this.worktime = worktime;
        this.workhours = workhours;
        this.starttime = starttime;
        this.distance = distance;
        this.wishoffer = wishoffer;
        this.vehicle = vehicle;
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a14 = a14;
        this.a15 = a15;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a24 = a24;
        this.a25 = a25;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
        this.a34 = a34;
        this.a35 = a35;
        this.z1 = z1;
        this.z2 = z2;
        this.z3 = z3;
        this.z4 = z4;
        this.z5 = z5;
        this.b11 = b11;
        this.b12 = b12;
        this.b13 = b13;
        this.b14 = b14;
        this.b15 = b15;
        this.b21 = b21;
        this.b22 = b22;
        this.b23 = b23;
        this.b24 = b24;
        this.b25 = b25;
        this.b31 = b31;
        this.b32 = b32;
        this.b33 = b33;
        this.b34 = b34;
        this.b35 = b35;
        this.b41 = b41;
        this.b42 = b42;
        this.b43 = b43;
        this.b44 = b44;
        this.b45 = b45;
        this.b51 = b51;
        this.b52 = b52;
        this.b53 = b53;
        this.b54 = b54;
        this.b55 = b55;
        this.c11 = c11;
        this.c12 = c12;
        this.c13 = c13;
        this.c14 = c14;
        this.c15 = c15;
        this.c16 = c16;
        this.c17 = c17;
        this.c21 = c21;
        this.c22 = c22;
        this.c23 = c23;
        this.c24 = c24;
        this.c25 = c25;
        this.c26 = c26;
        this.c27 = c27;
        this.c31 = c31;
        this.c32 = c32;
        this.c33 = c33;
        this.c34 = c34;
        this.c35 = c35;
        this.c36 = c36;
        this.c37 = c37;
        this.c41 = c41;
        this.c42 = c42;
        this.c43 = c43;
        this.c44 = c44;
        this.c45 = c45;
        this.c46 = c46;
        this.c47 = c47;
        this.c51 = c51;
        this.c52 = c52;
        this.c53 = c53;
        this.c54 = c54;
        this.c55 = c55;
        this.c56 = c56;
    }

    public UserEntity() {
    }

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    @Basic
    @Column(name = "realname")
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String hometown;

    @Basic
    @Column(name = "hometown")
    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    private String gender;

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private Date birthday;

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private Date outarmydate;

    @Basic
    @Column(name = "outarmydate")
    public Date getOutarmydate() {
        return outarmydate;
    }

    public void setOutarmydate(Date outarmydate) {
        this.outarmydate = outarmydate;
    }

    private String department;

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String avatar;

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private Integer tel;

    @Basic
    @Column(name = "tel")
    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    private String idnum;

    @Basic
    @Column(name = "idnum")
    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    private String email;

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String xueli;

    @Basic
    @Column(name = "xueli")
    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    private String hunyin;

    @Basic
    @Column(name = "hunyin")
    public String getHunyin() {
        return hunyin;
    }

    public void setHunyin(String hunyin) {
        this.hunyin = hunyin;
    }

    private String xuexing;

    @Basic
    @Column(name = "xuexing")
    public String getXuexing() {
        return xuexing;
    }

    public void setXuexing(String xuexing) {
        this.xuexing = xuexing;
    }

    private Integer jiankangzheng;

    @Basic
    @Column(name = "jiankangzheng")
    public Integer getJiankangzheng() {
        return jiankangzheng;
    }

    public void setJiankangzheng(Integer jiankangzheng) {
        this.jiankangzheng = jiankangzheng;
    }

    private Integer hight;

    @Basic
    @Column(name = "hight")
    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    private Integer weight;

    @Basic
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    private Integer wishsalary;

    @Basic
    @Column(name = "wishsalary")
    public Integer getWishsalary() {
        return wishsalary;
    }

    public void setWishsalary(Integer wishsalary) {
        this.wishsalary = wishsalary;
    }

    private String address;

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Integer addressnum;

    @Basic
    @Column(name = "addressnum")
    public Integer getAddressnum() {
        return addressnum;
    }

    public void setAddressnum(Integer addressnum) {
        this.addressnum = addressnum;
    }

    private String hujiaddress;

    @Basic
    @Column(name = "hujiaddress")
    public String getHujiaddress() {
        return hujiaddress;
    }

    public void setHujiaddress(String hujiaddress) {
        this.hujiaddress = hujiaddress;
    }

    private Integer hujiaddressnum;

    @Basic
    @Column(name = "hujiaddressnum")
    public Integer getHujiaddressnum() {
        return hujiaddressnum;
    }

    public void setHujiaddressnum(Integer hujiaddressnum) {
        this.hujiaddressnum = hujiaddressnum;
    }

    private String huji;

    @Basic
    @Column(name = "huji")
    public String getHuji() {
        return huji;
    }

    public void setHuji(String huji) {
        this.huji = huji;
    }

    private String shenfen;

    @Basic
    @Column(name = "shenfen")
    public String getShenfen() {
        return shenfen;
    }

    public void setShenfen(String shenfen) {
        this.shenfen = shenfen;
    }

    private String worktime;

    @Basic
    @Column(name = "worktime")
    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    private Integer workhours;

    @Basic
    @Column(name = "workhours")
    public Integer getWorkhours() {
        return workhours;
    }

    public void setWorkhours(Integer workhours) {
        this.workhours = workhours;
    }

    private Double starttime;

    @Basic
    @Column(name = "starttime")
    public Double getStarttime() {
        return starttime;
    }

    public void setStarttime(Double starttime) {
        this.starttime = starttime;
    }

    private Double distance;

    @Basic
    @Column(name = "distance")
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    private String wishoffer;

    @Basic
    @Column(name = "wishoffer")
    public String getWishoffer() {
        return wishoffer;
    }

    public void setWishoffer(String wishoffer) {
        this.wishoffer = wishoffer;
    }

    private String vehicle;

    @Basic
    @Column(name = "vehicle")
    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    private String a11;

    @Basic
    @Column(name = "a11")
    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }

    private String a12;

    @Basic
    @Column(name = "a12")
    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }

    private String a13;

    @Basic
    @Column(name = "a13")
    public String getA13() {
        return a13;
    }

    public void setA13(String a13) {
        this.a13 = a13;
    }

    private String a14;

    @Basic
    @Column(name = "a14")
    public String getA14() {
        return a14;
    }

    public void setA14(String a14) {
        this.a14 = a14;
    }

    private String a15;

    @Basic
    @Column(name = "a15")
    public String getA15() {
        return a15;
    }

    public void setA15(String a15) {
        this.a15 = a15;
    }

    private String a21;

    @Basic
    @Column(name = "a21")
    public String getA21() {
        return a21;
    }

    public void setA21(String a21) {
        this.a21 = a21;
    }

    private String a22;

    @Basic
    @Column(name = "a22")
    public String getA22() {
        return a22;
    }

    public void setA22(String a22) {
        this.a22 = a22;
    }

    private String a23;

    @Basic
    @Column(name = "a23")
    public String getA23() {
        return a23;
    }

    public void setA23(String a23) {
        this.a23 = a23;
    }

    private String a24;

    @Basic
    @Column(name = "a24")
    public String getA24() {
        return a24;
    }

    public void setA24(String a24) {
        this.a24 = a24;
    }

    private String a25;

    @Basic
    @Column(name = "a25")
    public String getA25() {
        return a25;
    }

    public void setA25(String a25) {
        this.a25 = a25;
    }

    private String a31;

    @Basic
    @Column(name = "a31")
    public String getA31() {
        return a31;
    }

    public void setA31(String a31) {
        this.a31 = a31;
    }

    private String a32;

    @Basic
    @Column(name = "a32")
    public String getA32() {
        return a32;
    }

    public void setA32(String a32) {
        this.a32 = a32;
    }

    private String a33;

    @Basic
    @Column(name = "a33")
    public String getA33() {
        return a33;
    }

    public void setA33(String a33) {
        this.a33 = a33;
    }

    private String a34;

    @Basic
    @Column(name = "a34")
    public String getA34() {
        return a34;
    }

    public void setA34(String a34) {
        this.a34 = a34;
    }

    private String a35;

    @Basic
    @Column(name = "a35")
    public String getA35() {
        return a35;
    }

    public void setA35(String a35) {
        this.a35 = a35;
    }

    private String z1;

    @Basic
    @Column(name = "z1")
    public String getZ1() {
        return z1;
    }

    public void setZ1(String z1) {
        this.z1 = z1;
    }

    private String z2;

    @Basic
    @Column(name = "z2")
    public String getZ2() {
        return z2;
    }

    public void setZ2(String z2) {
        this.z2 = z2;
    }

    private Integer z3;

    @Basic
    @Column(name = "z3")
    public Integer getZ3() {
        return z3;
    }

    public void setZ3(Integer z3) {
        this.z3 = z3;
    }

    private Integer z4;

    @Basic
    @Column(name = "z4")
    public Integer getZ4() {
        return z4;
    }

    public void setZ4(Integer z4) {
        this.z4 = z4;
    }

    private String z5;

    @Basic
    @Column(name = "z5")
    public String getZ5() {
        return z5;
    }

    public void setZ5(String z5) {
        this.z5 = z5;
    }

    private String b11;

    @Basic
    @Column(name = "b11")
    public String getB11() {
        return b11;
    }

    public void setB11(String b11) {
        this.b11 = b11;
    }

    private Date b12;

    @Basic
    @Column(name = "b12")
    public Date getB12() {
        return b12;
    }

    public void setB12(Date b12) {
        this.b12 = b12;
    }

    private String b13;

    @Basic
    @Column(name = "b13")
    public String getB13() {
        return b13;
    }

    public void setB13(String b13) {
        this.b13 = b13;
    }

    private String b14;

    @Basic
    @Column(name = "b14")
    public String getB14() {
        return b14;
    }

    public void setB14(String b14) {
        this.b14 = b14;
    }

    private Integer b15;

    @Basic
    @Column(name = "b15")
    public Integer getB15() {
        return b15;
    }

    public void setB15(Integer b15) {
        this.b15 = b15;
    }

    private String b21;

    @Basic
    @Column(name = "b21")
    public String getB21() {
        return b21;
    }

    public void setB21(String b21) {
        this.b21 = b21;
    }

    private Date b22;

    @Basic
    @Column(name = "b22")
    public Date getB22() {
        return b22;
    }

    public void setB22(Date b22) {
        this.b22 = b22;
    }

    private String b23;

    @Basic
    @Column(name = "b23")
    public String getB23() {
        return b23;
    }

    public void setB23(String b23) {
        this.b23 = b23;
    }

    private String b24;

    @Basic
    @Column(name = "b24")
    public String getB24() {
        return b24;
    }

    public void setB24(String b24) {
        this.b24 = b24;
    }

    private Integer b25;

    @Basic
    @Column(name = "b25")
    public Integer getB25() {
        return b25;
    }

    public void setB25(Integer b25) {
        this.b25 = b25;
    }

    private String b31;

    @Basic
    @Column(name = "b31")
    public String getB31() {
        return b31;
    }

    public void setB31(String b31) {
        this.b31 = b31;
    }

    private Date b32;

    @Basic
    @Column(name = "b32")
    public Date getB32() {
        return b32;
    }

    public void setB32(Date b32) {
        this.b32 = b32;
    }

    private String b33;

    @Basic
    @Column(name = "b33")
    public String getB33() {
        return b33;
    }

    public void setB33(String b33) {
        this.b33 = b33;
    }

    private String b34;

    @Basic
    @Column(name = "b34")
    public String getB34() {
        return b34;
    }

    public void setB34(String b34) {
        this.b34 = b34;
    }

    private Integer b35;

    @Basic
    @Column(name = "b35")
    public Integer getB35() {
        return b35;
    }

    public void setB35(Integer b35) {
        this.b35 = b35;
    }

    private String b41;

    @Basic
    @Column(name = "b41")
    public String getB41() {
        return b41;
    }

    public void setB41(String b41) {
        this.b41 = b41;
    }

    private Date b42;

    @Basic
    @Column(name = "b42")
    public Date getB42() {
        return b42;
    }

    public void setB42(Date b42) {
        this.b42 = b42;
    }

    private String b43;

    @Basic
    @Column(name = "b43")
    public String getB43() {
        return b43;
    }

    public void setB43(String b43) {
        this.b43 = b43;
    }

    private String b44;

    @Basic
    @Column(name = "b44")
    public String getB44() {
        return b44;
    }

    public void setB44(String b44) {
        this.b44 = b44;
    }

    private Integer b45;

    @Basic
    @Column(name = "b45")
    public Integer getB45() {
        return b45;
    }

    public void setB45(Integer b45) {
        this.b45 = b45;
    }

    private String b51;

    @Basic
    @Column(name = "b51")
    public String getB51() {
        return b51;
    }

    public void setB51(String b51) {
        this.b51 = b51;
    }

    private Date b52;

    @Basic
    @Column(name = "b52")
    public Date getB52() {
        return b52;
    }

    public void setB52(Date b52) {
        this.b52 = b52;
    }

    private String b53;

    @Basic
    @Column(name = "b53")
    public String getB53() {
        return b53;
    }

    public void setB53(String b53) {
        this.b53 = b53;
    }

    private String b54;

    @Basic
    @Column(name = "b54")
    public String getB54() {
        return b54;
    }

    public void setB54(String b54) {
        this.b54 = b54;
    }

    private Integer b55;

    @Basic
    @Column(name = "b55")
    public Integer getB55() {
        return b55;
    }

    public void setB55(Integer b55) {
        this.b55 = b55;
    }

    private String c11;

    @Basic
    @Column(name = "c11")
    public String getC11() {
        return c11;
    }

    public void setC11(String c11) {
        this.c11 = c11;
    }

    private Date c12;

    @Basic
    @Column(name = "c12")
    public Date getC12() {
        return c12;
    }

    public void setC12(Date c12) {
        this.c12 = c12;
    }

    private Integer c13;

    @Basic
    @Column(name = "c13")
    public Integer getC13() {
        return c13;
    }

    public void setC13(Integer c13) {
        this.c13 = c13;
    }

    private String c14;

    @Basic
    @Column(name = "c14")
    public String getC14() {
        return c14;
    }

    public void setC14(String c14) {
        this.c14 = c14;
    }

    private String c15;

    @Basic
    @Column(name = "c15")
    public String getC15() {
        return c15;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    private String c16;

    @Basic
    @Column(name = "c16")
    public String getC16() {
        return c16;
    }

    public void setC16(String c16) {
        this.c16 = c16;
    }

    private Integer c17;

    @Basic
    @Column(name = "c17")
    public Integer getC17() {
        return c17;
    }

    public void setC17(Integer c17) {
        this.c17 = c17;
    }

    private String c21;

    @Basic
    @Column(name = "c21")
    public String getC21() {
        return c21;
    }

    public void setC21(String c21) {
        this.c21 = c21;
    }

    private Date c22;

    @Basic
    @Column(name = "c22")
    public Date getC22() {
        return c22;
    }

    public void setC22(Date c22) {
        this.c22 = c22;
    }

    private Integer c23;

    @Basic
    @Column(name = "c23")
    public Integer getC23() {
        return c23;
    }

    public void setC23(Integer c23) {
        this.c23 = c23;
    }

    private String c24;

    @Basic
    @Column(name = "c24")
    public String getC24() {
        return c24;
    }

    public void setC24(String c24) {
        this.c24 = c24;
    }

    private String c25;

    @Basic
    @Column(name = "c25")
    public String getC25() {
        return c25;
    }

    public void setC25(String c25) {
        this.c25 = c25;
    }

    private String c26;

    @Basic
    @Column(name = "c26")
    public String getC26() {
        return c26;
    }

    public void setC26(String c26) {
        this.c26 = c26;
    }

    private Integer c27;

    @Basic
    @Column(name = "c27")
    public Integer getC27() {
        return c27;
    }

    public void setC27(Integer c27) {
        this.c27 = c27;
    }

    private String c31;

    @Basic
    @Column(name = "c31")
    public String getC31() {
        return c31;
    }

    public void setC31(String c31) {
        this.c31 = c31;
    }

    private Date c32;

    @Basic
    @Column(name = "c32")
    public Date getC32() {
        return c32;
    }

    public void setC32(Date c32) {
        this.c32 = c32;
    }

    private Integer c33;

    @Basic
    @Column(name = "c33")
    public Integer getC33() {
        return c33;
    }

    public void setC33(Integer c33) {
        this.c33 = c33;
    }

    private String c34;

    @Basic
    @Column(name = "c34")
    public String getC34() {
        return c34;
    }

    public void setC34(String c34) {
        this.c34 = c34;
    }

    private String c35;

    @Basic
    @Column(name = "c35")
    public String getC35() {
        return c35;
    }

    public void setC35(String c35) {
        this.c35 = c35;
    }

    private String c36;

    @Basic
    @Column(name = "c36")
    public String getC36() {
        return c36;
    }

    public void setC36(String c36) {
        this.c36 = c36;
    }

    private Integer c37;

    @Basic
    @Column(name = "c37")
    public Integer getC37() {
        return c37;
    }

    public void setC37(Integer c37) {
        this.c37 = c37;
    }

    private String c41;

    @Basic
    @Column(name = "c41")
    public String getC41() {
        return c41;
    }

    public void setC41(String c41) {
        this.c41 = c41;
    }

    private Date c42;

    @Basic
    @Column(name = "c42")
    public Date getC42() {
        return c42;
    }

    public void setC42(Date c42) {
        this.c42 = c42;
    }

    private Integer c43;

    @Basic
    @Column(name = "c43")
    public Integer getC43() {
        return c43;
    }

    public void setC43(Integer c43) {
        this.c43 = c43;
    }

    private String c44;

    @Basic
    @Column(name = "c44")
    public String getC44() {
        return c44;
    }

    public void setC44(String c44) {
        this.c44 = c44;
    }

    private String c45;

    @Basic
    @Column(name = "c45")
    public String getC45() {
        return c45;
    }

    public void setC45(String c45) {
        this.c45 = c45;
    }

    private String c46;

    @Basic
    @Column(name = "c46")
    public String getC46() {
        return c46;
    }

    public void setC46(String c46) {
        this.c46 = c46;
    }

    private Integer c47;

    @Basic
    @Column(name = "c47")
    public Integer getC47() {
        return c47;
    }

    public void setC47(Integer c47) {
        this.c47 = c47;
    }

    private String c51;

    @Basic
    @Column(name = "c51")
    public String getC51() {
        return c51;
    }

    public void setC51(String c51) {
        this.c51 = c51;
    }

    private Date c52;

    @Basic
    @Column(name = "c52")
    public Date getC52() {
        return c52;
    }

    public void setC52(Date c52) {
        this.c52 = c52;
    }

    private Integer c53;

    @Basic
    @Column(name = "c53")
    public Integer getC53() {
        return c53;
    }

    public void setC53(Integer c53) {
        this.c53 = c53;
    }

    private String c54;

    @Basic
    @Column(name = "c54")
    public String getC54() {
        return c54;
    }

    public void setC54(String c54) {
        this.c54 = c54;
    }

    private String c55;

    @Basic
    @Column(name = "c55")
    public String getC55() {
        return c55;
    }

    public void setC55(String c55) {
        this.c55 = c55;
    }

    private String c56;

    @Basic
    @Column(name = "c56")
    public String getC56() {
        return c56;
    }

    public void setC56(String c56) {
        this.c56 = c56;
    }

    private Integer c57;

    @Basic
    @Column(name = "c57")
    public Integer getC57() {
        return c57;
    }

    public void setC57(Integer c57) {
        this.c57 = c57;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (a11 != null ? !a11.equals(that.a11) : that.a11 != null) return false;
        if (a12 != null ? !a12.equals(that.a12) : that.a12 != null) return false;
        if (a13 != null ? !a13.equals(that.a13) : that.a13 != null) return false;
        if (a14 != null ? !a14.equals(that.a14) : that.a14 != null) return false;
        if (a15 != null ? !a15.equals(that.a15) : that.a15 != null) return false;
        if (a21 != null ? !a21.equals(that.a21) : that.a21 != null) return false;
        if (a22 != null ? !a22.equals(that.a22) : that.a22 != null) return false;
        if (a23 != null ? !a23.equals(that.a23) : that.a23 != null) return false;
        if (a24 != null ? !a24.equals(that.a24) : that.a24 != null) return false;
        if (a25 != null ? !a25.equals(that.a25) : that.a25 != null) return false;
        if (a31 != null ? !a31.equals(that.a31) : that.a31 != null) return false;
        if (a32 != null ? !a32.equals(that.a32) : that.a32 != null) return false;
        if (a33 != null ? !a33.equals(that.a33) : that.a33 != null) return false;
        if (a34 != null ? !a34.equals(that.a34) : that.a34 != null) return false;
        if (a35 != null ? !a35.equals(that.a35) : that.a35 != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (addressnum != null ? !addressnum.equals(that.addressnum) : that.addressnum != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
        if (b11 != null ? !b11.equals(that.b11) : that.b11 != null) return false;
        if (b12 != null ? !b12.equals(that.b12) : that.b12 != null) return false;
        if (b13 != null ? !b13.equals(that.b13) : that.b13 != null) return false;
        if (b14 != null ? !b14.equals(that.b14) : that.b14 != null) return false;
        if (b15 != null ? !b15.equals(that.b15) : that.b15 != null) return false;
        if (b21 != null ? !b21.equals(that.b21) : that.b21 != null) return false;
        if (b22 != null ? !b22.equals(that.b22) : that.b22 != null) return false;
        if (b23 != null ? !b23.equals(that.b23) : that.b23 != null) return false;
        if (b24 != null ? !b24.equals(that.b24) : that.b24 != null) return false;
        if (b25 != null ? !b25.equals(that.b25) : that.b25 != null) return false;
        if (b31 != null ? !b31.equals(that.b31) : that.b31 != null) return false;
        if (b32 != null ? !b32.equals(that.b32) : that.b32 != null) return false;
        if (b33 != null ? !b33.equals(that.b33) : that.b33 != null) return false;
        if (b34 != null ? !b34.equals(that.b34) : that.b34 != null) return false;
        if (b35 != null ? !b35.equals(that.b35) : that.b35 != null) return false;
        if (b41 != null ? !b41.equals(that.b41) : that.b41 != null) return false;
        if (b42 != null ? !b42.equals(that.b42) : that.b42 != null) return false;
        if (b43 != null ? !b43.equals(that.b43) : that.b43 != null) return false;
        if (b44 != null ? !b44.equals(that.b44) : that.b44 != null) return false;
        if (b45 != null ? !b45.equals(that.b45) : that.b45 != null) return false;
        if (b51 != null ? !b51.equals(that.b51) : that.b51 != null) return false;
        if (b52 != null ? !b52.equals(that.b52) : that.b52 != null) return false;
        if (b53 != null ? !b53.equals(that.b53) : that.b53 != null) return false;
        if (b54 != null ? !b54.equals(that.b54) : that.b54 != null) return false;
        if (b55 != null ? !b55.equals(that.b55) : that.b55 != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (c11 != null ? !c11.equals(that.c11) : that.c11 != null) return false;
        if (c12 != null ? !c12.equals(that.c12) : that.c12 != null) return false;
        if (c13 != null ? !c13.equals(that.c13) : that.c13 != null) return false;
        if (c14 != null ? !c14.equals(that.c14) : that.c14 != null) return false;
        if (c15 != null ? !c15.equals(that.c15) : that.c15 != null) return false;
        if (c16 != null ? !c16.equals(that.c16) : that.c16 != null) return false;
        if (c17 != null ? !c17.equals(that.c17) : that.c17 != null) return false;
        if (c21 != null ? !c21.equals(that.c21) : that.c21 != null) return false;
        if (c22 != null ? !c22.equals(that.c22) : that.c22 != null) return false;
        if (c23 != null ? !c23.equals(that.c23) : that.c23 != null) return false;
        if (c24 != null ? !c24.equals(that.c24) : that.c24 != null) return false;
        if (c25 != null ? !c25.equals(that.c25) : that.c25 != null) return false;
        if (c26 != null ? !c26.equals(that.c26) : that.c26 != null) return false;
        if (c27 != null ? !c27.equals(that.c27) : that.c27 != null) return false;
        if (c31 != null ? !c31.equals(that.c31) : that.c31 != null) return false;
        if (c32 != null ? !c32.equals(that.c32) : that.c32 != null) return false;
        if (c33 != null ? !c33.equals(that.c33) : that.c33 != null) return false;
        if (c34 != null ? !c34.equals(that.c34) : that.c34 != null) return false;
        if (c35 != null ? !c35.equals(that.c35) : that.c35 != null) return false;
        if (c36 != null ? !c36.equals(that.c36) : that.c36 != null) return false;
        if (c37 != null ? !c37.equals(that.c37) : that.c37 != null) return false;
        if (c41 != null ? !c41.equals(that.c41) : that.c41 != null) return false;
        if (c42 != null ? !c42.equals(that.c42) : that.c42 != null) return false;
        if (c43 != null ? !c43.equals(that.c43) : that.c43 != null) return false;
        if (c44 != null ? !c44.equals(that.c44) : that.c44 != null) return false;
        if (c45 != null ? !c45.equals(that.c45) : that.c45 != null) return false;
        if (c46 != null ? !c46.equals(that.c46) : that.c46 != null) return false;
        if (c47 != null ? !c47.equals(that.c47) : that.c47 != null) return false;
        if (c51 != null ? !c51.equals(that.c51) : that.c51 != null) return false;
        if (c52 != null ? !c52.equals(that.c52) : that.c52 != null) return false;
        if (c53 != null ? !c53.equals(that.c53) : that.c53 != null) return false;
        if (c54 != null ? !c54.equals(that.c54) : that.c54 != null) return false;
        if (c55 != null ? !c55.equals(that.c55) : that.c55 != null) return false;
        if (c56 != null ? !c56.equals(that.c56) : that.c56 != null) return false;
        if (c57 != null ? !c57.equals(that.c57) : that.c57 != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (hight != null ? !hight.equals(that.hight) : that.hight != null) return false;
        if (hometown != null ? !hometown.equals(that.hometown) : that.hometown != null) return false;
        if (huji != null ? !huji.equals(that.huji) : that.huji != null) return false;
        if (hujiaddress != null ? !hujiaddress.equals(that.hujiaddress) : that.hujiaddress != null) return false;
        if (hujiaddressnum != null ? !hujiaddressnum.equals(that.hujiaddressnum) : that.hujiaddressnum != null)
            return false;
        if (hunyin != null ? !hunyin.equals(that.hunyin) : that.hunyin != null) return false;
        if (idnum != null ? !idnum.equals(that.idnum) : that.idnum != null) return false;
        if (realname != null ? !realname.equals(that.realname) : that.realname != null) return false;
        if (jiankangzheng != null ? !jiankangzheng.equals(that.jiankangzheng) : that.jiankangzheng != null)
            return false;
        if (outarmydate != null ? !outarmydate.equals(that.outarmydate) : that.outarmydate != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (shenfen != null ? !shenfen.equals(that.shenfen) : that.shenfen != null) return false;
        if (starttime != null ? !starttime.equals(that.starttime) : that.starttime != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (wishoffer != null ? !wishoffer.equals(that.wishoffer) : that.wishoffer != null) return false;
        if (wishsalary != null ? !wishsalary.equals(that.wishsalary) : that.wishsalary != null) return false;
        if (workhours != null ? !workhours.equals(that.workhours) : that.workhours != null) return false;
        if (worktime != null ? !worktime.equals(that.worktime) : that.worktime != null) return false;
        if (xueli != null ? !xueli.equals(that.xueli) : that.xueli != null) return false;
        if (xuexing != null ? !xuexing.equals(that.xuexing) : that.xuexing != null) return false;
        if (z1 != null ? !z1.equals(that.z1) : that.z1 != null) return false;
        if (z2 != null ? !z2.equals(that.z2) : that.z2 != null) return false;
        if (z3 != null ? !z3.equals(that.z3) : that.z3 != null) return false;
        if (z4 != null ? !z4.equals(that.z4) : that.z4 != null) return false;
        if (z5 != null ? !z5.equals(that.z5) : that.z5 != null) return false;

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
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (outarmydate != null ? outarmydate.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (idnum != null ? idnum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (xueli != null ? xueli.hashCode() : 0);
        result = 31 * result + (hunyin != null ? hunyin.hashCode() : 0);
        result = 31 * result + (xuexing != null ? xuexing.hashCode() : 0);
        result = 31 * result + (jiankangzheng != null ? jiankangzheng.hashCode() : 0);
        result = 31 * result + (hight != null ? hight.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (wishsalary != null ? wishsalary.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (addressnum != null ? addressnum.hashCode() : 0);
        result = 31 * result + (hujiaddress != null ? hujiaddress.hashCode() : 0);
        result = 31 * result + (hujiaddressnum != null ? hujiaddressnum.hashCode() : 0);
        result = 31 * result + (huji != null ? huji.hashCode() : 0);
        result = 31 * result + (shenfen != null ? shenfen.hashCode() : 0);
        result = 31 * result + (worktime != null ? worktime.hashCode() : 0);
        result = 31 * result + (workhours != null ? workhours.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (wishoffer != null ? wishoffer.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (a11 != null ? a11.hashCode() : 0);
        result = 31 * result + (a12 != null ? a12.hashCode() : 0);
        result = 31 * result + (a13 != null ? a13.hashCode() : 0);
        result = 31 * result + (a14 != null ? a14.hashCode() : 0);
        result = 31 * result + (a15 != null ? a15.hashCode() : 0);
        result = 31 * result + (a21 != null ? a21.hashCode() : 0);
        result = 31 * result + (a22 != null ? a22.hashCode() : 0);
        result = 31 * result + (a23 != null ? a23.hashCode() : 0);
        result = 31 * result + (a24 != null ? a24.hashCode() : 0);
        result = 31 * result + (a25 != null ? a25.hashCode() : 0);
        result = 31 * result + (a31 != null ? a31.hashCode() : 0);
        result = 31 * result + (a32 != null ? a32.hashCode() : 0);
        result = 31 * result + (a33 != null ? a33.hashCode() : 0);
        result = 31 * result + (a34 != null ? a34.hashCode() : 0);
        result = 31 * result + (a35 != null ? a35.hashCode() : 0);
        result = 31 * result + (z1 != null ? z1.hashCode() : 0);
        result = 31 * result + (z2 != null ? z2.hashCode() : 0);
        result = 31 * result + (z3 != null ? z3.hashCode() : 0);
        result = 31 * result + (z4 != null ? z4.hashCode() : 0);
        result = 31 * result + (z5 != null ? z5.hashCode() : 0);
        result = 31 * result + (b11 != null ? b11.hashCode() : 0);
        result = 31 * result + (b12 != null ? b12.hashCode() : 0);
        result = 31 * result + (b13 != null ? b13.hashCode() : 0);
        result = 31 * result + (b14 != null ? b14.hashCode() : 0);
        result = 31 * result + (b15 != null ? b15.hashCode() : 0);
        result = 31 * result + (b21 != null ? b21.hashCode() : 0);
        result = 31 * result + (b22 != null ? b22.hashCode() : 0);
        result = 31 * result + (b23 != null ? b23.hashCode() : 0);
        result = 31 * result + (b24 != null ? b24.hashCode() : 0);
        result = 31 * result + (b25 != null ? b25.hashCode() : 0);
        result = 31 * result + (b31 != null ? b31.hashCode() : 0);
        result = 31 * result + (b32 != null ? b32.hashCode() : 0);
        result = 31 * result + (b33 != null ? b33.hashCode() : 0);
        result = 31 * result + (b34 != null ? b34.hashCode() : 0);
        result = 31 * result + (b35 != null ? b35.hashCode() : 0);
        result = 31 * result + (b41 != null ? b41.hashCode() : 0);
        result = 31 * result + (b42 != null ? b42.hashCode() : 0);
        result = 31 * result + (b43 != null ? b43.hashCode() : 0);
        result = 31 * result + (b44 != null ? b44.hashCode() : 0);
        result = 31 * result + (b45 != null ? b45.hashCode() : 0);
        result = 31 * result + (b51 != null ? b51.hashCode() : 0);
        result = 31 * result + (b52 != null ? b52.hashCode() : 0);
        result = 31 * result + (b53 != null ? b53.hashCode() : 0);
        result = 31 * result + (b54 != null ? b54.hashCode() : 0);
        result = 31 * result + (b55 != null ? b55.hashCode() : 0);
        result = 31 * result + (c11 != null ? c11.hashCode() : 0);
        result = 31 * result + (c12 != null ? c12.hashCode() : 0);
        result = 31 * result + (c13 != null ? c13.hashCode() : 0);
        result = 31 * result + (c14 != null ? c14.hashCode() : 0);
        result = 31 * result + (c15 != null ? c15.hashCode() : 0);
        result = 31 * result + (c16 != null ? c16.hashCode() : 0);
        result = 31 * result + (c17 != null ? c17.hashCode() : 0);
        result = 31 * result + (c21 != null ? c21.hashCode() : 0);
        result = 31 * result + (c22 != null ? c22.hashCode() : 0);
        result = 31 * result + (c23 != null ? c23.hashCode() : 0);
        result = 31 * result + (c24 != null ? c24.hashCode() : 0);
        result = 31 * result + (c25 != null ? c25.hashCode() : 0);
        result = 31 * result + (c26 != null ? c26.hashCode() : 0);
        result = 31 * result + (c27 != null ? c27.hashCode() : 0);
        result = 31 * result + (c31 != null ? c31.hashCode() : 0);
        result = 31 * result + (c32 != null ? c32.hashCode() : 0);
        result = 31 * result + (c33 != null ? c33.hashCode() : 0);
        result = 31 * result + (c34 != null ? c34.hashCode() : 0);
        result = 31 * result + (c35 != null ? c35.hashCode() : 0);
        result = 31 * result + (c36 != null ? c36.hashCode() : 0);
        result = 31 * result + (c37 != null ? c37.hashCode() : 0);
        result = 31 * result + (c41 != null ? c41.hashCode() : 0);
        result = 31 * result + (c42 != null ? c42.hashCode() : 0);
        result = 31 * result + (c43 != null ? c43.hashCode() : 0);
        result = 31 * result + (c44 != null ? c44.hashCode() : 0);
        result = 31 * result + (c45 != null ? c45.hashCode() : 0);
        result = 31 * result + (c46 != null ? c46.hashCode() : 0);
        result = 31 * result + (c47 != null ? c47.hashCode() : 0);
        result = 31 * result + (c51 != null ? c51.hashCode() : 0);
        result = 31 * result + (c52 != null ? c52.hashCode() : 0);
        result = 31 * result + (c53 != null ? c53.hashCode() : 0);
        result = 31 * result + (c54 != null ? c54.hashCode() : 0);
        result = 31 * result + (c55 != null ? c55.hashCode() : 0);
        result = 31 * result + (c56 != null ? c56.hashCode() : 0);
        result = 31 * result + (c57 != null ? c57.hashCode() : 0);
        return result;
    }
}
