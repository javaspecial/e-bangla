package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ModifierGroupDAO;
import com.model.ModifierGroup;

@Repository
@Transactional
public class ModifierGroupDaoImpl implements ModifierGroupDAO {

	@Autowired
	SessionFactory session;

	@Override
	public boolean save(ModifierGroup modifierGroup) throws Exception {
		session.getCurrentSession().save(modifierGroup);
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
