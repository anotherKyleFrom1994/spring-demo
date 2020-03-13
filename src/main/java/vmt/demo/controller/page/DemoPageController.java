package vmt.demo.controller.page;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pageDemo")
public class DemoPageController {

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView submitLoginForm(@RequestBody Map<String, String> input) {
		ModelAndView mv = new ModelAndView();
		String location = null;

		if (input.get("password") != null) {
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
