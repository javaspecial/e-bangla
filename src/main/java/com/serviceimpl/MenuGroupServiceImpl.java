package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MenuGroupDAO;
import com.model.MenuCategory;
import com.model.MenuGroup;
import com.resources.Response;
import com.service.MenuGroupService;

@Service
public class MenuGroupServiceImpl implements MenuGroupService {
	@Autowired
	MenuGroupDAO menuGroupDao;

	@Override
	public boolean save(MenuGroup menuGroup) throws Exception {
		return menuGroupDao.save(menuGroup);
	}

	@Override
	public boolean saveOrUpdate(MenuGroup menuGroup) throws Exception {
		return menuGroupDao.saveOrUpdate(menuGroup);
	}

	@Override
	public boolean delete(MenuGroup menuGroup) throws Exception {
		return menuGroupDao.delete(menuGroup);
	}

	@Override
	public List<MenuGroup> getAllMenuGroups(Response model, String category, String name) throws Exception {
		return menuGroupDao.getAllMenuGroups(model, category, name);
	}

}
