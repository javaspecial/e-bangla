package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "REFUND")
public class RefundTransaction extends PosTransaction {
	private int hashCode = Integer.MIN_VALUE;

	public RefundTransaction() {
		initialize();
	}

	public RefundTransaction(Integer id) {
		super(id);
	}

	public RefundTransaction(Integer id, String transactionType, String paymentType) {
		super(id, transactionType, paymentType);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof RefundTransaction))
			return false;
		else {
			RefundTransaction refundTransaction = (RefundTransaction) obj;
			if (null == this.getId() || null == refundTransaction.getId())
				return false;
			else
				return (this.getId().equals(refundTransaction.getId()));
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
