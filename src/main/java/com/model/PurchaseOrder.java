package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE_ORDER")
public class PurchaseOrder {
	public final static String PURCHASE_ORDER_ID = "purchase_order_id";
	public final static String PURCHASE_ORDER_NAME = "purchase_order_name";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PURCHASE_ORDER_ID, unique = true, nullable = false)
	private Integer purchaseOrderId;

	@Column(name = PURCHASE_ORDER_NAME)
	private String purchaseOrderName;

	public PurchaseOrder() {
	}

	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getPurchaseOrderName() {
		return purchaseOrderName;
	}

	public void setPurchaseOrderName(String purchaseOrderName) {
		this.purchaseOrderName = purchaseOrderName;
	}
}
