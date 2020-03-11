package vmt.demo.service.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vmt.demo.dao.IUserDao;
import vmt.demo.model.entity.UserEntity;
import vmt.demo.model.service.AddUserInput;
import vmt.demo.model.service.AddUserOutput;
import vmt.demo.model.service.UpdateUserInput;
import vmt.demo.model.service.UpdateUserOutput;
import vmt.demo.service.rest.IUserService;

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
			msg = e.getMessage();
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
