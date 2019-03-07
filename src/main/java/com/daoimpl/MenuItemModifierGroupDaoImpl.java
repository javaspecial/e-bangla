package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.MenuItemModifierGroupDAO;
import com.helper.PosLog;
import com.model.MenuItemModifierGroup;

@Transactional
@Repository
public class MenuItemModifierGroupDaoImpl implements MenuItemModifierGroupDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(MenuItemModifierGroup menuItemModifierGroup) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(menuItemModifierGroup);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuItemModifierGroupDaoImpl.class, e.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean delete(MenuItemModifierGroup menuItemModifierGroup) {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.delete(menuItemModifierGroup);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuItemModifierGroupDaoImpl.class, e.getMessage());
			transaction.rollback();
			return false;
		}
		return true;

	}

	@Override
	public boolean saveOrUpdate(MenuItemModifierGroup menuItemModifierGroup) {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.saveOrUpdate(menuItemModifierGroup);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuItemModifierGroupDaoImpl.class, e.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean update(MenuItemModifierGroup menuItemModifierGroup) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.update(menuItemModifierGroup);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(MenuItemModifierGroupDaoImpl.class, e.getMessage());
			return false;
		}
		return true;

	}

}
