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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "SHOP")
public class Shop {
	public static final String SHOP_ID = "shop_id";
	public static final String SHOP_NAME = "shop_name";
	public static final String SHOP_ADDRESS = "shop_address";
	public static final String SHOP_ZIP_CODE = "shop_zip_code";
	public static final String SHOP_TELEPHONE = "shop_telephone";
	public static final String SHOP_CAPACITY = "shop_capacity";
	public static final String SHOP_TABLES = "shop_tables";
	public static final String SHOP_CURRENCY_NAME = "shop_currency_name";
	public static final String SHOP_CURRENCY_SYMBOL = "shop_currency_symbol";
	public static final String SHOP_SERVICE_CHARGE_PERCENTAGE = "shop_service_charge_percentage";
	public static final String SHOP_TIPS_PERCENTAGE = "shop_tips_percentage";
	public static final String SHOP_TICKET_FOOTER = "shop_ticket_footer";
	public static final String SHOP_PRICE_INCLUDES_TAX = "shop_price_include_tax";
	public static final String SHOP_ALLOW_MODIFIER_MAX_EXCEED = "shop_allow_modifier_max_exceed";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = SHOP_ID, unique = true, nullable = false)
	private Integer shopId;

	@Column(name = SHOP_NAME)
	private String shopName;

	@Column(name = SHOP_ADDRESS)
	private String shopAddress;

	@Column(name = SHOP_ZIP_CODE)
	private String shopZipCode;

	@Column(name = SHOP_TELEPHONE)
	private String shopTelephone;

	@Column(name = SHOP_CAPACITY)
	private Integer shopCapacity;

	@Column(name = SHOP_TABLES)
	private Integer shopTables;

	@Column(name = SHOP_CURRENCY_NAME)
	private String shopCurrencyName;

	@Column(name = SHOP_CURRENCY_SYMBOL)
	private String shopCurrencySymbol;

	@Column(name = SHOP_SERVICE_CHARGE_PERCENTAGE)
	private Double shopServiceChargePercentage;

	@Column(name = SHOP_TIPS_PERCENTAGE)
	private double shopTipsPercentage;

	@Column(name = SHOP_TICKET_FOOTER)
	private String shopTicketFooter;

	@Column(name = SHOP_PRICE_INCLUDES_TAX)
	private boolean shopPriceIncludeTax;

	@Column(name = SHOP_ALLOW_MODIFIER_MAX_EXCEED)
	private boolean shopAllowModifierMaxExceed;

	@Transient
	private Integer uniqueId;

	public Shop() {
	}

	public Integer getUniqueId() {
		return uniqueId == null ? Integer.valueOf(0) : uniqueId;
	}

	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return the shopId
	 */
	public Integer getShopId() {
		return shopId;
	}

	/**
	 * @param shopId
	 *            the shopId to set
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName
	 *            the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shopAddress
	 */
	public String getShopAddress() {
		return shopAddress;
	}

	/**
	 * @param shopAddress
	 *            the shopAddress to set
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	/**
	 * @return the shopZipCode
	 */
	public String getShopZipCode() {
		return shopZipCode;
	}

	/**
	 * @param shopZipCode
	 *            the shopZipCode to set
	 */
	public void setShopZipCode(String shopZipCode) {
		this.shopZipCode = shopZipCode;
	}

	/**
	 * @return the shopTelephone
	 */
	public String getShopTelephone() {
		return shopTelephone;
	}

	/**
	 * @param shopTelephone
	 *            the shopTelephone to set
	 */
	public void setShopTelephone(String shopTelephone) {
		this.shopTelephone = shopTelephone;
	}

	/**
	 * @return the shopCapacity
	 */
	public Integer getShopCapacity() {
		return shopCapacity;
	}

	/**
	 * @param shopCapacity
	 *            the shopCapacity to set
	 */
	public void setShopCapacity(Integer shopCapacity) {
		this.shopCapacity = shopCapacity;
	}

	/**
	 * @return the shopTables
	 */
	public Integer getShopTables() {
		return shopTables;
	}

	/**
	 * @param shopTables
	 *            the shopTables to set
	 */
	public void setShopTables(Integer shopTables) {
		this.shopTables = shopTables;
	}

	/**
	 * @return the shopCurrencyName
	 */
	public String getShopCurrencyName() {
		return shopCurrencyName;
	}

	/**
	 * @param shopCurrencyName
	 *            the shopCurrencyName to set
	 */
	public void setShopCurrencyName(String shopCurrencyName) {
		this.shopCurrencyName = shopCurrencyName;
	}

	/**
	 * @return the shopCurrencySymbol
	 */
	public String getShopCurrencySymbol() {
		return shopCurrencySymbol;
	}

	/**
	 * @param shopCurrencySymbol
	 *            the shopCurrencySymbol to set
	 */
	public void setShopCurrencySymbol(String shopCurrencySymbol) {
		this.shopCurrencySymbol = shopCurrencySymbol;
	}

	/**
	 * @return the shopServiceChargePercentage
	 */
	public Double getShopServiceChargePercentage() {
		return shopServiceChargePercentage == null ? Double.valueOf(0) : shopServiceChargePercentage;
	}

	/**
	 * @param shopServiceChargePercentage
	 *            the shopServiceChargePercentage to set
	 */
	public void setShopServiceChargePercentage(double shopServiceChargePercentage) {
		this.shopServiceChargePercentage = shopServiceChargePercentage;
	}

	/**
	 * @return the shopTipsPercentage
	 */
	public double getShopTipsPercentage() {
		return shopTipsPercentage;
	}

	/**
	 * @param shopTipsPercentage
	 *            the shopTipsPercentage to set
	 */
	public void setShopTipsPercentage(double shopTipsPercentage) {
		this.shopTipsPercentage = shopTipsPercentage;
	}

	/**
	 * @return the shopTicketFooter
	 */
	public String getShopTicketFooter() {
		return shopTicketFooter;
	}

	/**
	 * @param shopTicketFooter
	 *            the shopTicketFooter to set
	 */
	public void setShopTicketFooter(String shopTicketFooter) {
		this.shopTicketFooter = shopTicketFooter;
	}

	/**
	 * @return the shopPriceIncludeTax
	 */
	public boolean isShopPriceIncludeTax() {
		return shopPriceIncludeTax;
	}

	/**
	 * @param shopPriceIncludeTax
	 *            the shopPriceIncludeTax to set
	 */
	public void setShopPriceIncludeTax(boolean shopPriceIncludeTax) {
		this.shopPriceIncludeTax = shopPriceIncludeTax;
	}

	/**
	 * @return the shopAllowModifierMaxExceed
	 */
	public boolean isShopAllowModifierMaxExceed() {
		return shopAllowModifierMaxExceed;
	}

	/**
	 * @param shopAllowModifierMaxExceed
	 *            the shopAllowModifierMaxExceed to set
	 */
	public void setShopAllowModifierMaxExceed(boolean shopAllowModifierMaxExceed) {
		this.shopAllowModifierMaxExceed = shopAllowModifierMaxExceed;
	}
}
