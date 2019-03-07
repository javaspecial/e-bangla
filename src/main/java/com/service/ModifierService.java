package com.service;

import com.model.Modifier;

public interface ModifierService {
	public boolean save(Modifier modifier) throws Exception;

	public boolean update(Modifier modifier) throws Exception;

	public boolean saveOrUpdate(Modifier modifier) throws Exception;

	public boolean delete(Modifier modifier) throws Exception;
}
