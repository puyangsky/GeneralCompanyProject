package com.company.dao.iml;

import com.company.dao.AdminDao;
import com.company.model.AdminEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by puyangsky on 2016/6/28.
 */
public class AdminDaoIml implements AdminDao {

    @Resource(name = "sessionFactory")
    private SessionFactory session;

    @Override
    public AdminEntity login(String username) {
        String hql = "from AdminEntity ad where ad.username=?";
        Query query = session.openSession().createQuery(hql);
        query.setString(0, username);
        return (AdminEntity)query.uniqueResult();
    }
}
