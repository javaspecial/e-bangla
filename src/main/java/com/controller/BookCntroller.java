package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Book;
import com.entity.Users;
import com.service.BookService;

@Controller
public class BookCntroller {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(Book book) {
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

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Book book) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.delete(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been deleted successfully");
		}
		return map;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> save(Book book) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.save(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		}
		return map;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> update(Book book) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.update(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been updated successfully");
		}
		return map;
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveOrUpdate(Book book) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookService.saveOrUpdate(book)) {
			map.put("status", "200");
			map.put("message", "Your record have been updated successfully");
		}
		return map;
	}
}
