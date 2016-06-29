package com.company.dao.iml;

import com.company.dao.UserDao;
import com.company.model.UserEntity;
import org.hibernate.Query;
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
        String hql = "from UserEntity u where u.id=?";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setInteger(0, id);
        return (UserEntity) query.uniqueResult();
    }

    @Override
    public List getAllUser() {
        String hql = "from UserEntity";
        Query query = sessionFactory.openSession().createQuery(hql);
        return query.list();
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
    public int addUser(UserEntity userEntity) {
        try {
            sessionFactory.openSession().save(userEntity);
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public int delUserById(int id) {
        String hql = "delete UserEntity u where u.id=?";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setInteger(0, id);
        return query.executeUpdate();
    }

    @Override
    public int updateUser(UserEntity userEntity) {
        String hql = "update UserEntity u set u.username=?, u.password=?,u.hometown=?,u.gender=?," +
                "u.birthday=?,u.inarmydate=?,u.outarmydate=?,u.department=? where u.id=?";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setString(0, userEntity.getUsername());
        query.setString(1, userEntity.getPassword());
        query.setString(2, userEntity.getHometown());
        query.setString(3, userEntity.getGender());
        query.setDate(4, userEntity.getBirthday());
        query.setDate(5, userEntity.getInarmydate());
        query.setDate(6, userEntity.getOutarmydate());
        query.setString(7, userEntity.getDepartment());
        query.setInteger(8, userEntity.getId());

        return query.executeUpdate();
    }
}
