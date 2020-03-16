package vmt.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vmt.demo.conf.aop.Loggable;
import vmt.demo.model.service.AddUserInput;
import vmt.demo.model.service.AddUserOutput;
import vmt.demo.model.service.UpdateUserInput;
import vmt.demo.model.service.UpdateUserOutput;
import vmt.demo.model.view.ResultView;
import vmt.demo.model.view.UserView;
import vmt.demo.service.rest.IUserService;

/**
 * This controller is a controller that implements RESTful APIs.
 * <p>
 * The combination usage of {@code @controller} and {@code @RepsponsBody} is as
 * same as {@code @RestController}
 * </p>
 * <p>
 * {@code @Controller} is just another kind of {@code @Component}, to categorize
 * the type of Spring component.
 * </p>
 * 
 * @author Kyle Lin
 * 
 * @see vmt.demo.controller.page.DemoPageController
 * @see org.springframework.stereotype.Component
 * @see org.springframework.stereotype.Service
 * @see org.springframework.stereotype.Repository
 * 
 */
// @Controller
// @ResponseBody
@RestController
@RequestMapping(value = "/restDemo")
public class DemoRestController {
	/**
	 * Inversion of Control, dependency is injected by Spring.
	 */
	@Autowired
	private IUserService userService;

	/**
	 * A get method handling GET request. Using request parameters in form type.
	 * 
	 * @see DemoRestController#updateUser(UserView)
	 */
	@Loggable
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ResultView addUser(@RequestParam String userName, String password) {
		ResultView result = new ResultView();

		AddUserInput input = new AddUserInput();
		input.setUserName(userName);
		input.setPassword(password);

		AddUserOutput output = userService.addUser(input);
		if (output != null) {
			result.setSuccess(output.isSuccess());
			result.setMsg(output.getMsg());

		} else {
			result.setMsg("Somthing's wrong here!");
		}

		return result;
	}

	/**
	 * A get method handling POST request. Using object mapping.
	 * 
	 * @param userInfo
	 * @see DemoRestController#addUser(String, String)
	 * 
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResultView updateUser(@RequestBody UserView userInfo) {
		ResultView result = new ResultView();

		if (userInfo != null) {
			UpdateUserInput input = new UpdateUserInput();
			input.setUserId(userInfo.getUserId());
			input.setPassword(userInfo.getPassword());
			UpdateUserOutput output = userService.updateUser(input);

			if (output.isSuccess()) {
				result.setMsg("Update userId: " + userInfo.getUserId() + "; password: " + userInfo.getPassword());

			} else {
				result.setMsg(output.getMsg());
			}
		} else {
			result.setMsg("UserId or Password must not be empty");
		}

		return result;
	}

	/*
	 * There is also a way to register URI in regex or using JSTL
	 */
	// @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
	// public void handle(@PathVariable String version, @PathVariable String ext) {
	// // ...
	// }

	/*
	 * { @code Principal } is advanced Spring security feature, it pre-validates the
	 * information when receiving a request.
	 */
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String show(Model model, Principal principal) {
	// model.addAttribute("message", "登入者姓名 " + principal.getName());
	// return "index";
	// }

}