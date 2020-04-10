package com.demo.service.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IUserDao;
import com.demo.model.entity.UserEntity;
import com.demo.model.service.AddUserInput;
import com.demo.model.service.AddUserOutput;
import com.demo.model.service.UpdateUserInput;
import com.demo.model.service.UpdateUserOutput;
import com.demo.service.rest.IUserService;
import com.demo.utils.ExceptionUtil;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Override
	public AddUserOutput addUser(AddUserInput input) {
		AddUserOutput result = new AddUserOutput();
		UserEntity user = null;

		String msg = null;
		boolean isSuccess = true;

		/*
		 * 
		 * SOME BUSINESS LOGIC...
		 * 
		 */
		try {
			user = userDao.addUser(input.getUserName(), input.getPassword());

			if (user != null) {
				msg = "UserId: " + user.getUserSeq() + ' ' + user.getUserName() + " created";
			}

		} catch (Exception e) {
			isSuccess = false;
			msg = ExceptionUtil.getStackTrace(e);
			throw new RuntimeException(e);
		}

		result.setMsg(msg);
		result.setSuccess(isSuccess);

		return result;
	}

	@Override
	public UpdateUserOutput updateUser(UpdateUserInput input) {
		UpdateUserOutput result = new UpdateUserOutput();
		UserEntity returnedUser = null;

		String msg = null;
		boolean isSuccess = true;

		/*
		 * 
		 * SOME BUSINESS LOGIC...
		 * 
		 */
		try {
			UserEntity user = new UserEntity();
			user.setUserSeq(input.getUserId());
			user.setUserName(input.getUserName());
			user.setPassword(input.getPassword());

			returnedUser = userDao.updateUser(user);

			if (user != null) {
				msg = "UserId: " + returnedUser.getUserSeq() + ' ' + returnedUser.getUserName() + " created";
			}

		} catch (Exception e) {
			isSuccess = false;
			msg = e.getMessage();
		}

		result.setMsg(msg);
		result.setSuccess(isSuccess);

		return result;
	}

}
