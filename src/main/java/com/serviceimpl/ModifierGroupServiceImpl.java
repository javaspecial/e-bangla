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

}
