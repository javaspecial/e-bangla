package com.dao;

import java.util.List;

import com.model.MenuCategory;
import com.resources.Response;

/**
 * @author toxic-pc
 *
 */
public interface MenuCategoryDAO {
	public List<MenuCategory> getAllMenuCategories(Response model, int pageIndex, int pageSizeSelected);

	public boolean delete(MenuCategory menuCategory);

	public boolean saveOrUpdate(MenuCategory menuCategory);

	public boolean save(MenuCategory menuCategory) throws Exception;

}
