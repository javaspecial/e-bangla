package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYOUT_RECEPIENT")
public class PayoutRecepient {
	public final static String PAYOUT_RECEPIENT_ID = "payout_recepient_id";
	public final static String PAYOUT_RECEPIENT_NAME = "payout_recepient_name";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PAYOUT_RECEPIENT_ID, unique = true, nullable = false)
	private Integer payoutRecepientId;

	@Column(name = PAYOUT_RECEPIENT_NAME)
	private String payoutRecepientName;

	public PayoutRecepient() {
	}

	public Integer getPayoutRecepientId() {
		return payoutRecepientId;
	}

	public void setPayoutRecepientId(Integer payoutRecepientId) {
		this.payoutRecepientId = payoutRecepientId;
	}

	public String getPayoutRecepientName() {
		return payoutRecepientName;
	}

	public void setPayoutRecepientName(String payoutRecepientName) {
		this.payoutRecepientName = payoutRecepientName;
	}
}
