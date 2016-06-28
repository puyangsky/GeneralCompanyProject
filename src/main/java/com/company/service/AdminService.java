package com.company.service;

import com.company.dao.AdminDao;
import com.company.model.AdminEntity;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/28.
 */
public class AdminService {
    @Resource
    AdminDao dao;

    public boolean login(AdminEntity adminEntity) {
        AdminEntity entity = dao.login(adminEntity.getUsername());
        return entity.getPassword() == adminEntity.getPassword();
    }
}
