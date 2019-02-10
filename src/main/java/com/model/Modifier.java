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
@Table(name = "MODIFIER")
public class Modifier {
	public static final String MODIFIER_ID = "modifierId";
	public static final String MODIFIER_NAME = "name";
	public static final String MODIFIER_TRANSLATED_NAME = "modifierTranslatedName";
	public static final String MODIFIER_PRICE = "price";
	public static final String MODIFIER_SORT_ORDER = "modifierSortOrder";
	public static final String MODIFIER_ENABLE = "enable";
	public static final String MODIFIER_FIXED_PRICE = "modifierFixedPrice";
	public static final String MODIFIER_GROUP = "modifierGroup";
	public static final String MODIFIER_TAX = "tax";
	public static final String MODIFIER_SHOULD_PRINTED_TO_KITCHEN = "shouldPrintToKitchen";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = MODIFIER_ID, unique = true, nullable = false)
	private Integer modifierId;

	@Column(name = MODIFIER_NAME)
	private String name;

	@Column(name = MODIFIER_TRANSLATED_NAME)
	private String modifierTranslatedName;

	@Column(name = MODIFIER_PRICE)
	private double price;

	@Column(name = MODIFIER_SORT_ORDER)
	private Integer modifierSortOrder;

	@Column(name = MODIFIER_ENABLE)
	private Boolean enable;

	@Column(name = MODIFIER_SHOULD_PRINTED_TO_KITCHEN)
	private Boolean shouldPrintToKitchen;

	@Column(name = MODIFIER_FIXED_PRICE)
	private double modifierFixedPrice;

	@Column(name = ModifierGroup.MODIFIER_GROUP_ID)
	private Integer modifierGroupId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = MODIFIER_TAX, referencedColumnName = Tax.TAX_ID)
	private Tax tax;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = MODIFIER_GROUP, referencedColumnName = ModifierGroup.MODIFIER_GROUP_ID)
	private ModifierGroup modifierGroup;

	public Modifier() {
	}

	/**
	 * @return the modifierName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param modifierName
	 *            the modifierName to set
	 */
	public void setName(String modifierName) {
		this.name = modifierName;
	}

	/**
	 * @return the modifierTranslatedName
	 */
	public String getModifierTranslatedName() {
		return modifierTranslatedName;
	}

	/**
	 * @param modifierTranslatedName
	 *            the modifierTranslatedName to set
	 */
	public void setModifierTranslatedName(String modifierTranslatedName) {
		this.modifierTranslatedName = modifierTranslatedName;
	}

	/**
	 * @return the modifierPrice
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param modifierPrice
	 *            the modifierPrice to set
	 */
	public void setPrice(double modifierPrice) {
		this.price = modifierPrice;
	}

	/**
	 * @return the modifierSortOrder
	 */
	public Integer getModifierSortOrder() {
		return modifierSortOrder;
	}

	/**
	 * @param modifierSortOrder
	 *            the modifierSortOrder to set
	 */
	public void setModifierSortOrder(Integer modifierSortOrder) {
		this.modifierSortOrder = modifierSortOrder;
	}

	/**
	 * @return the modifierEnable
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param modifierEnable
	 *            the modifierEnable to set
	 */
	public void setEnable(Boolean modifierEnable) {
		this.enable = modifierEnable;
	}

	/**
	 * @return the modifierFixedPrice
	 */
	public double getModifierFixedPrice() {
		return modifierFixedPrice;
	}

	/**
	 * @param modifierFixedPrice
	 *            the modifierFixedPrice to set
	 */
	public void setModifierFixedPrice(double modifierFixedPrice) {
		this.modifierFixedPrice = modifierFixedPrice;
	}

	/**
	 * @return the tax
	 */
	public Tax getTax() {
		return tax;
	}

	/**
	 * @param tax
	 *            the tax to set
	 */
	public void setTax(Tax tax) {
		this.tax = tax;
	}

	/**
	 * @return the modifierId
	 */
	public Integer getModifierId() {
		return modifierId;
	}

	/**
	 * @param modifierId
	 *            the modifierId to set
	 */
	public void setModifierId(Integer modifierId) {
		this.modifierId = modifierId;
	}

	/**
	 * @return the modifierGroupId
	 */
	public Integer getModifierGroupId() {
		return modifierGroupId;
	}

	public Boolean getShouldPrintToKitchen() {
		return shouldPrintToKitchen;
	}

	public void setShouldPrintToKitchen(Boolean shouldPrintToKitchen) {
		this.shouldPrintToKitchen = shouldPrintToKitchen;
	}

	/**
	 * @param modifierGroupId
	 *            the modifierGroupId to set
	 */
	public void setModifierGroupId(Integer modifierGroupId) {
		this.modifierGroupId = modifierGroupId;
	}

	public ModifierGroup getModifierGroup() {
		return modifierGroup;
	}

	public void setModifierGroup(ModifierGroup modifierGroup) {
		this.modifierGroup = modifierGroup;
	}

	public String getUniqueId() {
		return ("menu_modifier_" + getName() + "_" + getModifierId()).replaceAll("\\s+", "_");
	}
}
