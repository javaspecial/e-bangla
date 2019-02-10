package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

import com.enum_.TransactionType;

@Entity
@DiscriminatorValue(value = "PAY_OUT_TRANSACTION")
public class PayOutTransaction extends PosTransaction {
	private static final long serialVersionUID = 1L;

	public PayOutTransaction() {
		initialize();
	}

	public PayOutTransaction(Integer id) {
		super(id);
	}

	public PayOutTransaction(Integer id, String transactionType, String paymentType) {

		super(id, transactionType, paymentType);
	}

	@Override
	public String getTransactionType() {
		String type = super.getTransactionType();

		if (StringUtils.isEmpty(type)) {
			return TransactionType.DEBIT.name();
		}

		return type;
	}

}