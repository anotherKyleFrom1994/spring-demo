package vmt.demo.dao;

import vmt.demo.model.entity.UserEntity;

public interface IUserDao {
	public UserEntity addUser(String username, String password);

	public UserEntity updateUser(UserEntity user);
}
