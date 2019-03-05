package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ModifierGroupDAO;
import com.helper.PosLog;
import com.model.ModifierGroup;

@Repository
@Transactional
public class ModifierGroupDaoImpl implements ModifierGroupDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(ModifierGroup modifierGroup) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(modifierGroup);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(ModifierGroupDaoImpl.class, e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(ModifierGroup modifierGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(ModifierGroup modifierGroup) {
		// TODO Auto-generated method stub
		return false;
	}

}
