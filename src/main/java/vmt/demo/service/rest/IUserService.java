package vmt.demo.service.rest;

import vmt.demo.model.service.AddUserInput;
import vmt.demo.model.service.AddUserOutput;

public interface IUserService {
	public AddUserOutput addUser(AddUserInput input);
}
