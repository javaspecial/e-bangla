package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ModifierDao;
import com.helper.PosLog;
import com.model.Modifier;

@Transactional
@Repository
public class ModifierDaoImpl implements ModifierDao {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(Modifier modifier) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		try {
			currentSession.save(modifier);
			transaction.commit();
		} catch (Exception e) {
			PosLog.error(ModifierDaoImpl.class, e.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean delete(Modifier modifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(Modifier modifier) {
		// TODO Auto-generated method stub
		return false;
	}

}
