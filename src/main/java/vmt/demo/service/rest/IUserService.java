package vmt.demo.service.rest;

import vmt.demo.model.service.AddUserInput;
import vmt.demo.model.service.AddUserOutput;
import vmt.demo.model.service.UpdateUserInput;
import vmt.demo.model.service.UpdateUserOutput;

public interface IUserService {
	public AddUserOutput addUser(AddUserInput input);

	public UpdateUserOutput updateUser(UpdateUserInput input);
}
