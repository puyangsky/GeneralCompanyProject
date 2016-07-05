package com.company.dao;

import com.company.model.UserEntity;

import java.util.List;

/**
 * Created by puyangsky on 2016/6/23.
 */
public interface UserDao {
    public UserEntity getUserById(int id);
    public List getAllUser();
    public List<UserEntity> getUsersById(List<Integer> ids);
    public UserEntity getUserByUsername(String username);
    public int addUser(UserEntity userEntity);
    public int delUserById(int id);
    public int updateUser(UserEntity userEntity);
}
