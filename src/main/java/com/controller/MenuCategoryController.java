package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.MenuCategory;
import com.service.MenuCategoryService;

@Controller
@RequestMapping("menuCategory")
public class MenuCategoryController {

	@Autowired
	MenuCategoryService menuCategoryService;

	@RequestMapping(value = "/categoryList", method = RequestMethod.GET)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseEntity<List<MenuCategory>> getMenuCategories() throws Exception {
		try {
			List<MenuCategory> menuCategories = menuCategoryService.getAllMenuCategories();
			if (menuCategories != null && menuCategories.size() > 0) {
				return new ResponseEntity<List<MenuCategory>>(menuCategories, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
