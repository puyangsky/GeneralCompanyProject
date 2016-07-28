package com.company.dao.iml;

import com.company.dao.UserDao;
import com.company.model.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by puyangsky on 2016/6/23.
 */
public class UserDaoIml implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity getUserById(int id) {
        String hql = "from UserEntity u where u.id=:id";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        session.close();
        return userEntity;
    }

    @Override
    public List getAllUser() {
        String hql = "from UserEntity";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List<UserEntity> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<UserEntity> getUsersById(List<Integer> ids) {
        List<UserEntity> userEntityList = new ArrayList<UserEntity>();
        for (int id : ids) {
            userEntityList.add(getUserById(id));
        }
        return userEntityList;
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        String hql = "from UserEntity u where u.email=:email";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        session.close();
        return userEntity;
    }

    @Override
    public int addUser(UserEntity userEntity) {
        Session session = sessionFactory.openSession();
        session.save(userEntity);
        session.close();
        return 1;
    }

    @Override
    public int delUserById(int id) {
        String hql = "delete UserEntity u where u.id=?";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        int res = query.executeUpdate();
        session.close();
        return res;
    }

    @Override
    public int updateUser(UserEntity userEntity) {
        int res = 0;
        Session session = sessionFactory.openSession();
        String hql = "update UserEntity u set u.gender=:gender,u.birthday=:birthday,u.realname=:realname,u.avatar=:avatar,u.tel=:tel,u.idnum=:idnum,u.email=:email,u.xueli=:xueli,u.hunyin=:hunyin,u.xuexing=:xuexing,u.jiankangzheng=:jiankangzheng,u.hight=:hight,u.weight=:weight,u.wishsalary=:wishsalary,u.address=:address,u.addressnum=:addressnum,u.hujiaddress=:hujiaddress,u.hujiaddressnum=:hujiaddressnum,u.huji =:huji,u.shenfen=:shenfen,u.worktime=:worktime,u.workhours=:workhours,u.starttime=:starttime,u.distance=:distance,u.wishoffer=:wishoffer,u.vehicle=:vehicle,u.a11=:a11,u.a12=:a12,u.a13=:a13,u.a14=:a14,u.a15=:a15,u.a21=:a21,u.a22=:a22,u.a23=:a23,u.a24=:a24,u.a25=:a25,u.a31=:a31,u.a32=:a32,u.a33=:a33,u.a34=:a34,u.a35=:a35,u.z1=:z1,u.z2=:z2,u.z3=:z3,u.z4=:z4,u.z5=:z5,u.b11=:b11,u.b12=:b12,u.b13=:b13,u.b14=:b14,u.b15=:b15,u.b21=:b21,u.b22=:b22,u.b23=:b23,u.b24=:b24,u.b25=:b25,u.b31=:b31,u.b32=:b32,u.b33=:b33,u.b34=:b34,u.b35=:b35,u.b41=:b41,u.b42=:b42,u.b43=:b43,u.b44=:b44,u.b45=:b45,u.b51=:b51,u.b52=:b52,u.b53=:b53,u.b54=:b54,u.b55=:b55,u.c11=:c11,u.c12=:c12,u.c13=:c13,u.c14=:c14,u.c15=:c15,u.c16=:c16,u.c17=:c17,u.c21=:c21,u.c22=:c22,u.c23=:c23,u.c24=:c24,u.c25=:c25,u.c26=:c26,u.c27=:c27,u.c31=:c31,u.c32=:c32,u.c33=:c33,u.c34=:c34,u.c35=:c35,u.c36=:c36,u.c37=:c37,u.c41=:c41,u.c42=:c42,u.c43=:c43,u.c44=:c44,u.c45=:c45,u.c46=:c46,u.c47=:c47,u.c51=:c51,u.c52=:c52,u.c53=:c53,u.c54=:c54,u.c55=:c55,u.c56=:c56,u.c57=:c57,u.updatetime=:updatetime where u.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("gender", userEntity.getGender());
        query.setParameter("birthday", userEntity.getBirthday());
        query.setParameter("realname", userEntity.getRealname());
        query.setParameter("avatar", userEntity.getAvatar());
        query.setParameter("tel", userEntity.getTel());
        query.setParameter("idnum", userEntity.getIdnum());
        query.setParameter("email", userEntity.getEmail());
        query.setParameter("xueli", userEntity.getXueli());
        query.setParameter("hunyin", userEntity.getHunyin());
        query.setParameter("xuexing", userEntity.getXuexing());
        query.setParameter("jiankangzheng", userEntity.getJiankangzheng());
        query.setParameter("hight", userEntity.getHight());
        query.setParameter("weight", userEntity.getWeight());
        query.setParameter("wishsalary", userEntity.getWishsalary());
        query.setParameter("address", userEntity.getAddress());
        query.setParameter("addressnum", userEntity.getAddressnum());
        query.setParameter("hujiaddress", userEntity.getHujiaddress());
        query.setParameter("hujiaddressnum", userEntity.getHujiaddressnum());
        query.setParameter("huji", userEntity.getHuji());
        query.setParameter("shenfen", userEntity.getShenfen());
        query.setParameter("worktime", userEntity.getWorktime());
        query.setParameter("workhours", userEntity.getWorkhours());
        query.setParameter("starttime", userEntity.getStarttime());
        query.setParameter("distance", userEntity.getDistance());
        query.setParameter("wishoffer", userEntity.getWishoffer());
        query.setParameter("vehicle", userEntity.getVehicle());
        query.setParameter("a11", userEntity.getA11());
        query.setParameter("a12", userEntity.getA12());
        query.setParameter("a13", userEntity.getA13());
        query.setParameter("a14", userEntity.getA14());
        query.setParameter("a15", userEntity.getA15());
        query.setParameter("a21", userEntity.getA21());
        query.setParameter("a22", userEntity.getA22());
        query.setParameter("a23", userEntity.getA23());
        query.setParameter("a24", userEntity.getA24());
        query.setParameter("a25", userEntity.getA25());
        query.setParameter("a31", userEntity.getA31());
        query.setParameter("a32", userEntity.getA32());
        query.setParameter("a33", userEntity.getA33());
        query.setParameter("a34", userEntity.getA34());
        query.setParameter("a35", userEntity.getA35());
        query.setParameter("z1", userEntity.getZ1());
        query.setParameter("z2", userEntity.getZ2());
        query.setParameter("z3", userEntity.getZ3());
        query.setParameter("z4", userEntity.getZ4());
        query.setParameter("z5", userEntity.getZ5());
        query.setParameter("b11", userEntity.getB11());
        query.setParameter("b12", userEntity.getB12());
        query.setParameter("b13", userEntity.getB13());
        query.setParameter("b14", userEntity.getB14());
        query.setParameter("b15", userEntity.getB15());
        query.setParameter("b21", userEntity.getB21());
        query.setParameter("b22", userEntity.getB22());
        query.setParameter("b23", userEntity.getB23());
        query.setParameter("b24", userEntity.getB24());
        query.setParameter("b25", userEntity.getB25());
        query.setParameter("b31", userEntity.getB31());
        query.setParameter("b32", userEntity.getB32());
        query.setParameter("b33", userEntity.getB33());
        query.setParameter("b34", userEntity.getB34());
        query.setParameter("b35", userEntity.getB35());
        query.setParameter("b41", userEntity.getB41());
        query.setParameter("b42", userEntity.getB42());
        query.setParameter("b43", userEntity.getB43());
        query.setParameter("b44", userEntity.getB44());
        query.setParameter("b45", userEntity.getB45());
        query.setParameter("b51", userEntity.getB51());
        query.setParameter("b52", userEntity.getB52());
        query.setParameter("b53", userEntity.getB53());
        query.setParameter("b54", userEntity.getB54());
        query.setParameter("b55", userEntity.getB55());
        query.setParameter("c11", userEntity.getC11());
        query.setParameter("c12", userEntity.getC12());
        query.setParameter("c13", userEntity.getC13());
        query.setParameter("c14", userEntity.getC14());
        query.setParameter("c15", userEntity.getC15());
        query.setParameter("c16", userEntity.getC16());
        query.setParameter("c17", userEntity.getC17());
        query.setParameter("c21", userEntity.getC21());
        query.setParameter("c22", userEntity.getC22());
        query.setParameter("c23", userEntity.getC23());
        query.setParameter("c24", userEntity.getC24());
        query.setParameter("c25", userEntity.getC25());
        query.setParameter("c26", userEntity.getC26());
        query.setParameter("c27", userEntity.getC27());
        query.setParameter("c31", userEntity.getC31());
        query.setParameter("c32", userEntity.getC32());
        query.setParameter("c33", userEntity.getC33());
        query.setParameter("c34", userEntity.getC34());
        query.setParameter("c35", userEntity.getC35());
        query.setParameter("c36", userEntity.getC36());
        query.setParameter("c37", userEntity.getC37());
        query.setParameter("c41", userEntity.getC41());
        query.setParameter("c42", userEntity.getC42());
        query.setParameter("c43", userEntity.getC43());
        query.setParameter("c44", userEntity.getC44());
        query.setParameter("c45", userEntity.getC45());
        query.setParameter("c46", userEntity.getC46());
        query.setParameter("c47", userEntity.getC47());
        query.setParameter("c51", userEntity.getC51());
        query.setParameter("c52", userEntity.getC52());
        query.setParameter("c53", userEntity.getC53());
        query.setParameter("c54", userEntity.getC54());
        query.setParameter("c55", userEntity.getC55());
        query.setParameter("c56", userEntity.getC56());
        query.setParameter("c57", userEntity.getC57());
        query.setParameter("updatetime", userEntity.getUpdatetime());
        query.setParameter("id", userEntity.getId());
        res = query.executeUpdate();
        session.close();
        return res;
    }
}
