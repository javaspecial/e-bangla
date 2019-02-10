package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CASH")
public class CashTransaction extends PosTransaction {
	private int hashCode = Integer.MIN_VALUE;

	public CashTransaction() {
		initialize();
	}

	public CashTransaction(Integer id) {
		super(id);
	}

	public CashTransaction(Integer id, String transactionType, String paymentType) {
		super(id, transactionType, paymentType);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof CashTransaction))
			return false;
		else {
			CashTransaction cashTransaction = (CashTransaction) obj;
			if (null == this.getId() || null == cashTransaction.getId())
				return false;
			else
				return (this.getId().equals(cashTransaction.getId()));
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
