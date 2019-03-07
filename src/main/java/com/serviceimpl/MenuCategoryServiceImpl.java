package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MenuCategoryDAO;
import com.model.MenuCategory;
import com.resources.Response;
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
	public List<MenuCategory> getAllMenuCategories(Response model, String name) throws Exception {
		return menuCategoryDao.getAllMenuCategories(model, name);
	}

	@Override
	public boolean update(MenuCategory menuCategory) throws Exception {
		return menuCategoryDao.update(menuCategory);
	}

	@Override
	public boolean delete(MenuCategory menuCategory) throws Exception {
		return menuCategoryDao.delete(menuCategory);
	}

	@Override
	public boolean saveOrUpdate(MenuCategory menuCategory) throws Exception {
		return menuCategoryDao.saveOrUpdate(menuCategory);
	}

}
