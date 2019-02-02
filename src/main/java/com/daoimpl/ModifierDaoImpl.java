package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ModifierDao;
import com.model.Modifier;

@Transactional
@Repository
public class ModifierDaoImpl implements ModifierDao {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(Modifier modifier) throws Exception {
		session.getCurrentSession().save(modifier);
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
