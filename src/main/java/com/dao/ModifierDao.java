package com.dao;

import com.model.Modifier;

public interface ModifierDao {
	public boolean save(Modifier modifier) throws Exception;

	public boolean delete(Modifier modifier);

	public boolean saveOrUpdate(Modifier modifier);
}
