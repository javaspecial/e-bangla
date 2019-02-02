package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TaxDAO;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(Tax tax) throws Exception {
		session.getCurrentSession().save(tax);
		return true;
	}

}
