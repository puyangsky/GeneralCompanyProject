package com.company.service;

import com.company.dao.UserDao;
import com.company.model.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by puyangsky on 2016/6/23.
 */
@Service
public class UserService {
    @Resource(name = "userDaoIml")
    UserDao dao;

    public UserEntity getUserById(String id) {
        try {
            int uid = Integer.valueOf(id);
            return dao.getUserById(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserEntity> getAllUser() {
        return dao.getAllUser();
    }

    public void addUser(UserEntity userEntity) {
        dao.addUser(userEntity);
    }

    public boolean delUser(int id) {
        return dao.delUserById(id) > 0;
    }

    public boolean updateUser(UserEntity userEntity) {
        return dao.updateUser(userEntity) > 0;
    }
}
