package vmt.demo.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import vmt.demo.dao.IUserDao;
import vmt.demo.model.entity.UserEntity;
import vmt.demo.model.service.AddUserInput;
import vmt.demo.model.service.AddUserOutput;

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
}
