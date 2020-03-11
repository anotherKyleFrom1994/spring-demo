package vmt.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vmt.demo.model.view.ResultView;

@Controller
@RequestMapping("/pageDemo")
public class DemoPageController {

	@RequestMapping(value = "/aaaa", method = RequestMethod.GET)
	public ResultView submitLoginForm(@RequestParam String userName, String userId, String password) {
		ResultView result = new ResultView();

		if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
			result.setMsg("Username or Password must not be empty");

		} else {
			result.setMsg("User " + userName + " created");
		}

		return result;
	}
}
