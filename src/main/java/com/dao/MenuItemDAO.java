package com.dao;

import com.model.MenuItem;

public interface MenuItemDAO {
	public boolean save(MenuItem menuItem) throws Exception;

	public boolean delete(MenuItem menuItem);

	public boolean saveOrUpdate(MenuItem menuItem);

}