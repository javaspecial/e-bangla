package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MenuCategoryDAO;
import com.model.MenuCategory;
import com.service.MenuCategoryService;

@Service
public class MenuCategoryServiceImpl implements MenuCategoryService {
	@Autowired
	MenuCategoryDAO menuCategoryDao;

	@Override
	public boolean save(MenuCategory menuCategory) throws Exception {
		return menuCategoryDao.save(menuCategory);
	}

	@Override
	public List<MenuCategory> getAllMenuCategories() throws Exception {
		return menuCategoryDao.getAllMenuCategories();
	}

}
