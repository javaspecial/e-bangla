package com.service;

import com.model.MenuGroup;

public interface MenuGroupService {
	public boolean save(MenuGroup menuGroup) throws Exception;

	public boolean saveOrUpdate(MenuGroup menuGroup) throws Exception;

	public boolean delete(MenuGroup menuGroup) throws Exception;

}
