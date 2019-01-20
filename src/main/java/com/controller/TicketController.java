package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.resources.UsersCookie;
import com.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	TicketService ticketService;

	@RequestMapping(value = { "/", "ticketCreate" }, method = RequestMethod.POST)
	public ModelAndView getPage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("index");
		if (StringUtils.isEmpty(UsersCookie.getInstance().getCookie(request))) {
			return view;
		}
		return new ModelAndView("home");
	}
}
