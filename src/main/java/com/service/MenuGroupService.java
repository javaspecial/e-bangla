package com.service;

import java.util.List;

import com.model.MenuCategory;
import com.model.MenuGroup;
import com.resources.Response;

public interface MenuGroupService {
	public boolean save(MenuGroup menuGroup) throws Exception;

	public boolean saveOrUpdate(MenuGroup menuGroup) throws Exception;

	public boolean delete(MenuGroup menuGroup) throws Exception;

	public List<MenuGroup> getAllMenuGroups(Response model, MenuCategory category, String name) throws Exception;
}
