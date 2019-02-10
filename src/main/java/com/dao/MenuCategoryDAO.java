package com.dao;

import java.util.List;

import com.model.MenuCategory;

/**
 * @author toxic-pc
 *
 */
public interface MenuCategoryDAO {
	public List<MenuCategory> getAllMenuCategories();

	public boolean delete(MenuCategory menuCategory);

	public boolean saveOrUpdate(MenuCategory menuCategory);

	public boolean save(MenuCategory menuCategory) throws Exception;
}
