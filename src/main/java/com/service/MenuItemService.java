package com.service;

import com.model.MenuItem;

public interface MenuItemService {
	public boolean save(MenuItem menuItem) throws Exception;

	public boolean update(MenuItem menuItem) throws Exception;

	public boolean delete(MenuItem menuItem) throws Exception;

	public boolean saveOrUpdate(MenuItem menuItem) throws Exception;

}
