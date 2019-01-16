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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.interface_.ITicketItem;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "TICKET_ITEM_MODIFIER")
public class TicketItemModifier {

	public final static String TICKET_ITEM_MODIFIER_ID = "ticket_item_modifier_id";
	public static final String TICKET_ITEM_MODIFIER_GROUP_ID = "ticket_item_modifier_group_id";
	public static final String TICKET_ITEM_MODIFIER_COUNT = "ticket_item_modifier_count";
	public static final String TICKET_ITEM_MODIFIER_NAME = "ticket_item_modifier_name";
	public static final String TICKET_ITEM_MODIFIER_PRICE = "ticket_item_modifier_price";
	public static final String TICKET_ITEM_MODIFIER_TAX_RATE = "ticket_item_modifier_tax_rate";
	public static final String TICKET_ITEM_MODIFIER_TYPE = "ticket_item_modifier_type";
	public static final String TICKET_ITEM_MODIFIER_SUBTOTAL_PRICE = "ticket_item_modifier_subtotal_price";
	public static final String TICKET_ITEM_MODIFIER_TOTAL_PRICE = "ticket_item_modifier_total_price";
	public static final String TICKET_ITEM_MODIFIER_TAX_AMOUNT = "ticket_item_modifier_tax_amount";
	public static final String TICKET_ITEM_MODIFIER_INFO_ONLY = "ticket_item_modifier_info_only";
	public static final String TICKET_ITEM_MODIFIER_SECTION_NAME = "ticket_item_modifier_section_name";
	public static final String TICKET_ITEM_MODIFIER_MULTIPLIER_NAME = "ticket_item_modifier_multiplier_name";
	public static final String TICKET_ITEM_MODIFIER_SECTION_WISE_PRICING = "ticket_item_modifier_section_wise_pricing";
	public static final String TICKET_ITEM_MODIFIER_STATUS = "ticket_item_modifier_status";
	public static final String TICKET_ITEM_PRINTED_TO_KITCHEN = "printedToKitchen";
	public static final String TICKET_ITEM_SHOULD_PRINT_TO_KITCHEN = "shouldPrintToKitchen";
	public static final String TICKET_ITEM_UNIT_PRICE = "unitPrice";
	private static final Integer NORMAL_MODIFIER = 1;

	private boolean priceIncludesTax;
	private int tableRowNum;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TICKET_ITEM_MODIFIER_ID, unique = true, nullable = false)
	private Integer ticketItemModifierId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = TicketItem.TICKET_ITEM_ID, referencedColumnName = TicketItem.TICKET_ITEM_ID)
	private TicketItem ticketItem;

	@Column(name = TICKET_ITEM_MODIFIER_GROUP_ID)
	private String ticketItemModifierGroupId;

	@Column(name = TICKET_ITEM_MODIFIER_COUNT)
	private Integer ticketItemModifierCount;

	@Column(name = TICKET_ITEM_MODIFIER_NAME)
	private String ticketItemModifierName;

	@Column(name = TICKET_ITEM_MODIFIER_PRICE)
	private double ticketItemModifierPrice;

	@Column(name = TICKET_ITEM_MODIFIER_SUBTOTAL_PRICE)
	private double ticketItemModifierSubtotalPrice;

	@Column(name = TICKET_ITEM_MODIFIER_TYPE)
	private Integer ticketItemModifierType;

	@Column(name = TICKET_ITEM_MODIFIER_TAX_AMOUNT)
	private double ticketItemModifierTaxAmount;

	@Column(name = TICKET_ITEM_MODIFIER_TOTAL_PRICE)
	private double ticketItemModifierTotalPrice;

	@Column(name = TICKET_ITEM_MODIFIER_TAX_RATE)
	private double ticketItemModifierTaxRate;

	@Column(name = TICKET_ITEM_MODIFIER_INFO_ONLY)
	private boolean ticketItemModifierInfoOnly;

	@Column(name = TICKET_ITEM_MODIFIER_SECTION_NAME)
	private String ticketItemModifierSectionName;

	@Column(name = TICKET_ITEM_MODIFIER_MULTIPLIER_NAME)
	private String ticketItemModifierMultiplierName;

	@Column(name = TICKET_ITEM_MODIFIER_SECTION_WISE_PRICING)
	private Boolean ticketItemModifierSectionWisePricing;

	@Column(name = TICKET_ITEM_MODIFIER_STATUS)
	private String ticketItemModifierStatus;

	@Column(name = TICKET_ITEM_PRINTED_TO_KITCHEN)
	private boolean printedToKitchen;

	@Column(name = TICKET_ITEM_SHOULD_PRINT_TO_KITCHEN)
	private boolean shouldPrintToKitchen;

	@Column(name = TICKET_ITEM_UNIT_PRICE)
	private double unitPrice;

	@ManyToMany(mappedBy = TicketItem.TICKET_ITEM_MODIFIER_LIST)
	private List<TicketItem> ticketItems;

	public TicketItemModifier() {
	}

	public Integer getTicketItemModifierId() {
		return ticketItemModifierId;
	}

	public void setTicketItemModifierId(Integer ticketItemModifierId) {
		this.ticketItemModifierId = ticketItemModifierId;
	}

	public TicketItem getTicketItem() {
		return ticketItem;
	}

	public void setTicketItem(TicketItem ticketItem) {
		this.ticketItem = ticketItem;
	}

	public String getTicketItemModifierGroupId() {
		return ticketItemModifierGroupId;
	}

	public void setTicketItemModifierGroupId(String ticketItemModifierGroupId) {
		this.ticketItemModifierGroupId = ticketItemModifierGroupId;
	}

	public Integer getTicketItemModifierCount() {
		return ticketItemModifierCount;
	}

	public void setTicketItemModifierCount(Integer ticketItemModifierCount) {
		this.ticketItemModifierCount = ticketItemModifierCount;
	}

	public String getTicketItemModifierName() {
		return ticketItemModifierName;
	}

	public void setTicketItemModifierName(String ticketItemModifierName) {
		this.ticketItemModifierName = ticketItemModifierName;
	}

	public double getTicketItemModifierPrice() {
		return ticketItemModifierPrice;
	}

	public void setTicketItemModifierPrice(double ticketItemModifierPrice) {
		this.ticketItemModifierPrice = ticketItemModifierPrice;
	}

	public double getTicketItemModifierSubtotalPrice() {
		return ticketItemModifierSubtotalPrice;
	}

	public void setTicketItemModifierSubtotalPrice(double ticketItemModifierSubtotalPrice) {
		this.ticketItemModifierSubtotalPrice = ticketItemModifierSubtotalPrice;
	}

	public Integer getTicketItemModifierType() {
		return ticketItemModifierType;
	}

	public int getTableRowNum() {
		return tableRowNum;
	}

	public void setTableRowNum(int tableRowNum) {
		this.tableRowNum = tableRowNum;
	}

	public List<TicketItem> getTicketItems() {
		return ticketItems;
	}

	public void setTicketItems(List<TicketItem> ticketItems) {
		this.ticketItems = ticketItems;
	}

	public void setTicketItemModifierType(Integer ticketItemModifierType) {
		this.ticketItemModifierType = ticketItemModifierType;
	}

	public double getTicketItemModifierTaxAmount() {
		return ticketItemModifierTaxAmount;
	}

	public void setTicketItemModifierTaxAmount(double ticketItemModifierTaxAmount) {
		this.ticketItemModifierTaxAmount = ticketItemModifierTaxAmount;
	}

	public double getTicketItemModifierTotalPrice() {
		return ticketItemModifierTotalPrice;
	}

	public void setTicketItemModifierTotalPrice(double ticketItemModifierTotalPrice) {
		this.ticketItemModifierTotalPrice = ticketItemModifierTotalPrice;
	}

	public double getTicketItemModifierTaxRate() {
		return ticketItemModifierTaxRate;
	}

	public void setTicketItemModifierTaxRate(double ticketItemModifierTaxRate) {
		this.ticketItemModifierTaxRate = ticketItemModifierTaxRate;
	}

	public boolean isTicketItemModifierInfoOnly() {
		return ticketItemModifierInfoOnly;
	}

	public void setTicketItemModifierInfoOnly(boolean ticketItemModifierInfoOnly) {
		this.ticketItemModifierInfoOnly = ticketItemModifierInfoOnly;
	}

	public String getTicketItemModifierSectionName() {
		return ticketItemModifierSectionName;
	}

	public void setTicketItemModifierSectionName(String ticketItemModifierSectionName) {
		this.ticketItemModifierSectionName = ticketItemModifierSectionName;
	}

	public String getTicketItemModifierMultiplierName() {
		return ticketItemModifierMultiplierName;
	}

	public void setTicketItemModifierMultiplierName(String ticketItemModifierMultiplierName) {
		this.ticketItemModifierMultiplierName = ticketItemModifierMultiplierName;
	}

	public Boolean getTicketItemModifierSectionWisePricing() {
		return ticketItemModifierSectionWisePricing;
	}

	public void setTicketItemModifierSectionWisePricing(Boolean ticketItemModifierSectionWisePricing) {
		this.ticketItemModifierSectionWisePricing = ticketItemModifierSectionWisePricing;
	}

	public String getTicketItemModifierStatus() {
		return ticketItemModifierStatus;
	}

	public void setTicketItemModifierStatus(String ticketItemModifierStatus) {
		this.ticketItemModifierStatus = ticketItemModifierStatus;
	}

	public boolean getPrintedToKitchen() {
		return printedToKitchen;
	}

	public void setPrintedToKitchen(boolean printedToKitchen) {
		this.printedToKitchen = printedToKitchen;
	}

	public boolean isShouldPrintToKitchen() {
		return shouldPrintToKitchen;
	}

	public void setShouldPrintToKitchen(boolean shouldPrintToKitchen) {
		this.shouldPrintToKitchen = shouldPrintToKitchen;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
