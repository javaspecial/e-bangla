package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ModifierGroupDAO;
import com.model.ModifierGroup;
import com.service.ModifierGroupService;

@Service
public class ModifierGroupServiceImpl implements ModifierGroupService {

	@Autowired
	ModifierGroupDAO modifierGroupDao;

	@Override
	public boolean save(ModifierGroup modifierGroup) throws Exception {
		return modifierGroupDao.save(modifierGroup);
	}

	@Override
	public boolean update(ModifierGroup modifierGroup) throws Exception {
		return modifierGroupDao.update(modifierGroup);
	}

	@Override
	public boolean saveOrUpdate(ModifierGroup modifierGroup) throws Exception {
		return modifierGroupDao.saveOrUpdate(modifierGroup);
	}

	@Override
	public boolean delete(ModifierGroup modifierGroup) throws Exception {
		return modifierGroupDao.delete(modifierGroup);
	}

}
