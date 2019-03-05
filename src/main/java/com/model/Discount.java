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

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "DISCOUNT")
public class Discount {
	public static final String DISCOUNT_ID = "discountId";
	public static final String DISCOUNT_NAME = "discountName";
	public static final String DISCOUNT_TYPE = "discountType";
	public static final String DISCOUNT_BARCODE = "discountBarcode";
	public static final String DISCOUNT_QUALIFICATION_TYPE = "discountQualificationType";
	public static final String DISCOUNT_APPLY_TO_ALL = "discountApplyToAll";
	public static final String DISCOUNT_MINIMUM_BUY = "discountMinimumBuy";
	public static final String DISCOUNT_MAXIMUM_OFF = "discountMaximumOff";
	public static final String DISCOUNT_VALUE = "discountValue";
	public static final String DISCOUNT_EXPIRY_DATE = "discountExpiryDate";
	public static final String DISCOUNT_ENABLED = "discountEnabled";
	public static final String DISCOUNT_AUTO_APPLY = "discountAutoApply";
	public static final String DISCOUNT_MODIFIABLE = "discountModifiable";
	public static final String DISCOUNT_NEVER_EXPIRE = "discountNeverExpire";
	public static final String DISCOUNT_UUID = "discountUUID";
	public final static int DISCOUNT_TYPE_AMOUNT = 0;
	public final static int DISCOUNT_TYPE_PERCENTAGE = 1;
	public static final Integer QUALIFICATION_TYPE_ITEM = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DISCOUNT_ID, unique = true, nullable = false)
	private Integer discountId;

	@Column(name = DISCOUNT_NAME)
	private String discountName;

	@Column(name = DISCOUNT_TYPE)
	private Integer discountType;

	@Column(name = DISCOUNT_BARCODE)
	private String discountBarcode;

	@Column(name = DISCOUNT_QUALIFICATION_TYPE)
	private Integer discountQualificationType;

	@Column(name = DISCOUNT_APPLY_TO_ALL)
	private boolean discountApplyToAll;

	@Column(name = DISCOUNT_MINIMUM_BUY)
	private Integer discountMinimumBuy;

	@Column(name = DISCOUNT_MAXIMUM_OFF)
	private Integer discountMaximumOff;

	@Column(name = DISCOUNT_VALUE)
	private double discountValue;

	@Column(name = DISCOUNT_EXPIRY_DATE)
	private Date discountExpiryDate;

	@Column(name = DISCOUNT_ENABLED)
	private boolean discountEnabled;

	@Column(name = DISCOUNT_AUTO_APPLY)
	private boolean discountAutoApply;

	@Column(name = DISCOUNT_MODIFIABLE)
	private boolean discountModifiable;

	@Column(name = DISCOUNT_NEVER_EXPIRE)
	private boolean discountNeverExpire;

	@Column(name = DISCOUNT_UUID)
	private String discountUUID;

	@ManyToMany(mappedBy = MenuGroup.MENU_GROUP_DISCOUNT)
	private List<MenuGroup> menuGroup;

	@ManyToMany(mappedBy = MenuItem.MENU_ITEM_DISCOUNT)
	private List<MenuItem> menuItem;

	public Discount() {
	}

	/**
	 * @return the menuGroup
	 */
	public List<MenuGroup> getMenuGroup() {
		return menuGroup;
	}

	/**
	 * @param menuGroup
	 *            the menuGroup to set
	 */
	public void setMenuGroup(List<MenuGroup> menuGroup) {
		this.menuGroup = menuGroup;
	}

	/**
	 * @return the menuItem
	 */
	public List<MenuItem> getMenuItem() {
		return menuItem;
	}

	/**
	 * @param menuItem
	 *            the menuItem to set
	 */
	public void setMenuItem(List<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}

	/**
	 * @return the discountId
	 */
	public Integer getDiscountId() {
		return discountId;
	}

	/**
	 * @param discountId
	 *            the discountId to set
	 */
	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	/**
	 * @return the discountName
	 */
	public String getDiscountName() {
		return discountName;
	}

	/**
	 * @param discountName
	 *            the discountName to set
	 */
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	/**
	 * @return the discountType
	 */
	public Integer getDiscountType() {
		return discountType;
	}

	/**
	 * @param discountType
	 *            the discountType to set
	 */
	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}

	/**
	 * @return the discountBarcode
	 */
	public String getDiscountBarcode() {
		return discountBarcode;
	}

	/**
	 * @param discountBarcode
	 *            the discountBarcode to set
	 */
	public void setDiscountBarcode(String discountBarcode) {
		this.discountBarcode = discountBarcode;
	}

	/**
	 * @return the discountQualificationType
	 */
	public Integer getDiscountQualificationType() {
		return discountQualificationType;
	}

	/**
	 * @param discountQualificationType
	 *            the discountQualificationType to set
	 */
	public void setDiscountQualificationType(Integer discountQualificationType) {
		this.discountQualificationType = discountQualificationType;
	}

	/**
	 * @return the discountApplyToAll
	 */
	public boolean isDiscountApplyToAll() {
		return discountApplyToAll;
	}

	/**
	 * @param discountApplyToAll
	 *            the discountApplyToAll to set
	 */
	public void setDiscountApplyToAll(boolean discountApplyToAll) {
		this.discountApplyToAll = discountApplyToAll;
	}

	/**
	 * @return the discountMinimumBuy
	 */
	public Integer getDiscountMinimumBuy() {
		return discountMinimumBuy;
	}

	/**
	 * @param discountMinimumBuy
	 *            the discountMinimumBuy to set
	 */
	public void setDiscountMinimumBuy(Integer discountMinimumBuy) {
		this.discountMinimumBuy = discountMinimumBuy;
	}

	/**
	 * @return the discountMaximumOff
	 */
	public Integer getDiscountMaximumOff() {
		return discountMaximumOff;
	}

	/**
	 * @param discountMaximumOff
	 *            the discountMaximumOff to set
	 */
	public void setDiscountMaximumOff(Integer discountMaximumOff) {
		this.discountMaximumOff = discountMaximumOff;
	}

	/**
	 * @return the discountValue
	 */
	public double getDiscountValue() {
		return discountValue;
	}

	/**
	 * @param discountValue
	 *            the discountValue to set
	 */
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	/**
	 * @return the discountExpiryDate
	 */
	public Date getDiscountExpiryDate() {
		return discountExpiryDate;
	}

	/**
	 * @param discountExpiryDate
	 *            the discountExpiryDate to set
	 */
	public void setDiscountExpiryDate(Date discountExpiryDate) {
		this.discountExpiryDate = discountExpiryDate;
	}

	/**
	 * @return the discountEnabled
	 */
	public boolean isDiscountEnabled() {
		return discountEnabled;
	}

	/**
	 * @param discountEnabled
	 *            the discountEnabled to set
	 */
	public void setDiscountEnabled(boolean discountEnabled) {
		this.discountEnabled = discountEnabled;
	}

	/**
	 * @return the discountAutoApply
	 */
	public boolean isDiscountAutoApply() {
		return discountAutoApply;
	}

	/**
	 * @param discountAutoApply
	 *            the discountAutoApply to set
	 */
	public void setDiscountAutoApply(boolean discountAutoApply) {
		this.discountAutoApply = discountAutoApply;
	}

	/**
	 * @return the discountModifiable
	 */
	public boolean isDiscountModifiable() {
		return discountModifiable;
	}

	/**
	 * @param discountModifiable
	 *            the discountModifiable to set
	 */
	public void setDiscountModifiable(boolean discountModifiable) {
		this.discountModifiable = discountModifiable;
	}

	/**
	 * @return the discountNeverExpire
	 */
	public boolean isDiscountNeverExpire() {
		return discountNeverExpire;
	}

	/**
	 * @param discountNeverExpire
	 *            the discountNeverExpire to set
	 */
	public void setDiscountNeverExpire(boolean discountNeverExpire) {
		this.discountNeverExpire = discountNeverExpire;
	}

	/**
	 * @return the discountUUID
	 */
	public String getDiscountUUID() {
		return discountUUID;
	}

	/**
	 * @param discountUUID
	 *            the discountUUID to set
	 */
	public void setDiscountUUID(String discountUUID) {
		this.discountUUID = discountUUID;
	}
}
