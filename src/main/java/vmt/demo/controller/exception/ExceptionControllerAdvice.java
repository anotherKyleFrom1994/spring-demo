package vmt.demo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import vmt.demo.utils.ExceptionUtil;

/**
 * 
 * This class annotated with {@code @ControllerAdvice}, which would be executed
 * either before and after the other controllers.
 * 
 * Note that the settings here will effect the whole system.
 * 
 * @author Kyle Lin
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	// /*
	// * Here's another way to handle exceptions, the Pros is the coding style and
	// the
	// * methods can be more flexible, the Cons is that it will be more difficult to
	// * hand over.
	// */
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

	/**
	 * @param Exception
	 * @return ModelAndView It will redirect you to
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("error_page");
		mv.setStatus(HttpStatus.BAD_GATEWAY);
		mv.getModel().put("message", ExceptionUtil.getStackTrace(e));
		return mv;
	}
}
