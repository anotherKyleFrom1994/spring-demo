package vmt.demo.controller;

import java.security.Principal;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	@GetMapping("/")
	public String userForm(Locale locale, Model model) {
//		model.addAttribute("users", userService.list());
		return "home";
	}

//	@GetMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
////		model.addAttribute("message", "登入者姓名 " + principal.getName());
//		return "index";
//	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(Model model, Principal principal) {
		model.addAttribute("message", "登入者姓名 " + principal.getName());
		return "index";
	}

}