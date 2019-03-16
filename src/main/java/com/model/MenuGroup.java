/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.softpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is SOFT POS.
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "MENU_GROUP")
public class MenuGroup {
	public static final String MENU_GROUP_ID = "groupId";
	public static final String MENU_GROUP_NAME = "name";
	public static final String MENU_GROUP_TRANSLATED_NAME = "translatedName";
	public static final String MENU_GROUP_VISIBLE = "visible";
	public static final String MENU_GROUP_SORT_ORDER = "sortOrder";
	public static final String MENU_GROUP_DISCOUNT = "menuGroupDiscount";
	public static final String MENU_GROUP_CATEGORY = "parent";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = MENU_GROUP_ID, unique = true, nullable = false)
	private Integer groupId;

	@Column(name = MENU_GROUP_NAME)
	private String name;

	@Column(name = MENU_GROUP_TRANSLATED_NAME)
	private String translatedName;

	@Column(name = MENU_GROUP_VISIBLE)
	private Boolean visible;

	@Column(name = MENU_GROUP_SORT_ORDER)
	private Integer sortOrder = 9999;

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = MENU_GROUP_DISCOUNT, joinColumns = @JoinColumn(name = MENU_GROUP_ID), inverseJoinColumns = @JoinColumn(name = Discount.DISCOUNT_ID))
	private List<Discount> menuGroupDiscount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = MENU_GROUP_CATEGORY, referencedColumnName = MenuCategory.MENU_CATEGORY_ID)
	private MenuCategory parent;

	public MenuGroup() {
	}

	public MenuGroup(Integer id, String name) {
		setGroupId(id);
		setName(name);
	}

	/**
	 * @return the menuCategory
	 */
	public MenuCategory getParent() {
		return parent;
	}

	/**
	 * @param menuCategory the menuCategory to set
	 */
	public void setParent(MenuCategory parent) {
		this.parent = parent;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the discount
	 */
	public List<Discount> getMenuGroupDiscount() {
		return menuGroupDiscount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setMenuGroupDiscount(List<Discount> menuGroupDiscount) {
		this.menuGroupDiscount = menuGroupDiscount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param translatedName the translatedName to set
	 */
	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}

	/**
	 * @return the visible
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the sortOrder
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getUniqueId() {
		return ("menu_group_" + getName() + "_" + getGroupId()).replaceAll("\\s+", "_");
	}

	@Override
	public String toString() {
		return String.format(
				"MenuGroup[groupId=%d, name='%s', translatedName='%s',visible='%s',sortOrder=%d,parent='%s']", groupId,
				name, translatedName, visible, sortOrder, parent);
	}
}
