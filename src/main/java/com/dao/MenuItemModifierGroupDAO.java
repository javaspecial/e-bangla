package com.dao;

import com.model.MenuItemModifierGroup;

public interface MenuItemModifierGroupDAO {
	public boolean save(MenuItemModifierGroup menuItemModifierGroup) throws Exception;

	public boolean delete(MenuItemModifierGroup menuItemModifierGroup);

	public boolean saveOrUpdate(MenuItemModifierGroup menuItemModifierGroup);

}
