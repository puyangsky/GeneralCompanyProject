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

    public UserEntity getUserByUsername (String username) {
        return dao.getUserByUsername(username);
    }


    public boolean login(UserEntity user) {
        UserEntity userEntity = dao.getUserByUsername(user.getUsername());
        if (userEntity == null) {
            return false;
        }
        return userEntity.getPassword().equals(user.getPassword());
    }

    public List<UserEntity> getAllUser() {
        return dao.getAllUser();
    }

    public int addUser(UserEntity userEntity) {
        return dao.addUser(userEntity);
    }

    public boolean delUser(int id) {
        return dao.delUserById(id) > 0;
    }

    public boolean updateUser(UserEntity userEntity) {
        return dao.updateUser(userEntity) > 0;
    }
}
