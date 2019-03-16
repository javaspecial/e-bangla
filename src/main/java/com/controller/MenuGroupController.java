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
import com.model.MenuGroup;
import com.resources.Response;
import com.service.MenuGroupService;

@RestController
public class MenuGroupController {

	@Autowired
	MenuGroupService menuGroupService;
	Response menuGroupModel = new Response();

	@RequestMapping(value = "/groupList/", method = RequestMethod.GET)
	@ExceptionHandler({ Exception.class })
	public Response groupList(@RequestParam(value = "actionCommand") String actionCommand,
			@RequestParam(value = "nameSearch") String name) throws Exception {
		try {
			menuGroupModel.updateCurrentRowIndex(actionCommand);
			List<MenuGroup> groups = menuGroupService.getAllMenuGroups(menuGroupModel, null, name);
			for (MenuGroup menuGroup : groups) {
				menuGroup.getSortOrder();
			}
			return new Response("ok", groups, menuGroupModel);
		} catch (Exception e) {
			return new Response("err", "Unexpected error! please try to reload again.");
		}
	}

//	@RequestMapping(value = "/saveOrUpdateGroup/", method = RequestMethod.POST)
//	@ExceptionHandler({ Exception.class })
//	public Response saveOrUpdateGroup(@RequestParam("id") String id, @RequestParam("name") String name,
//			@RequestParam("translatedName") String translatedName, @RequestParam("sortOrder") String sortOrder,
//			@RequestParam("visible") boolean visible, @RequestParam("update") boolean update) throws Exception {
//		MenuGroup category = new MenuGroup();
//		try {
//			if (!id.equals("null")) {
//				category.setGroupId(Integer.valueOf(id));
//			}
//			category.setName(name);
//			category.setTranslatedName(translatedName);
//			category.setSortOrder(Integer.parseInt(sortOrder));
//			category.setVisible(visible);
//			if (update) {
//				if (menuGroupService.saveOrUpdate(category)) {
//					return new Response("ok", "Menu category was updated successfully.");
//				}
//			} else if (menuGroupService.save(category)) {
//				return new Response("ok", "Menu category was created successfully.");
//			}
//			return new Response("err", "Unexpected error! please try again.");
//		} catch (Exception e) {
//			return new Response("err", "Unexpected error! please try again.");
//		}
//	}
//
//	@RequestMapping(value = "/deleteGroup/", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
//	@ExceptionHandler({ Exception.class })
//	public Response deleteGroup(@RequestBody MenuGroup selectedCategory) throws Exception {
//		try {
//			if (menuGroupService.delete(selectedCategory)) {
//				return new Response("ok", "Menu category was deleted successfully.");
//			}
//			return new Response("err", "Menu category was not deleted");
//		} catch (Exception e) {
//			return new Response("err", "Unexpected error! please try again.");
//		}
//	}
}
