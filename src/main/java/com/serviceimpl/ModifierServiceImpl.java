package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ModifierDao;
import com.model.Modifier;
import com.service.ModifierService;

@Service
public class ModifierServiceImpl implements ModifierService {

	@Autowired
	ModifierDao modifierDao;

	@Override
	public boolean save(Modifier modifier) throws Exception {
		return modifierDao.save(modifier);
	}

}
