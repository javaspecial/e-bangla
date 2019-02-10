package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOM_PAYMENT")
public class CustomPayment {
	public final static String CUSTOM_PAYMENT_ID = "custom_payment_id";
	public final static String CUSTOM_PAYMENT_NAME = "custom_payment_NAME";
	public final static String CUSTOM_PAYMENT_REQUIRED_REF_NUMBER = "custom_payment_required_ref_number";
	public final static String CUSTOM_PAYMENT_REF_NUMBER_FIELD_NAME = "custom_payment_ref_number_field_name";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CUSTOM_PAYMENT_ID, unique = true, nullable = false)
	private Integer customPayment;

	@Column(name = CUSTOM_PAYMENT_NAME)
	private String customPaymentName;

	@Column(name = CUSTOM_PAYMENT_REQUIRED_REF_NUMBER)
	private boolean customPaymentRequiredRefNumber;

	@Column(name = CUSTOM_PAYMENT_REF_NUMBER_FIELD_NAME)
	private String customPaymentRefNumberFieldName;

	public CustomPayment() {
	}

	public Integer getCustomPayment() {
		return customPayment;
	}

	public void setCustomPayment(Integer customPayment) {
		this.customPayment = customPayment;
	}

	public String getCustomPaymentName() {
		return customPaymentName;
	}

	public void setCustomPaymentName(String customPaymentName) {
		this.customPaymentName = customPaymentName;
	}

	public boolean isCustomPaymentRequiredRefNumber() {
		return customPaymentRequiredRefNumber;
	}

	public void setCustomPaymentRequiredRefNumber(boolean customPaymentRequiredRefNumber) {
		this.customPaymentRequiredRefNumber = customPaymentRequiredRefNumber;
	}

	public String getCustomPaymentRefNumberFieldName() {
		return customPaymentRefNumberFieldName;
	}

	public void setCustomPaymentRefNumberFieldName(String customPaymentRefNumberFieldName) {
		this.customPaymentRefNumberFieldName = customPaymentRefNumberFieldName;
	}
}
