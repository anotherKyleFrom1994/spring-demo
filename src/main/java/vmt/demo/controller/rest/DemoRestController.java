package vmt.demo.controller.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vmt.demo.dao.IUserDao;
import vmt.demo.model.entity.UserEntity;
import vmt.demo.model.view.MessageView;
import vmt.demo.model.view.UserView;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/")
public class DemoRestController {

	@Autowired
	private IUserDao userDao;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public MessageView addUser(@RequestParam String userName, String userId, String password) {
		MessageView result = new MessageView();

		UserEntity ue = userDao.findByUsername(userName, password);

		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			result.setMsg("Username or Password must not be empty");

		} else {
			result.setMsg("User " + ue.getUserSeq() + ue.getUserName() + " created");
		}

		return result;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public MessageView updateUser(@RequestBody UserView userInfo) {
		MessageView result = new MessageView();

//		if (userInfo != null) {
//			result.setMsg("Update userId: " + userInfo.getUserId() + "; password: " + userInfo.getPassword());
//		} else {
//			result.setMsg("Username or Password must not be empty");
//		}

		return result;
	}

//	@GetMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
////		model.addAttribute("message", "登入者姓名 " + principal.getName());
//		return "index";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String show(Model model, Principal principal) {
		model.addAttribute("message", "登入者姓名 " + principal.getName());
		return "index";
	}
	
//	@GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
//	public void handle(@PathVariable String version, @PathVariable String ext) {
//	    // ...
//	}

}