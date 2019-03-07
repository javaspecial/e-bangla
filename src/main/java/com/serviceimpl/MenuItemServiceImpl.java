package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MenuItemDAO;
import com.model.MenuItem;
import com.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	MenuItemDAO menuItemDao;

	@Override
	public boolean save(MenuItem menuItem) throws Exception {
		return menuItemDao.save(menuItem);
	}

	@Override
	public boolean update(MenuItem menuItem) throws Exception {
		return menuItemDao.update(menuItem);
	}

	@Override
	public boolean delete(MenuItem menuItem) throws Exception {
		return menuItemDao.delete(menuItem);
	}

	@Override
	public boolean saveOrUpdate(MenuItem menuItem) throws Exception {
		return menuItemDao.saveOrUpdate(menuItem);
	}

}
