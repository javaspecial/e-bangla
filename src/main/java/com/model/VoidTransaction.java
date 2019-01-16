package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

import com.enum_.TransactionType;

@Entity
@DiscriminatorValue(value = "VOID_TRANS")
public class VoidTransaction extends PosTransaction {
	private int hashCode = Integer.MIN_VALUE;

	public VoidTransaction() {
		initialize();
	}

	public VoidTransaction(Integer id) {
		super(id);
	}

	public VoidTransaction(Integer id, String transactionType, String paymentType) {
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof VoidTransaction))
			return false;
		else {
			VoidTransaction voidTransaction = (VoidTransaction) obj;
			if (null == this.getId() || null == voidTransaction.getId())
				return false;
			else
				return (this.getId().equals(voidTransaction.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode())
			return 1;
		else if (obj.hashCode() < hashCode())
			return -1;
		else
			return 0;
	}

	public String toString() {
		return super.toString();
	}
}
