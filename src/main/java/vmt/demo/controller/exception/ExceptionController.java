package vmt.demo.controller.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class ExceptionController {

	// @ExceptionHandler(Exception.class)
	// public RedirectView handle(Exception e, HttpServletRequest request,
	// HttpServletResponse response) {
	// RedirectView rw = new RedirectView("error_page");
	// rw.setStatusCode(HttpStatus.I_AM_A_TEAPOT);
	// FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
	// if (outputFlashMap != null) {
	// outputFlashMap.put("message", "testsststst");
	// }
	// return rw;
	// }

	@ExceptionHandler(Exception.class)
	public ModelAndView handle(Exception e, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		Map<String, String> attr = new HashMap<String, String>();
		attr.put("message", "testteste");

		mv.setViewName("error_page");
		mv.setStatus(HttpStatus.BAD_GATEWAY);
		mv.addObject(attr);
		// return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(attr);
		return mv;
	}
}
