package com.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuGroupDAO;
import com.model.MenuGroup;

@Repository
@Transactional
public class MenuGroupDaoImpl implements MenuGroupDAO {

	@Autowired
	SessionFactory session;

	@Override
	public List<MenuGroup> menuCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(MenuGroup menuGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(MenuGroup menuGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(MenuGroup menuGroup) throws Exception {
		session.getCurrentSession().save(menuGroup);
		return true;
	}

}
