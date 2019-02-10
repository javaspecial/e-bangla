package com.dao;

import java.util.List;

import com.model.MenuGroup;

public interface MenuGroupDAO {
	public List<MenuGroup> menuCategoryList();

	public boolean delete(MenuGroup menuGroup);

	public boolean saveOrUpdate(MenuGroup menuGroup);

	public boolean save(MenuGroup menuGroup) throws Exception;
}