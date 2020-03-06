package vmt.demo.controller.rest;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vmt.demo.model.view.Login;

@Controller
@ResponseBody
@RequestMapping("/")
public class DemoController {

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public Login addUser(@RequestParam String a) {
		System.out.println(a);
//		model.addAttribute("users", userService.list());
		return new Login();
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

}