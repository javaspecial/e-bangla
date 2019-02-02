package com.serviceimpl;

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

}
