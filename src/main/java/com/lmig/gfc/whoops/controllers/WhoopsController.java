package com.lmig.gfc.whoops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WhoopsController {

	@GetMapping("/")
	public ModelAndView showForm() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@PostMapping("/handle-error") 
	public ModelAndView handleError(String message) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		try {
			mv.addObject("mangledMessage", message.substring(3, 17).toUpperCase());
		} catch (IndexOutOfBoundsException ioobe) {
			mv.addObject("error", ioobe);
			mv.addObject("mangledMessage", "Hey, put in at least 17 letters");
		}
		return mv;
	}

}
