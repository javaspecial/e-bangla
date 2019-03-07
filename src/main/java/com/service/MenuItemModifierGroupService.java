package com.service;

import com.model.MenuItemModifierGroup;

public interface MenuItemModifierGroupService {
	public boolean save(MenuItemModifierGroup menuItemModifierGroup) throws Exception;

	public boolean update(MenuItemModifierGroup menuItemModifierGroup) throws Exception;

	public boolean saveOrUpdate(MenuItemModifierGroup menuItemModifierGroup) throws Exception;

	public boolean delete(MenuItemModifierGroup menuItemModifierGroup) throws Exception;
}
