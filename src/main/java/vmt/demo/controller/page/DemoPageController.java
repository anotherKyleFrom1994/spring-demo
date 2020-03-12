package vmt.demo.controller.page;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vmt.demo.model.view.UserView;

@Controller
@RequestMapping("/pageDemo")
public class DemoPageController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(@RequestBody UserView input) {
		ModelAndView mv = new ModelAndView();
		String location = null;

		if (input.getPassword() != null) {
			Map<String, Object> model = mv.getModel();
			model.put("message", "Login SUCCESS!!");
			location = "login_success";

		} else {
			Map<String, Object> model = mv.getModel();
			model.put("message", "Login Fail");
			location = "error_page";
		}

		mv.setViewName(location);
		return mv;
	}
}
