package vmt.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vmt.demo.model.view.ResultView;

@Controller
public class DemoPageController {
	
	
//	@RequestMapping(value = "/submit", method = RequestMethod.POST)
//	public String submitLoginForm(@RequestParam String userName, String userId, String password) {
//		MessageView result = new MessageView();
//
//		if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
//			result.setMsg("Username or Password must not be empty");
//
//		} else {
//			result.setMsg("User " + userName + " created");
//		}
//
//		return result;
//	}
}
