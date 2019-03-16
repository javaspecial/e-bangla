package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MENU_CATEGORY")
public class MenuCategory {
	public final static String MENU_CATEGORY_ID = "id";
	public final static String MENU_CATEGORY_NAME = "name";
	public final static String MENU_CATEGORY_TRANSLATED_NAME = "translatedName";
	public final static String MENU_CATEGORY_VISIBLE = "visible";
	public final static String MENU_CATEGORY_SORT_ORDER = "sortOrder";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = MENU_CATEGORY_ID, unique = true, nullable = false)
	private Integer id;

	@Column(name = MENU_CATEGORY_NAME)
	private String name;

	@Column(name = MENU_CATEGORY_TRANSLATED_NAME)
	private String translatedName;

	@Column(name = MENU_CATEGORY_VISIBLE)
	private boolean visible;

	@Column(name = MENU_CATEGORY_SORT_ORDER)
	private Integer sortOrder = 9999;

	@Transient
	private List<MenuGroup> menuGroups;

	public MenuCategory() {

	}

	public MenuCategory(Integer id, String name) {
		setId(id);
		setName(name);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the translatedName
	 */
	public String getTranslatedName() {
		return translatedName;
	}

	/**
	 * @param translatedName
	 *            the translatedName to set
	 */
	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the sortOrder
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 *            the sortOrder to set
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * Return the value associated with the column: menuGroups
	 */
	public List<MenuGroup> getMenuGroups() {
		return menuGroups;
	}

	/**
	 * Set the value related to the column: menuGroups
	 * 
	 * @param menuGroups
	 *            the menuGroups value
	 */
	public void setMenuGroups(List<MenuGroup> menuGroups) {
		this.menuGroups = menuGroups;
	}

	@Override
	public String toString() {
		return String.format("MenuCategory[id=%d, name='%s', translatedName='%s',visible='%s',sortOrder='%s']", id, name, translatedName, visible, sortOrder);
	}

	public String getUniqueId() {
		return ("category_" + getName() + "_" + getId());
	}
}