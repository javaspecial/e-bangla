package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuItemDAO;
import com.helper.PosLog;
import com.model.MenuItem;

@Repository
@Transactional
public class MenuItemDaoImpl implements MenuItemDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(MenuItem menuItem) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(menuItem);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuItemDaoImpl.class, e.getMessage());
			return false;
		}
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
