package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DRAWER_PULL_REPORT_VOID_TICKETS")
public class DrawerPullVoidTicketEntry extends DrawerPullReport {
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String reason = "reason";
	private String hast = "hast";
	private String quantity = "quantity";
	private Double amount;

	public DrawerPullVoidTicketEntry() {
		super();
	}

	public DrawerPullVoidTicketEntry(Integer id) {
		super(id);
	}

	public Integer getCode() {
		return code == null ? Integer.valueOf(0) : code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getHast() {
		return hast;
	}

	public void setHast(String hast) {
		this.hast = hast;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount == null ? Double.valueOf(0) : amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}