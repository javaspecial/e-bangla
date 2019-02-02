package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuItemModifierGroupDAO;
import com.model.MenuItemModifierGroup;

@Transactional
@Repository
public class MenuItemModifierGroupDaoImpl implements MenuItemModifierGroupDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(MenuItemModifierGroup menuItemModifierGroup) throws Exception {
		session.getCurrentSession().save(menuItemModifierGroup);
		return true;
	}

	@Override
	public boolean delete(MenuItemModifierGroup menuItemModifierGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(MenuItemModifierGroup menuItemModifierGroup) {
		// TODO Auto-generated method stub
		return false;
	}

}
