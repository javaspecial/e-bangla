/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.softpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is SOFT POS.
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.model;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	public final static String CUSTOMER_ID = "customer_id";
	public final static String CUSTOMER_PICTURE = "customer_picture";
	public final static String CUSTOMER_PHONE = "customer_phone";
	public final static String CUSTOMER_FIRST_NAME = "customer_first_name";
	public final static String CUSTOMER_LAST_NAME = "customer_last_name";
	public final static String CUSTOMER_NAME = "customer_name";
	public final static String CUSTOMER_DOB = "customer_dob";
	public final static String CUSTOMER_SSN = "customer_ssn";
	public final static String CUSTOMER_ADDRESS = "customer_address";
	public final static String CUSTOMER_CITY = "customer_city";
	public final static String CUSTOMER_STATE = "customer_state";
	public final static String CUSTOMER_ZIP_CODE = "customer_zip_code";
	public final static String CUSTOMER_COUNTRY = "customer_country";
	public final static String CUSTOMER_VIP = "customer_vip";
	public final static String CUSTOMER_CREDIT_LIMIT = "customer_credit_limit";
	public final static String CUSTOMER_CREDIT_SPENT = "customer_credit_spent";
	public final static String CUSTOMER_CREDIT_CARD_NO = "customer_credit_card_no";
	public final static String CUSTOMER_NOTE = "customer_note";
	public final static String CUSTOMER = "customer";
	public final static String PROPERTIES = "properties";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CUSTOMER_ID, unique = true, nullable = false)
	private Integer customerId;

	@Column(name = CUSTOMER_PICTURE)
	private byte[] customerPicture;

	@Column(name = CUSTOMER_PHONE)
	private String customerPhone;

	@Column(name = CUSTOMER_FIRST_NAME)
	private String customerFirstName;

	@Column(name = CUSTOMER_LAST_NAME)
	private String customerLastName;

	@Column(name = CUSTOMER_NAME)
	private String customerName;

	@Column(name = CUSTOMER_DOB)
	private String customerDob;

	@Column(name = CUSTOMER_SSN)
	private String customerSsn;

	@Column(name = CUSTOMER_ADDRESS)
	private String customerAddress;

	@Column(name = CUSTOMER_CITY)
	private String customerCity;

	@Column(name = CUSTOMER_STATE)
	private String customerState;

	@Column(name = CUSTOMER_ZIP_CODE)
	private String customerZipCode;

	@Column(name = CUSTOMER_COUNTRY)
	private String customerCountry;

	@Column(name = CUSTOMER_VIP)
	private Boolean customerVip;

	@Column(name = CUSTOMER_CREDIT_LIMIT)
	private double customerCreditLimit;

	@Column(name = CUSTOMER_CREDIT_SPENT)
	private double customerCreditSpent;

	@Column(name = CUSTOMER_CREDIT_CARD_NO)
	private String customerCreditCardNo;

	@Column(name = CUSTOMER_NOTE)
	private String customerNote;

	@ElementCollection
	@MapKeyColumn(name = CUSTOMER)
	@Column(name = PROPERTIES)
	@CollectionTable(name = CUSTOMER + "_" + PROPERTIES)
	private Map<Integer, String> properties;

	public Customer() {
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerPicture
	 */
	public byte[] getCustomerPicture() {
		return customerPicture;
	}

	/**
	 * @param customerPicture the customerPicture to set
	 */
	public void setCustomerPicture(byte[] customerPicture) {
		this.customerPicture = customerPicture;
	}

	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * @param customerPhone the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * @return the customerFirstName
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * @param customerFirstName the customerFirstName to set
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * @return the customerLastName
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerDob
	 */
	public String getCustomerDob() {
		return customerDob;
	}

	/**
	 * @param customerDob the customerDob to set
	 */
	public void setCustomerDob(String customerDob) {
		this.customerDob = customerDob;
	}

	/**
	 * @return the customerSsn
	 */
	public String getCustomerSsn() {
		return customerSsn;
	}

	/**
	 * @param customerSsn the customerSsn to set
	 */
	public void setCustomerSsn(String customerSsn) {
		this.customerSsn = customerSsn;
	}

	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * @return the customerCity
	 */
	public String getCustomerCity() {
		return customerCity;
	}

	/**
	 * @param customerCity the customerCity to set
	 */
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	/**
	 * @return the customerState
	 */
	public String getCustomerState() {
		return customerState;
	}

	/**
	 * @param customerState the customerState to set
	 */
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	/**
	 * @return the customerZipCode
	 */
	public String getCustomerZipCode() {
		return customerZipCode;
	}

	/**
	 * @param customerZipCode the customerZipCode to set
	 */
	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}

	/**
	 * @return the customerCountry
	 */
	public String getCustomerCountry() {
		return customerCountry;
	}

	/**
	 * @param customerCountry the customerCountry to set
	 */
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	/**
	 * @return the customerVip
	 */
	public Boolean getCustomerVip() {
		return customerVip;
	}

	/**
	 * @param customerVip the customerVip to set
	 */
	public void setCustomerVip(Boolean customerVip) {
		this.customerVip = customerVip;
	}

	/**
	 * @return the customerCreditLimit
	 */
	public double getCustomerCreditLimit() {
		return customerCreditLimit;
	}

	/**
	 * @param customerCreditLimit the customerCreditLimit to set
	 */
	public void setCustomerCreditLimit(double customerCreditLimit) {
		this.customerCreditLimit = customerCreditLimit;
	}

	/**
	 * @return the customerCreditSpent
	 */
	public double getCustomerCreditSpent() {
		return customerCreditSpent;
	}

	/**
	 * @param customerCreditSpent the customerCreditSpent to set
	 */
	public void setCustomerCreditSpent(double customerCreditSpent) {
		this.customerCreditSpent = customerCreditSpent;
	}

	/**
	 * @return the customerCreditCardNo
	 */
	public String getCustomerCreditCardNo() {
		return customerCreditCardNo;
	}

	/**
	 * @param customerCreditCardNo the customerCreditCardNo to set
	 */
	public void setCustomerCreditCardNo(String customerCreditCardNo) {
		this.customerCreditCardNo = customerCreditCardNo;
	}

	/**
	 * @return the customerNote
	 */
	public String getCustomerNote() {
		return customerNote;
	}

	/**
	 * @param customerNote the customerNote to set
	 */
	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}

	/**
	 * @return the properties
	 */
	public Map<Integer, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Map<Integer, String> properties) {
		this.properties = properties;
	}

}
