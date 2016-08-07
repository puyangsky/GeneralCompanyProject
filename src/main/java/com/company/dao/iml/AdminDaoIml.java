package com.company.dao.iml;

import com.company.dao.AdminDao;
import com.company.model.AdminEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by puyangsky on 2016/6/28.
 */
public class AdminDaoIml implements AdminDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public AdminEntity login(String username) {
        Session session = sessionFactory.openSession();
        String hql = "from AdminEntity ad where ad.username=:username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        AdminEntity entity = (AdminEntity)query.uniqueResult();
        session.close();
        return entity;
    }

    @Override
    public int changePwd(AdminEntity newEntity) {
        if (newEntity == null) {
            return -1;
        }
        Session session = sessionFactory.openSession();
        String hql = "update AdminEntity ad set ad.password =:password where ad.username=:username";
        Query query = session.createQuery(hql);
        query.setParameter("password", newEntity.getPassword());
        query.setParameter("username", newEntity.getUsername());
        int res = query.executeUpdate();
        session.close();
        return res;
    }
}
