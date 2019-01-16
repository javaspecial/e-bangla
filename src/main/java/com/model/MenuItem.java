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

/**
 * @author toxic-pc
 *
 */
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "MENU_ITEM")
@Table(name = "MENU_ITEM")
public class MenuItem {
	public final static String MENU_ITEM_ID = "menuItemId";
	public final static String MENU_ITEM_NAME = "name";
	public final static String MENU_ITEM_TRANSLATED_NAME = "translatedName";
	public final static String MENU_ITEM_VISIBLE = "visible";
	public final static String MENU_ITEM_SORT_ORDER = "sortOrder";
	public final static String MENU_ITEM_DESCRIPTION = "description";
	public final static String MENU_ITEM_UNIT_NAME = "unitName";
	public final static String MENU_ITEM_BARCODE = "barcode";
	public final static String MENU_ITEM_BUY_PRICE = "buyPrice";
	public final static String MENU_ITEM_STOCK_AMOUNT = "stockAmount";
	public final static String MENU_ITEM_PRICE = "price";
	public final static String MENU_ITEM_DISCOUNT_RATE = "discountRate";
	public final static String MENU_ITEM_DISABLE_WHEN_STOCK_AMOUNT_IS_ZERO = "disableWhenStockAmountIsZero";
	public final static String MENU_ITEM_IMAGE = "image";
	public final static String MENU_ITEM_SHOW_IMAGE_ONLY = "showImageOnly";
	public final static String MENU_ITEM_FRACTIONAL_UNIT = "fractionUnit";
	public final static String MENU_ITEM_DISCOUNT = "menuItemDiscount";
	public static final String PROPERTIES = "properties";
	public static final String MENUITEM = "menuitem";
	public static final String MENU_ITEM_GROUP = "parent";
	public static final String MENU_ITEM_ORDER_TYPE = "orderType";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = MENU_ITEM_ID, unique = true, nullable = false)
	private Integer menuItemId;

	@Column(name = MENU_ITEM_NAME)
	private String name;

	@Column(name = MENU_ITEM_TRANSLATED_NAME)
	private String translatedName;

	@Column(name = MENU_ITEM_VISIBLE)
	private boolean visible;

	@Column(name = MENU_ITEM_SORT_ORDER)
	private Integer sortOrder;

	@Column(name = MENU_ITEM_DESCRIPTION)
	private String description;

	@Column(name = MENU_ITEM_UNIT_NAME)
	private String unitName;

	@Column(name = MENU_ITEM_BARCODE)
	private String barcode;

	@Column(name = MENU_ITEM_BUY_PRICE)
	private double buyPrice;

	@Column(name = MENU_ITEM_STOCK_AMOUNT)
	private double stockAmount;

	@Column(name = MENU_ITEM_PRICE)
	private double price;

	@Column(name = MENU_ITEM_DISCOUNT_RATE)
	private double discountRate;

	@Column(name = MENU_ITEM_DISABLE_WHEN_STOCK_AMOUNT_IS_ZERO)
	private Boolean disableWhenStockAmountIsZero;

	@Lob
	@Column(name = MENU_ITEM_IMAGE, columnDefinition = "BLOB")
	private byte[] image;

	@Column(name = MENU_ITEM_SHOW_IMAGE_ONLY)
	private Boolean showImageOnly;

	@Column(name = MENU_ITEM_FRACTIONAL_UNIT)
	private Boolean fractionUnit;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = MENU_ITEM_DISCOUNT, joinColumns = @JoinColumn(name = MENU_ITEM_ID), inverseJoinColumns = @JoinColumn(name = Discount.DISCOUNT_ID))
	private List<Discount> menuItemDiscount;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = MENU_ITEM_GROUP, referencedColumnName = MenuGroup.MENU_GROUP_ID)
	private MenuGroup parent;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = MENU_ITEM_ID)
	private List<MenuItemModifierGroup> menuItemModifierGroup;

	@ManyToMany(mappedBy = Terminal.MENU_ITEM)
	private List<Terminal> terminal;

	@ManyToMany(mappedBy = OrderType.ORDER_TYPE_MENUITEM)
	private List<OrderType> orderType;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = TaxGroup.TAX_GROUP_ID, referencedColumnName = TaxGroup.TAX_GROUP_ID)
	private TaxGroup taxGroup;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = VirtualPrinter.VIRTUAL_PRINTER_ID, referencedColumnName = VirtualPrinter.VIRTUAL_PRINTER_ID)
	private VirtualPrinter virtualPrinter;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = PrinterGroup.PRINTER_GROUP_ID, referencedColumnName = PrinterGroup.PRINTER_GROUP_ID)
	private PrinterGroup printerGroup;

	@ElementCollection
	@MapKeyColumn(name = MENUITEM)
	@Column(name = PROPERTIES)
	@CollectionTable(name = MENUITEM + "_" + PROPERTIES)
	private Map<Integer, String> properties;

	public MenuItem() {
	}

	public MenuItem(Integer id, String name, Double buyPrice, Double price) {
		setMenuItemId(id);
		setName(name);
		setBuyPrice(buyPrice);
		setPrice(price);
	}

	/**
	 * @return the properties
	 */
	public Map<Integer, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(Map<Integer, String> properties) {
		this.properties = properties;
	}

	/**
	 * @return the menuGroup
	 */
	public MenuGroup getParent() {
		return parent;
	}

	/**
	 * @param menuGroup
	 *            the menuGroup to set
	 */
	public void setParent(MenuGroup parent) {
		this.parent = parent;
	}

	/**
	 * @return the menuItemModifierGroup
	 */
	public List<MenuItemModifierGroup> getMenuItemModifierGroup() {
		return menuItemModifierGroup;
	}

	/**
	 * @param menuItemModifierGroup
	 *            the menuItemModifierGroup to set
	 */
	public void setMenuItemModifierGroup(List<MenuItemModifierGroup> menuItemModifierGroup) {
		this.menuItemModifierGroup = menuItemModifierGroup;
	}

	/**
	 * @return the terminal
	 */
	public List<Terminal> getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(List<Terminal> terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the taxGroup
	 */
	public TaxGroup getTaxGroup() {
		return taxGroup;
	}

	/**
	 * @param taxGroup
	 *            the taxGroup to set
	 */
	public void setTaxGroup(TaxGroup taxGroup) {
		this.taxGroup = taxGroup;
	}

	/**
	 * @return the virtualPrinter
	 */
	public VirtualPrinter getVirtualPrinter() {
		return virtualPrinter;
	}

	/**
	 * @param virtualPrinter
	 *            the virtualPrinter to set
	 */
	public void setVirtualPrinter(VirtualPrinter virtualPrinter) {
		this.virtualPrinter = virtualPrinter;
	}

	/**
	 * @return the printerGroup
	 */
	public PrinterGroup getPrinterGroup() {
		return printerGroup;
	}

	/**
	 * @param printerGroup
	 *            the printerGroup to set
	 */
	public void setPrinterGroup(PrinterGroup printerGroup) {
		this.printerGroup = printerGroup;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName
	 *            the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode
	 *            the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the buyPrice
	 */
	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice
	 *            the buyPrice to set
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the stockAmount
	 */
	public double getStockAmount() {
		return stockAmount;
	}

	/**
	 * @param stockAmount
	 *            the stockAmount to set
	 */
	public void setStockAmount(double stockAmount) {
		this.stockAmount = stockAmount;
	}

	/**
	 * @return the sellPrice
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param sellPrice
	 *            the sellPrice to set
	 */
	public void setPrice(double sellPrice) {
		this.price = sellPrice;
	}

	/**
	 * @return the discountRate
	 */
	public double getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate
	 *            the discountRate to set
	 */
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	/**
	 * @return the disableWhenStockAmountIsZero
	 */
	public Boolean getDisableWhenStockAmountIsZero() {
		return disableWhenStockAmountIsZero == null ? Boolean.valueOf(false) : disableWhenStockAmountIsZero;
	}

	/**
	 * @param disableWhenStockAmountIsZero
	 *            the disableWhenStockAmountIsZero to set
	 */
	public void setDisableWhenStockAmountIsZero(Boolean disableWhenStockAmountIsZero) {
		this.disableWhenStockAmountIsZero = disableWhenStockAmountIsZero;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the showImageOnly
	 */
	public Boolean getShowImageOnly() {
		return showImageOnly;
	}

	/**
	 * @param showImageOnly
	 *            the showImageOnly to set
	 */
	public void setShowImageOnly(Boolean showImageOnly) {
		this.showImageOnly = showImageOnly;
	}

	/**
	 * @return the fractionUnit
	 */
	public Boolean getFractionUnit() {
		return fractionUnit == null ? Boolean.FALSE : fractionUnit;
	}

	/**
	 * @param fractionUnit
	 *            the fractionUnit to set
	 */
	public void setFractionUnit(Boolean fractionUnit) {
		this.fractionUnit = fractionUnit;
	}

	/**
	 * @return the discount
	 */
	public List<Discount> getMenuItemDiscount() {
		return menuItemDiscount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setMenuItemDiscount(List<Discount> menuItemDiscount) {
		this.menuItemDiscount = menuItemDiscount;
	}

	/**
	 * @return the id
	 */
	public Integer getMenuItemId() {
		return menuItemId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setMenuItemId(Integer id) {
		this.menuItemId = id;
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

	public List<OrderType> getOrderType() {
		return orderType;
	}

	public void setOrderType(List<OrderType> orderType) {
		this.orderType = orderType;
	}
}