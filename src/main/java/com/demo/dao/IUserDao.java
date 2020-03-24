package com.demo.dao;

import com.demo.model.entity.UserEntity;

public interface IUserDao {
	public UserEntity addUser(String username, String password);

	public UserEntity updateUser(UserEntity user);
}
