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

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "TICKET_DISCOUNT")
public class TicketDiscount {
	public static final String TICKET_DISCOUNT_ID = "ticket_discount_id";
	public static final String TICKET_DISCOUNT_NAME = "ticket_discount_name";
	public static final String TICKET_DISCOUNT_TYPE = "ticket_discount_type";
	public static final String TICKET_DISCOUNT_AUTO_APPLY = "ticket_discount_auto_apply";
	public static final String TICKET_DISCOUNT_MINIMUM_AMOUNT = "ticket_discount_minimum_amount";
	public static final String TICKET_DISCOUNT_VALUE = "ticket_discount_value";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TICKET_DISCOUNT_ID, unique = true, nullable = false)
	private Integer ticketDiscountId;

	@Column(name = Ticket.TICKET_ID)
	private Integer ticketId;

	@Column(name = TICKET_DISCOUNT_NAME)
	private String ticketDiscountName;

	@Column(name = TICKET_DISCOUNT_TYPE)
	private Integer ticketDiscountType;

	@Column(name = TICKET_DISCOUNT_AUTO_APPLY)
	private Boolean ticketDiscountAutoApply;

	@Column(name = TICKET_DISCOUNT_MINIMUM_AMOUNT)
	private double ticketDiscountMinimumAmount;

	@Column(name = TICKET_DISCOUNT_VALUE)
	private double ticketDiscountValue;

	public TicketDiscount() {
	}

	public Integer getTicketDiscountId() {
		return ticketDiscountId;
	}

	public void setTicketDiscountId(Integer ticketDiscountId) {
		this.ticketDiscountId = ticketDiscountId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDiscountName() {
		return ticketDiscountName;
	}

	public void setTicketDiscountName(String ticketDiscountName) {
		this.ticketDiscountName = ticketDiscountName;
	}

	public Integer getTicketDiscountType() {
		return ticketDiscountType;
	}

	public void setTicketDiscountType(Integer ticketDiscountType) {
		this.ticketDiscountType = ticketDiscountType;
	}

	public Boolean getTicketDiscountAutoApply() {
		return ticketDiscountAutoApply;
	}

	public void setTicketDiscountAutoApply(Boolean ticketDiscountAutoApply) {
		this.ticketDiscountAutoApply = ticketDiscountAutoApply;
	}

	public double getTicketDiscountMinimumAmount() {
		return ticketDiscountMinimumAmount;
	}

	public void setTicketDiscountMinimumAmount(double ticketDiscountMinimumAmount) {
		this.ticketDiscountMinimumAmount = ticketDiscountMinimumAmount;
	}

	public double getTicketDiscountValue() {
		return ticketDiscountValue;
	}

	public void setTicketDiscountValue(double ticketDiscountValue) {
		this.ticketDiscountValue = ticketDiscountValue;
	}
}
