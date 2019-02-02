package com.resources;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.model.MenuCategory;
import com.model.MenuGroup;
import com.model.MenuItem;
import com.model.MenuItemModifierGroup;
import com.model.Modifier;
import com.model.ModifierGroup;
import com.model.Tax;
import com.model.User;
import com.model.UserType;

@XmlRootElement(name = "elements")
public class Elements {
	List<User> users;
	List<UserType> userTypes;
	List<Tax> taxes;
	List<MenuCategory> menuCategories;
	List<MenuGroup> menuGroups;
	List<Modifier> menuModifiers;
	List<MenuItemModifierGroup> menuItemModifierGroups;
	List<ModifierGroup> modifierGroups;
	List<MenuItem> menuItems;

	public List<MenuCategory> getMenuCategories() {
		return menuCategories;
	}

	public void setMenuCategories(List<MenuCategory> menuCategories) {
		this.menuCategories = menuCategories;
	}

	public List<MenuGroup> getMenuGroups() {
		return menuGroups;
	}

	public void setMenuGroups(List<MenuGroup> menuGroups) {
		this.menuGroups = menuGroups;

		if (menuGroups == null) {
			return;
		}

		for (MenuGroup menuGroup : menuGroups) {
			MenuCategory parent = menuGroup.getParent();
			if (parent != null) {
				parent.setMenuGroups(null);
			}
		}
	}

	public List<Modifier> getMenuModifiers() {
		return menuModifiers;
	}

	public void setMenuModifiers(List<Modifier> menuModifiers) {
		this.menuModifiers = menuModifiers;
		if (menuModifiers == null)
			return;

		for (Modifier modifier : menuModifiers) {
			ModifierGroup modifierGroup = modifier.getModifierGroup();
			if (modifierGroup != null) {
				modifierGroup.setModifier(null);
			}
		}
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public List<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<Tax> taxes) {
		this.taxes = taxes;
	}

	public List<MenuItemModifierGroup> getMenuItemModifierGroups() {
		return menuItemModifierGroups;
	}

	public void setMenuItemModifierGroups(List<MenuItemModifierGroup> menuItemModifierGroups) {
		this.menuItemModifierGroups = menuItemModifierGroups;
	}

	public List<ModifierGroup> getModifierGroups() {
		return modifierGroups;
	}

	public void setModifierGroups(List<ModifierGroup> modifierGroups) {
		this.modifierGroups = modifierGroups;
	}

	public List<UserType> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
