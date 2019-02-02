package com.dao;

import com.model.ModifierGroup;

public interface ModifierGroupDAO {
	public boolean save(ModifierGroup modifierGroup) throws Exception;

	public boolean delete(ModifierGroup modifierGroup);

	public boolean saveOrUpdate(ModifierGroup modifierGroup);
}