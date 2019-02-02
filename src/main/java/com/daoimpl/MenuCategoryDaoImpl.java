package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuCategoryDAO;
import com.model.MenuCategory;

@Repository
@Transactional
public class MenuCategoryDaoImpl implements MenuCategoryDAO {

	@Autowired
	SessionFactory session;

	@Override
	public List<MenuCategory> menuCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(MenuCategory menuCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(MenuCategory menuCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(MenuCategory menuCategory) throws Exception {
		session.getCurrentSession().save(menuCategory);
		return true;
	}
}
