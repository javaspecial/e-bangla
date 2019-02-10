package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MenuItemModifierGroupDAO;
import com.model.MenuItemModifierGroup;
import com.service.MenuItemModifierGroupService;

@Service
public class MenuItemModifierGroupServiceImpl implements MenuItemModifierGroupService {

	@Autowired
	MenuItemModifierGroupDAO menuItemModifierGroupDao;

	@Override
	public boolean save(MenuItemModifierGroup menuItemModifierGroup) throws Exception {
		return menuItemModifierGroupDao.save(menuItemModifierGroup);
	}

}
