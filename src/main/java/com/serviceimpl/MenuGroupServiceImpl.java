package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MenuGroupDAO;
import com.model.MenuGroup;
import com.service.MenuGroupService;

@Service
public class MenuGroupServiceImpl implements MenuGroupService {
	@Autowired
	MenuGroupDAO menuGroupDao;

	@Override
	public boolean save(MenuGroup menuGroup) throws Exception {
		return menuGroupDao.save(menuGroup);
	}

}
