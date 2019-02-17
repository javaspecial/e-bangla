package com.service;

import java.util.List;

import com.model.MenuCategory;

public interface MenuCategoryService {
	public boolean save(MenuCategory menuCategory) throws Exception;

	public List<MenuCategory> getAllMenuCategories(int pageIndex, int pageSizeSelected) throws Exception;
}
