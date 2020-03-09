package vmt.demo.dao;

import vmt.demo.model.entity.UserEntity;

public interface IUserDao {
	public UserEntity findByUsername(String username, String password);
}
