package vmt.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vmt.demo.controller.exception.ExceptionController;

@Controller
@RequestMapping("/pageDemo")
public class DemoPageController extends ExceptionController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLoginForm(@RequestParam Model model, String userName, String password) {
		String redirection = null;

		if (userName != null && password != null) {
			redirection = "login_success";
			model.addAttribute("message", "Login big SUCCESS!!!!!");
		} else {
			redirection = "";
			model.addAttribute("message", "Login Fail");
		}

		return redirection;
	}
}
