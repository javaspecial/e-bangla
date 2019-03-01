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
	Response model = new Response();

	@RequestMapping(value = "/categoryList/", method = RequestMethod.GET)
	@ExceptionHandler({ Exception.class })
	public Response categoryList(@RequestParam(value = "actionCommand") String actionCommand, @RequestParam(value = "nameSearch") String name) throws Exception {
		try {
			model.updateCurrentRowIndex(actionCommand);
			List<MenuCategory> categories = menuCategoryService.getAllMenuCategories(model, name);
			return new Response("ok", categories, model);
		} catch (Exception e) {
			Response response = new Response("err");
			response.setMessage("Unexpected error! please try to reload again.");
			return response;
		}
	}

	@RequestMapping(value = "/saveCategory/", method = RequestMethod.POST)
	@ExceptionHandler({ Exception.class })
	public Response saveCategory(@RequestParam("name") String name, @RequestParam("translatedName") String translatedName, @RequestParam("sortOrder") String sortOrder, @RequestParam("visible") String visible, @RequestParam("update") boolean update)
			throws Exception {
		Response response = new Response();
		try {
			MenuCategory category = new MenuCategory();
			category.setName(name);
			category.setTranslatedName(translatedName);
			category.setSortOrder(Integer.valueOf(sortOrder));
			category.setVisible(Boolean.parseBoolean(visible));
			if (update) {
				if (menuCategoryService.update(category)) {
					return new Response("ok", "Menu category was updated successfully.");
				}
			} else if (menuCategoryService.save(category)) {
				return new Response("ok", "Menu category was created successfully.");
			}
			return new Response("err", "Menu category was not created.");
		} catch (Exception e) {
			return new Response("err", "Unexpected error! please try to add again.");
		}
	}
}
