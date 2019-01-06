package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Book;
import com.entity.Users;
import com.resources.UsersCookie;
import com.service.BookService;
import com.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	UsersService userServices;
	@Autowired
	BookService bookService;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public ModelAndView getPage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("index");
		if (StringUtils.isEmpty(UsersCookie.getInstance().getCookie(request))) {
			return view;
		}
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ExceptionHandler({ Exception.class })
	public @ResponseBody Map<String, Object> saveUserRegistration(Users users) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(users.getEmail()) || StringUtils.isEmpty(users.getPassword())) {
				map.put("signUpMSG", "mandetory");
				return map;
			} else if (userServices.save(users)) {
				map.put("signUpMSG", "successfull");
				return map;
			} else {
				map.put("signUpMSG", "notCreated");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return map;
	}

	@RequestMapping(value = "/home", method = { RequestMethod.GET, RequestMethod.POST })
	@ExceptionHandler({ Exception.class })
	public ModelAndView loginProcess(@RequestParam(value = "user_name", required = false) String username,
			@RequestParam(value = "password", required = false) String password, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("home");
		try {
			if ("GET".equals(request.getMethod())) {
				if (StringUtils.isEmpty(UsersCookie.getInstance().getCookie(request))) {
					return new ModelAndView("index");
				}
				return mv;
			}
			if (userServices.validateUser(username, password)) {
				UsersCookie.getInstance().setCookie(username, response);
				mv.addObject("welcomeMSG", "Hi " + username + ", Welcome to our home page");
				return mv;
			} else {
				mv = new ModelAndView("index");
				mv.addObject("loginFailedMSG", "Email & password mismatch");
				return mv;
			}
		} catch (Exception e) {
			mv = new ModelAndView("exception");
			mv.addObject("exception", e.getMessage().toString());
			return mv;
		}
	}

	@RequestMapping(value = "/existEmail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> emailExist(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userServices.existEmail(users.getEmail())) {
			map.put("message", "exist");
			return map;
		} else {
			map.put("message", "accepted");
			return map;
		}
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userServices.saveOrUpdate(users)) {
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully.");
		}
		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> list = userServices.list();
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found.");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found!");
		}
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userServices.delete(users)) {
			map.put("status", "200");
			map.put("message", "Your record have been deleted successfully");
		}
		return map;
	}

	@RequestMapping(value = "/listOfBooks", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAllBooks(Book book) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Book> list = bookService.list();
		if (list != null) {
			map.put("status", "200");
			map.put("message", "Book found.");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Book not found!");
		}
		return map;
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteBook(Book book) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.delete(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been deleted successfully");
		}
		return map;
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveBook(Book book) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.save(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}
		return map;
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateBook(Book book) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.update(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been updated successfully");
		}
		return map;
	}

	@RequestMapping(value = "/saveOrUpdateBook", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveOrUpdateBook(Book book) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.saveOrUpdate(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been updated successfully");
		}
		return map;
	}
}
