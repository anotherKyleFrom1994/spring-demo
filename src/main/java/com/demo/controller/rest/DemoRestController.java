package com.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.conf.aop.Loggable;
import com.demo.model.service.AddUserInput;
import com.demo.model.service.AddUserOutput;
import com.demo.model.service.UpdateUserInput;
import com.demo.model.service.UpdateUserOutput;
import com.demo.model.view.ResultView;
import com.demo.model.view.UserView;
import com.demo.service.rest.IUserService;

/**
 * This controller is a controller that implements RESTful APIs.
 * 
 * <p>
 * The combination usage of {@code @controller} and {@code @RepsponsBody} is as
 * same as {@code @RestController}
 * </p>
 * 
 * <p>
 * {@code @Controller} is just another kind of {@code @Component}, to categorize
 * the type of Spring component.
 * </p>
 * 
 * <p>
 * The request url in GET method should be like:<br/>
 * <a href=
 * "http://localhost:8080/spring-demo/restDemo/doSomthing.do?key1=value1&key2=value2">
 * http://localhost:8080/spring-demo/restDemo/doSomthing.do?key1=value1&key2=value2
 * </a>
 * </p>
 * 
 * <p>
 * The request url in POST method should be like:<br/>
 * 
 * <a href= "http://localhost:8080/spring-demo/restDemo/doSomthing.do">
 * http://localhost:8080/spring-demo/restDemo/doSomthing.do </a><br/>
 * 
 * using the post method (e.g. web form, 3rd-party request tools)
 * </p>
 * 
 * @author Kyle Lin
 * 
 * @see com.demo.controller.page.DemoPageController
 * @see org.springframework.stereotype.Component
 * @see org.springframework.stereotype.Service
 * @see org.springframework.stereotype.Repository
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
	@RequestMapping(value = "/addUser.do", method = RequestMethod.GET)
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
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
	public ResultView updateUser(@RequestBody UserView userInfo) {
		ResultView result = new ResultView();

		if (userInfo != null) {
			UpdateUserInput input = new UpdateUserInput();
			input.setUserId(userInfo.getUserId());
			input.setUserName(userInfo.getUserName());
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
	// model.addAttribute("message", principal.getName());
	// return "index";
	// }

}