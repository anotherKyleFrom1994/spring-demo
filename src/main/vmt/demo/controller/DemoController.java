package vmt.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String index(Model model, Principal principal) {
		model.addAttribute("message", "登入者姓名 " + principal.getName());
		return "index";
	}
}