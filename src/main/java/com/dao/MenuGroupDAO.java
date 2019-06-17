package com.dao;

import java.util.List;

import com.model.MenuCategory;
import com.model.MenuGroup;
import com.resources.Response;

public interface MenuGroupDAO {
	public List<MenuGroup> menuCategoryList();

	public boolean delete(MenuGroup menuGroup);

	public boolean saveOrUpdate(MenuGroup menuGroup);

	public boolean save(MenuGroup menuGroup) throws Exception;

	public List<MenuGroup> getAllMenuGroups(Response model, String category, String name);
}