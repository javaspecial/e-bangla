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

import com.interface_.ITicketItem;

/**
 * @author toxic-pc
 *
 */
@Entity()
@Table(name = "TICKET_ITEM_DISCOUNT")
public class TicketItemDiscount {
	public static final String TICKET_ITEM_DISCOUNT_ID = "ticket_item_discount_id";
	public static final String TICKET_ITEM_DISCOUNT_NAME = "ticket_item_discount_name";
	public static final String TICKET_ITEM_DISCOUNT_TYPE = "ticket_item_discount_type";
	public static final String TICKET_ITEM_DISCOUNT_AUTO_APPLY = "ticket_item_discount_auto_apply";
	public static final String TICKET_ITEM_DISCOUNT_MINIMUM_QUANTITY = "ticket_item_discount_minimum_quantity";
	public static final String TICKET_ITEM_DISCOUNT_VALUE = "ticket_item_discount_value";
	public static final String TICKET_ITEM_DISCOUNT_AMOUNT = "ticket_item_discount_amount";
	public static final String TICKET_ITEM_SUBTOTATL_AMOUNT_DISPLAY = "subTotalAmountDisplay()";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TICKET_ITEM_DISCOUNT_ID, unique = true, nullable = false)
	private Integer ticketItemDiscountId;

	@Column(name = TicketItem.TICKET_ITEM_ID, insertable = false, updatable = false)
	private Integer ticketItemId;

	@Column(name = TICKET_ITEM_DISCOUNT_NAME)
	private String ticketItemDiscountName;

	@Column(name = TICKET_ITEM_DISCOUNT_TYPE)
	private Integer ticketItemDiscountType;

	@Column(name = TICKET_ITEM_DISCOUNT_AUTO_APPLY)
	private Boolean ticketItemDiscountAutoApply;

	@Column(name = TICKET_ITEM_DISCOUNT_MINIMUM_QUANTITY)
	private Integer ticketItemDiscountMinimumQuantity;

	@Column(name = TICKET_ITEM_DISCOUNT_VALUE)
	private double ticketItemDiscountValue;

	@Column(name = TICKET_ITEM_DISCOUNT_AMOUNT)
	private double ticketItemDiscountAmount;

	@Column(name = TICKET_ITEM_SUBTOTATL_AMOUNT_DISPLAY)
	private double subTotalAmountDisplay;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = TicketItem.TICKET_ITEM_ID, referencedColumnName = TicketItem.TICKET_ITEM_ID)
	private TicketItem ticketItem;

	public TicketItemDiscount() {
	}

	public Integer getTicketItemDiscountId() {
		return ticketItemDiscountId;
	}

	public void setTicketItemDiscountId(Integer ticketItemDiscountId) {
		this.ticketItemDiscountId = ticketItemDiscountId;
	}

	public Integer getTicketItemId() {
		return ticketItemId;
	}

	public void setTicketItemId(Integer ticketItemId) {
		this.ticketItemId = ticketItemId;
	}

	public String getTicketItemDiscountName() {
		return ticketItemDiscountName;
	}

	public void setTicketItemDiscountName(String ticketItemDiscountName) {
		this.ticketItemDiscountName = ticketItemDiscountName;
	}

	public Integer getTicketItemDiscountType() {
		return ticketItemDiscountType;
	}

	public void setTicketItemDiscountType(Integer ticketItemDiscountType) {
		this.ticketItemDiscountType = ticketItemDiscountType;
	}

	public Boolean getTicketItemDiscountAutoApply() {
		return ticketItemDiscountAutoApply;
	}

	public void setTicketItemDiscountAutoApply(Boolean ticketItemDiscountAutoApply) {
		this.ticketItemDiscountAutoApply = ticketItemDiscountAutoApply;
	}

	public Integer getTicketItemDiscountMinimumQuantity() {
		return ticketItemDiscountMinimumQuantity;
	}

	public void setTicketItemDiscountMinimumQuantity(Integer ticketItemDiscountMinimumQuantity) {
		this.ticketItemDiscountMinimumQuantity = ticketItemDiscountMinimumQuantity;
	}

	public double getTicketItemDiscountValue() {
		return ticketItemDiscountValue;
	}

	public void setTicketItemDiscountValue(double ticketItemDiscountValue) {
		this.ticketItemDiscountValue = ticketItemDiscountValue;
	}

	public double getTicketItemDiscountAmount() {
		return ticketItemDiscountAmount;
	}

	public void setTicketItemDiscountAmount(double ticketItemDiscountAmount) {
		this.ticketItemDiscountAmount = ticketItemDiscountAmount;
	}

	public TicketItem getTicketItem() {
		return ticketItem;
	}

	public void setTicketItem(TicketItem ticketItem) {
		this.ticketItem = ticketItem;
	}

	public double getSubTotalAmount() {
		return subTotalAmountDisplay;
	}

	public void setSubTotalAmountDisplay(double subTotalAmountDisplay) {
		this.subTotalAmountDisplay = subTotalAmountDisplay;
	}

}
