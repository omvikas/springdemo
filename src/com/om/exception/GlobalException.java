package com.om.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		ModelAndView mv = new ModelAndView("exception");
		String message= e.getMessage();
		mv.addObject("exp",message);
		e.printStackTrace();
		return "exception"; 
	}
}
