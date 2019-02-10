package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CASH_DROP_TRANSACTION")
public class CashDropTransaction extends PosTransaction {
	private static final long serialVersionUID = 1L;

	public CashDropTransaction() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public CashDropTransaction(Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CashDropTransaction(Integer id, String transactionType, String paymentType) {

		super(id, transactionType, paymentType);
	}

}