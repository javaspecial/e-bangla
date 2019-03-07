package com.service;

import com.model.ModifierGroup;

public interface ModifierGroupService {
	public boolean save(ModifierGroup modifierGroup) throws Exception;

	public boolean update(ModifierGroup modifierGroup) throws Exception;

	public boolean saveOrUpdate(ModifierGroup modifierGroup) throws Exception;

	public boolean delete(ModifierGroup modifierGroup) throws Exception;

}
