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

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "TICKET_ITEM")
public class TicketItem {
	public final static String TICKET_ITEM_ID = "ticketItemId";
	public final static String TICKET_ITEM_COUNT = "ticketItemCount";
	public final static String TICKET_ITEM_QUANTITY = "ticketItemQuantity";
	public final static String TICKET_ITEM_NAME = "ticketItemName";
	public final static String TICKET_ITEM_UNIT_NAME = "ticketItemUnitName";
	public final static String TICKET_ITEM_PRICE = "ticketItemPrice";
	public final static String TICKET_ITEM_GROUP_NAME = "ticketItemGroupName";
	public final static String TICKET_ITEM_CATEGORY_NAME = "ticketItemCategoryName";
	public final static String TICKET_ITEM_TAX_RATE = "ticketItemTaxRate";
	public final static String TICKET_ITEM_SUB_TOTAL = "ticketItemSubTotal";
	public final static String TICKET_ITEM_SUB_TOTAL_WITHOUT_MODIFIERS = "ticketItemSubTotalWithoutModifiers";
	public final static String TICKET_ITEM_DISCOUNT = "ticketItemDiscount";
	public final static String TICKET_ITEM_TAX = "ticketItemTax";
	public final static String TICKET_ITEM_TAX_WITHOUT_MODIFIERS = "ticketItemTaxWithoutModifiers";
	public final static String TICKET_ITEM_TOTAL_PRICE = "ticketItemTotalPrice";
	public final static String TICKET_ITEM_TOTAL_PRICE_WITHOUT_MODIFIERS = "ticketItemTotalPriceWithoutModifiers";
	public final static String TICKET_ITEM_BEVERAGE = "ticketItemBeverage";
	public final static String TICKET_ITEM_INVENTORY_HANDLED = "ticketItemInventoryHandled";
	public final static String TICKET_ITEM_TREAT_AS_SEAT = "ticketItemTreatAsSeat";
	public final static String TICKET_ITEM_SEAT_NUMBER = "ticketItemSeatNumber";
	public final static String TICKET_ITEM_FRACTIONAL_UNIT = "ticketItemFractionalUnit";
	public final static String TICKET_ITEM_HAS_MODIIERS = "ticketItemHasModiiers";
	public final static String TICKET_ITEM_STATUS = "ticketItemStatus";
	public final static String TICKET_ITEM_STOCK_ADJUSTED = "ticketItemStockAdjusted";
	public final static String TICKET_IS_PRINTED_TO_KITCHEN = "isPrintedToKitchen";
	public final static String TICKET_UNIT_PRICE = "unitPrice";
	public final static String TICKET_ITEM_MODIFIER_LIST = "ticketItemModifierList";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TICKET_ITEM_ID, unique = true, nullable = false)
	private Integer ticketItemId;

	@Column(name = Ticket.TICKET_ID, insertable = false, updatable = false)
	private Integer ticketId;

	@Column(name = TICKET_ITEM_COUNT)
	private Integer ticketItemCount;

	@Column(name = TICKET_ITEM_QUANTITY)
	private double ticketItemQuantity;

	@Column(name = TICKET_ITEM_NAME)
	private String ticketItemName;

	@Column(name = TICKET_ITEM_PRICE)
	private double ticketItemPrice;

	@Column(name = TICKET_ITEM_GROUP_NAME)
	private String ticketItemGroupName;

	@Column(name = TICKET_ITEM_CATEGORY_NAME)
	private String ticketItemCategoryName;

	@Column(name = TICKET_ITEM_TAX_RATE)
	private double ticketItemTaxRate;

	@Column(name = TICKET_ITEM_SUB_TOTAL)
	private Double ticketItemSubTotal;

	@Column(name = TICKET_ITEM_SUB_TOTAL_WITHOUT_MODIFIERS)
	private double ticketItemSubTotalWithoutModifiers;

	@Column(name = TICKET_ITEM_DISCOUNT)
	private double ticketItemDiscountAmount;

	@Column(name = TICKET_ITEM_TAX)
	private double ticketItemTax;

	@Column(name = TICKET_ITEM_TAX_WITHOUT_MODIFIERS)
	private double ticketItemTaxWithoutModifiers;

	@Column(name = TICKET_ITEM_TOTAL_PRICE)
	private double ticketItemTotalPrice;

	@Column(name = TICKET_ITEM_TOTAL_PRICE_WITHOUT_MODIFIERS)
	private double ticketItemTotalPriceWithoutModifiers;

	@Column(name = TICKET_ITEM_BEVERAGE)
	private Boolean ticketItemBeverage;

	@Column(name = TICKET_ITEM_INVENTORY_HANDLED)
	private Boolean ticketItemInventoryHandled;

	@Column(name = TICKET_ITEM_TREAT_AS_SEAT)
	private Boolean ticketItemTreatAsSeat;

	@Column(name = TICKET_ITEM_SEAT_NUMBER)
	private Integer ticketItemSeatNumber;

	@Column(name = TICKET_ITEM_FRACTIONAL_UNIT)
	private Boolean ticketItemFractionalUnit;

	@Column(name = TICKET_ITEM_HAS_MODIIERS)
	private Boolean ticketItemHasModifiers;

	@Column(name = TICKET_ITEM_STATUS)
	private Boolean ticketItemStatus;

	@Column(name = TICKET_ITEM_STOCK_ADJUSTED)
	private Boolean ticketItemStockAdjusted;

	@Column(name = TICKET_IS_PRINTED_TO_KITCHEN)
	private Boolean isPrintedToKitchen;

	@Column(name = TICKET_UNIT_PRICE)
	private double unitPrice;

	@Column(name = TICKET_ITEM_UNIT_NAME)
	private String ticketItemUnitName;

	@Transient
	private MenuItem menuItem;

	@Transient
	private int tableRowNum;

	@Transient
	private boolean priceIncludesTax;

	@Transient
	private int hashCode = Integer.MIN_VALUE;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = TicketItemModifier.TICKET_ITEM_MODIFIER_ID, referencedColumnName = TicketItemModifier.TICKET_ITEM_MODIFIER_ID)
	private TicketItemModifier ticketItemModifier;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = TICKET_ITEM_MODIFIER_LIST, joinColumns = @JoinColumn(name = TicketItem.TICKET_ITEM_ID), inverseJoinColumns = @JoinColumn(name = TicketItemModifier.TICKET_ITEM_MODIFIER_ID))
	private List<TicketItemModifier> ticketItemModifierList;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Ticket.TICKET_ID, referencedColumnName = Ticket.TICKET_ID)
	private Ticket ticket;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = TICKET_ITEM_ID)
	private List<TicketItemDiscount> ticketItemDiscount;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = PrinterGroup.PRINTER_GROUP_ID, referencedColumnName = PrinterGroup.PRINTER_GROUP_ID)
	private PrinterGroup printerGroup;

	public TicketItem() {
	}

	public TicketItem(Integer id) {
		this.setTicketItemId(id);
	}

	public TicketItem(Integer id, Ticket ticket) {
		this.setTicketItemId(id);
		this.setTicket(ticket);
	}

	/**
	 * @return the ticketItemId
	 */
	public Integer getTicketItemId() {
		return ticketItemId;
	}

	/**
	 * @param ticketItemId
	 *            the ticketItemId to set
	 */
	public void setTicketItemId(Integer ticketItemId) {
		this.ticketItemId = ticketItemId;
	}

	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId
	 *            the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the ticketItemCount
	 */
	public Integer getTicketItemCount() {
		return ticketItemCount;
	}

	/**
	 * @param ticketItemCount
	 *            the ticketItemCount to set
	 */
	public void setTicketItemCount(Integer ticketItemCount) {
		this.ticketItemCount = ticketItemCount;
	}

	/**
	 * @return the ticketItemQuantity
	 */
	public double getTicketItemQuantity() {
		return ticketItemQuantity;
	}

	/**
	 * @param ticketItemQuantity
	 *            the ticketItemQuantity to set
	 */
	public void setTicketItemQuantity(double ticketItemQuantity) {
		this.ticketItemQuantity = ticketItemQuantity;
	}

	/**
	 * @return the ticketItemName
	 */
	public String getTicketItemName() {
		return ticketItemName;
	}

	/**
	 * @param ticketItemName
	 *            the ticketItemName to set
	 */
	public void setTicketItemName(String ticketItemName) {
		this.ticketItemName = ticketItemName;
	}

	/**
	 * @return the ticketItemPrice
	 */
	public double getTicketItemPrice() {
		return ticketItemPrice;
	}

	/**
	 * @param ticketItemPrice
	 *            the ticketItemPrice to set
	 */
	public void setTicketItemPrice(double ticketItemPrice) {
		this.ticketItemPrice = ticketItemPrice;
	}

	/**
	 * @return the ticketItemGroupName
	 */
	public String getTicketItemGroupName() {
		return ticketItemGroupName;
	}

	/**
	 * @param ticketItemGroupName
	 *            the ticketItemGroupName to set
	 */
	public void setTicketItemGroupName(String ticketItemGroupName) {
		this.ticketItemGroupName = ticketItemGroupName;
	}

	/**
	 * @return the ticketItemCategoryName
	 */
	public String getTicketItemCategoryName() {
		return ticketItemCategoryName;
	}

	/**
	 * @param ticketItemCategoryName
	 *            the ticketItemCategoryName to set
	 */
	public void setTicketItemCategoryName(String ticketItemCategoryName) {
		this.ticketItemCategoryName = ticketItemCategoryName;
	}

	/**
	 * @return the ticketItemTaxRate
	 */
	public double getTicketItemTaxRate() {
		return ticketItemTaxRate;
	}

	/**
	 * @param ticketItemTaxRate
	 *            the ticketItemTaxRate to set
	 */
	public void setTicketItemTaxRate(double ticketItemTaxRate) {
		this.ticketItemTaxRate = ticketItemTaxRate;
	}

	/**
	 * @return the ticketItemSubTotal
	 */
	public Double getTicketItemSubTotal() {
		return ticketItemSubTotal == null ? Double.valueOf(0) : ticketItemSubTotal;
	}

	/**
	 * @param ticketItemSubTotal
	 *            the ticketItemSubTotal to set
	 */
	public void setTicketItemSubTotal(Double ticketItemSubTotal) {
		this.ticketItemSubTotal = ticketItemSubTotal;
	}

	/**
	 * @return the ticketItemSubTotalWithoutModifiers
	 */
	public double getTicketItemSubTotalWithoutModifiers() {
		return ticketItemSubTotalWithoutModifiers;
	}

	/**
	 * @param ticketItemSubTotalWithoutModifiers
	 *            the ticketItemSubTotalWithoutModifiers to set
	 */
	public void setTicketItemSubTotalWithoutModifiers(double ticketItemSubTotalWithoutModifiers) {
		this.ticketItemSubTotalWithoutModifiers = ticketItemSubTotalWithoutModifiers;
	}

	/**
	 * @return the ticketItemDiscount
	 */
	public double getTicketItemDiscount() {
		return ticketItemDiscountAmount;
	}

	/**
	 * @param ticketItemDiscount
	 *            the ticketItemDiscount to set
	 */
	public void setTicketItemDiscount(double ticketItemDiscount) {
		this.ticketItemDiscountAmount = ticketItemDiscount;
	}

	/**
	 * @return the ticketItemTax
	 */
	public double getTicketItemTax() {
		return ticketItemTax;
	}

	/**
	 * @param ticketItemTax
	 *            the ticketItemTax to set
	 */
	public void setTicketItemTax(double ticketItemTax) {
		this.ticketItemTax = ticketItemTax;
	}

	/**
	 * @return the ticketItemTaxWithoutModifiers
	 */
	public double getTicketItemTaxWithoutModifiers() {
		return ticketItemTaxWithoutModifiers;
	}

	/**
	 * @param ticketItemTaxWithoutModifiers
	 *            the ticketItemTaxWithoutModifiers to set
	 */
	public void setTicketItemTaxWithoutModifiers(double ticketItemTaxWithoutModifiers) {
		this.ticketItemTaxWithoutModifiers = ticketItemTaxWithoutModifiers;
	}

	/**
	 * @return the ticketItemTotalPrice
	 */
	public double getTicketItemTotalPrice() {
		return ticketItemTotalPrice;
	}

	/**
	 * @param ticketItemTotalPrice
	 *            the ticketItemTotalPrice to set
	 */
	public void setTicketItemTotalPrice(double ticketItemTotalPrice) {
		this.ticketItemTotalPrice = ticketItemTotalPrice;
	}

	/**
	 * @return the ticketItemTotalPriceWithoutModifiers
	 */
	public double getTicketItemTotalPriceWithoutModifiers() {
		return ticketItemTotalPriceWithoutModifiers;
	}

	/**
	 * @param ticketItemTotalPriceWithoutModifiers
	 *            the ticketItemTotalPriceWithoutModifiers to set
	 */
	public void setTicketItemTotalPriceWithoutModifiers(double ticketItemTotalPriceWithoutModifiers) {
		this.ticketItemTotalPriceWithoutModifiers = ticketItemTotalPriceWithoutModifiers;
	}

	/**
	 * @return the ticketItemBeverage
	 */
	public Boolean getTicketItemBeverage() {
		return ticketItemBeverage;
	}

	/**
	 * @param ticketItemBeverage
	 *            the ticketItemBeverage to set
	 */
	public void setTicketItemBeverage(Boolean ticketItemBeverage) {
		this.ticketItemBeverage = ticketItemBeverage;
	}

	/**
	 * @return the ticketItemInventoryHandled
	 */
	public Boolean getTicketItemInventoryHandled() {
		return ticketItemInventoryHandled == null ? Boolean.FALSE : ticketItemInventoryHandled;
	}

	/**
	 * @param ticketItemInventoryHandled
	 *            the ticketItemInventoryHandled to set
	 */
	public void setTicketItemInventoryHandled(Boolean ticketItemInventoryHandled) {
		this.ticketItemInventoryHandled = ticketItemInventoryHandled;
	}

	/**
	 * @return the ticketItemTreatAsSeat
	 */
	public Boolean getTicketItemTreatAsSeat() {
		return ticketItemTreatAsSeat == null ? Boolean.FALSE : ticketItemTreatAsSeat;
	}

	/**
	 * @param ticketItemTreatAsSeat
	 *            the ticketItemTreatAsSeat to set
	 */
	public void setTicketItemTreatAsSeat(Boolean ticketItemTreatAsSeat) {
		this.ticketItemTreatAsSeat = ticketItemTreatAsSeat;
	}

	/**
	 * @return the ticketItemSeatNumber
	 */
	public Integer getTicketItemSeatNumber() {
		return ticketItemSeatNumber;
	}

	/**
	 * @param ticketItemSeatNumber
	 *            the ticketItemSeatNumber to set
	 */
	public void setTicketItemSeatNumber(Integer ticketItemSeatNumber) {
		this.ticketItemSeatNumber = ticketItemSeatNumber;
	}

	/**
	 * @return the ticketItemFractionalUnit
	 */
	public Boolean getTicketItemFractionalUnit() {
		return ticketItemFractionalUnit;
	}

	/**
	 * @param ticketItemFractionalUnit
	 *            the ticketItemFractionalUnit to set
	 */
	public void setTicketItemFractionalUnit(Boolean ticketItemFractionalUnit) {
		this.ticketItemFractionalUnit = ticketItemFractionalUnit;
	}

	/**
	 * @return the ticketItemHasModifiers
	 */
	public Boolean getTicketItemHasModifiers() {
		return ticketItemHasModifiers;
	}

	/**
	 * @param ticketItemHasModifiers
	 *            the ticketItemHasModifiers to set
	 */
	public void setTicketItemHasModifiers(Boolean ticketItemHasModifiers) {
		this.ticketItemHasModifiers = ticketItemHasModifiers;
	}

	/**
	 * @return the ticketItemStatus
	 */
	public Boolean getTicketItemStatus() {
		return ticketItemStatus;
	}

	/**
	 * @param ticketItemStatus
	 *            the ticketItemStatus to set
	 */
	public void setTicketItemStatus(Boolean ticketItemStatus) {
		this.ticketItemStatus = ticketItemStatus;
	}

	/**
	 * @return the ticketItemStockAdjusted
	 */
	public Boolean getTicketItemStockAdjusted() {
		return ticketItemStockAdjusted;
	}

	/**
	 * @param ticketItemStockAdjusted
	 *            the ticketItemStockAdjusted to set
	 */
	public void setTicketItemStockAdjusted(Boolean ticketItemStockAdjusted) {
		this.ticketItemStockAdjusted = ticketItemStockAdjusted;
	}

	/**
	 * @return the ticketItemModifier
	 */
	public TicketItemModifier getTicketItemModifier() {
		return ticketItemModifier;
	}

	/**
	 * @param ticketItemModifier
	 *            the ticketItemModifier to set
	 */
	public void setTicketItemModifier(TicketItemModifier ticketItemModifier) {
		this.ticketItemModifier = ticketItemModifier;
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the ticketItemDiscountList
	 */
	public List<TicketItemDiscount> getTicketItemDiscountList() {
		if (ticketItemDiscount == null) {
			setTicketItemDiscountList(new ArrayList<TicketItemDiscount>());
		}
		return ticketItemDiscount;
	}

	/**
	 * @param ticketItemDiscountList
	 *            the ticketItemDiscountList to set
	 */
	public void setTicketItemDiscountList(List<TicketItemDiscount> ticketItemDiscountList) {
		this.ticketItemDiscount = ticketItemDiscountList;
	}

	/**
	 * @return the printerGroup
	 */
	public PrinterGroup getPrinterGroup() {
		return printerGroup;
	}

	public String getTicketItemUnitName() {
		return ticketItemUnitName;
	}

	public void setTicketItemUnitName(String ticketItemUnitName) {
		this.ticketItemUnitName = ticketItemUnitName;
	}

	/**
	 * @param printerGroup
	 *            the printerGroup to set
	 */
	public void setPrinterGroup(PrinterGroup printerGroup) {
		this.printerGroup = printerGroup;
	}

	public void setPrintedToKitchen(Boolean isPrintedToKitchen) {
		this.isPrintedToKitchen = isPrintedToKitchen;
	}

	public Boolean getPrintedToKitchen() {
		return isPrintedToKitchen == null ? Boolean.FALSE : isPrintedToKitchen;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<TicketItemModifier> getTicketItemModifierList() {
		return ticketItemModifierList;
	}

	public void setTicketItemModifierList(List<TicketItemModifier> ticketItemModifierList) {
		this.ticketItemModifierList = ticketItemModifierList;
	}

}
