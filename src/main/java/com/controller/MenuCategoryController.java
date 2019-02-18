package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.MenuCategory;
import com.resources.Response;
import com.service.MenuCategoryService;

@RestController
public class MenuCategoryController {

	@Autowired
	MenuCategoryService menuCategoryService;

	@RequestMapping(value = "/categoryList/", method = RequestMethod.GET)
	@ExceptionHandler({ Exception.class })
	public Response categoryList(@RequestParam(value = "pageIndex") int pageIndex, @RequestParam(value = "pageSizeSelected") int pageSizeSelected) throws Exception {
		Response model = new Response();
		List<MenuCategory> categories = menuCategoryService.getAllMenuCategories(model, pageIndex, pageSizeSelected);
		return new Response("ok", categories, model.getTotalCount());
	}
}
