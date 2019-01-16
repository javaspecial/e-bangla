package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYOUT_REASON")
public class PayoutReason {
	public static final String PAYOUT_REASON_ID = "payout_reason_id";
	public static final String PAYOUT_REASON = "payout_reason";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PAYOUT_REASON_ID, unique = true, nullable = false)
	private Integer payoutReasonId;

	@Column(name = PAYOUT_REASON)
	private String payoutReason;

	public PayoutReason() {
	}

	public Integer getPayoutReasonId() {
		return payoutReasonId;
	}

	public void setPayoutReasonId(Integer payoutReasonId) {
		this.payoutReasonId = payoutReasonId;
	}

	public String getPayoutReason() {
		return payoutReason;
	}

	public void setPayoutReason(String payoutReason) {
		this.payoutReason = payoutReason;
	}
}
