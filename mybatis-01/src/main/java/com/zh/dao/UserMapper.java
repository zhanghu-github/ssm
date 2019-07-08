package com.zh.dao;

import com.zh.model.User;

import java.util.List;

public interface UserMapper {

    User findById(int id);

    User findByName(String name);

    List<User> findAll();

    Integer insert(User user);

    Integer update(User user);

    Integer deleteById(int id);

}
