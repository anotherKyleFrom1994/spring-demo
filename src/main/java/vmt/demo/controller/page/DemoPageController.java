package vmt.demo.controller.page;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * This controller is an example of routing pages(here is JSP) by SpringMVC.
 * Registered as {@code @Controller}, that can be component-scanned by
 * SpringMVC.
 * </p>
 * <p>
 * {@code @Controller} is just another kind of {@code @Component}, to categorize
 * the type of Spring component.
 * </p>
 * 
 * @author Kyle Lin
 * @see vmt.demo.controller.rest.DemoRestController
 * @see org.springframework.stereotype.Component
 * @see org.springframework.stereotype.Service
 * @see org.springframework.stereotype.Repository
 */
@Controller
@RequestMapping("/pageDemo")
public class DemoPageController {

	/**
	 * <p>
	 * The return type of the Servlet request handling method can be
	 * {@code ModelAndView} or String. Though there's also another way to handle
	 * request or response, and each of them have their Pros and Cons,I suppose this
	 * is the simplest.
	 * </p>
	 * 
	 * <pre>
	 * Pros and Cons using {@code ModelAndView}
	 * 
	 * Pros : Easy to use, can be easy to hand on.
	 * 
	 * Cons: Cannot obtain the native Servlet instances, this might cause the
	 * difficulty to use in some circumstances.
	 * </pre>
	 */
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
