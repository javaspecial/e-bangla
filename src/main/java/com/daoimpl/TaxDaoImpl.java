package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TaxDAO;
import com.helper.PosLog;
import com.model.Tax;

@Repository
@Transactional
public class TaxDaoImpl implements TaxDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean delete(Tax tax) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate(Tax tax) {
		Session currentSession = session.getCurrentSession();
		Transaction trans = currentSession.beginTransaction();
		try {
			currentSession.saveOrUpdate(tax);
			trans.commit();
		} catch (Exception e) {
			PosLog.error(TaxDaoImpl.class, e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean save(Tax tax) throws Exception {
		Session currentSession = session.getCurrentSession();
		Transaction trans = currentSession.beginTransaction();
		try {
			currentSession.save(tax);
			trans.commit();
		} catch (Exception e) {
			PosLog.error(TaxDaoImpl.class, e.getMessage());
			return false;
		}
		return true;
	}

}
