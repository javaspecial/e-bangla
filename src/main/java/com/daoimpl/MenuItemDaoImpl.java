package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuItemDAO;
import com.model.MenuItem;

@Repository
@Transactional
public class MenuItemDaoImpl implements MenuItemDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(MenuItem menuItem) throws Exception {
		session.getCurrentSession().save(menuItem);
		return true;
	}

	@Override
	public boolean delete(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return false;
	}

}
