package com.dao;

import java.util.List;

import com.model.MenuCategory;
import com.resources.Response;

/**
 * @author toxic-pc
 *
 */
public interface MenuCategoryDAO {
	public List<MenuCategory> getAllMenuCategories(Response model, String name);

	public boolean delete(MenuCategory menuCategory, Response model);

	public boolean update(MenuCategory menuCategory);

	public boolean save(MenuCategory menuCategory) throws Exception;
}
