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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "MENU_ITEM_MODIFIER_GROUP")
public class MenuItemModifierGroup {
	public final static String MENUITEM_MODIFIER_GROUP_ID = "id";
	public final static String MENUITEM_MODIFIER_MIN_QUANTITY = "minQuantity";
	public final static String MENUITEM_MODIFIER_MAX_QUANTITY = "maxQuantity";
	public final static String MENUITEM_MODIFIER_SORT_ORDER = "sortOrder";
	public final static String MENUITEM_MODIFIER_GROUP = "modifierGroup";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = MENUITEM_MODIFIER_GROUP_ID, unique = true, nullable = false)
	private Integer id;

	@Column(name = MENUITEM_MODIFIER_MIN_QUANTITY)
	private Integer minQuantity;

	@Column(name = MENUITEM_MODIFIER_MAX_QUANTITY)
	private Integer maxQuantity;

	@Column(name = MENUITEM_MODIFIER_SORT_ORDER)
	private Integer sortOrder;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = MENUITEM_MODIFIER_GROUP, referencedColumnName = ModifierGroup.MODIFIER_GROUP_ID)
	private ModifierGroup modifierGroup;

	public MenuItemModifierGroup() {
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
	 * @return the minQuantity
	 */
	public Integer getMinQuantity() {
		return minQuantity;
	}

	/**
	 * @param minQuantity
	 *            the minQuantity to set
	 */
	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	/**
	 * @return the maxQuantity
	 */
	public Integer getMaxQuantity() {
		return maxQuantity;
	}

	/**
	 * @param maxQuantity
	 *            the maxQuantity to set
	 */
	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
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
	 * @return the menuGroup
	 */
	public ModifierGroup getModifierGroup() {
		return modifierGroup;
	}

	/**
	 * @param menuGroup
	 *            the menuGroup to set
	 */
	public void setModifierGroup(ModifierGroup menuGroup) {
		this.modifierGroup = menuGroup;
	}

	public String getUniqueId() {
		return ("menuitem_modifiergroup_" + toString() + "_" + getId()).replaceAll("\\s+", "_");
	}
}
