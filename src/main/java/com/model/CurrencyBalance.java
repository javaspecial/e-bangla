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

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "CURRENCY_BALANCE")
public class CurrencyBalance implements Serializable {
	public static final String CURRENCY_BALANCE_ID = "currency_balance_id";
	public static final String BALANCE = "balance";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CURRENCY_BALANCE_ID, unique = true, nullable = false)
	private Integer currencyBalanceId;

	@Column(name = DrawerPullReport.DRAWER_PULL_REPORT_ID)
	private Integer drawerPullReportId;

	@Column(name = BALANCE)
	private double currencyBalance;

	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = Currency.CURRENCY_ID, referencedColumnName = Currency.CURRENCY_ID)
	private Currency currency;

	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = CashDrawer.CASH_DRAWER_ID, referencedColumnName = CashDrawer.CASH_DRAWER_ID)
	private CashDrawer cashDrawer;

	public CurrencyBalance() {

	}

	/**
	 * @return the currencyBalanceId
	 */
	public Integer getCurrencyBalanceId() {
		return currencyBalanceId;
	}

	/**
	 * @param currencyBalanceId
	 *            the currencyBalanceId to set
	 */
	public void setCurrencyBalanceId(Integer currencyBalanceId) {
		this.currencyBalanceId = currencyBalanceId;
	}

	public Integer getDrawerPullReportId() {
		return drawerPullReportId;
	}

	public void setDrawerPullReportId(Integer drawerPullReportId) {
		this.drawerPullReportId = drawerPullReportId;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return currencyBalance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double currencyBalance) {
		this.currencyBalance = currencyBalance;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * @return the cashDrawer
	 */
	public CashDrawer getCashDrawer() {
		return cashDrawer;
	}

	/**
	 * @param cashDrawer
	 *            the cashDrawer to set
	 */
	public void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}

}
