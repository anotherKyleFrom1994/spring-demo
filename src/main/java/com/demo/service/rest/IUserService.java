package com.demo.service.rest;

import com.demo.model.service.AddUserInput;
import com.demo.model.service.AddUserOutput;
import com.demo.model.service.UpdateUserInput;
import com.demo.model.service.UpdateUserOutput;

public interface IUserService {
	public AddUserOutput addUser(AddUserInput input);

	public UpdateUserOutput updateUser(UpdateUserInput input);
}
