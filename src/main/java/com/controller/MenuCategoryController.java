package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/saveOrUpdateCategory/", method = RequestMethod.POST)
	@ExceptionHandler({ Exception.class })
	public Response saveCategory(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("translatedName") String translatedName, @RequestParam("sortOrder") String sortOrder, @RequestParam("visible") String visible,
			@RequestParam("update") boolean update) throws Exception {
		MenuCategory category = new MenuCategory();
		try {
			if (sortOrder.equals("") || sortOrder.equals("undefined")) {
				sortOrder = String.valueOf(0);
			}
			if (!id.equals("") && !id.equals("undefined")) {
				category.setId(Integer.valueOf(id));
			}
			category.setName(name);
			category.setTranslatedName(translatedName);
			category.setSortOrder(Integer.parseInt(sortOrder));
			category.setVisible(Boolean.parseBoolean(visible));
			if (update) {
				if (menuCategoryService.update(category)) {
					return new Response("ok", "Menu category was updated successfully.");
				}
			} else if (menuCategoryService.save(category)) {
				return new Response("ok", "Menu category was created successfully.");
			}
			return new Response("err", "Unexpected error! please try again.");
		} catch (Exception e) {
			return new Response("err", "Unexpected error! please try again.");
		}
	}

	@RequestMapping(value = "/deleteCategory/", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	@ExceptionHandler({ Exception.class })
	public Response deleteCategory(@RequestBody MenuCategory selectedCategory) throws Exception {
		try {
			if (menuCategoryService.delete(selectedCategory)) {
				return new Response("ok", "Menu category was deleted successfully.");
			}
			return new Response("err", "Menu category was not deleted");
		} catch (Exception e) {
			return new Response("err", "Unexpected error! please try again.");
		}
	}
}
