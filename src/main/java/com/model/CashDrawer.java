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
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "CASH_DRAWER")
public class CashDrawer implements Serializable {
	public static final String CASH_DRAWER_ID = "cashDrawerId";
	public static final String TERMINAL = "terminal";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CASH_DRAWER_ID, unique = true, nullable = false)
	private Integer cashDrawerId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = TERMINAL, referencedColumnName = Terminal.TERMINAL_ID)
	private Terminal terminal;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = CASH_DRAWER_ID)
	private Set<CurrencyBalance> currencyBalance;

	public CashDrawer() {
	}

	/**
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return terminal;
	}

	public Integer getCashDrawerId() {
		return cashDrawerId;
	}

	public void setCashDrawerId(Integer cashDrawerId) {
		this.cashDrawerId = cashDrawerId;
	}

	/**
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the currencyBalance
	 */
	public Set<CurrencyBalance> getCurrencyBalance() {
		return currencyBalance;
	}

	/**
	 * @param currencyBalance
	 *            the currencyBalance to set
	 */
	public void setCurrencyBalance(Set<CurrencyBalance> currencyBalance) {
		this.currencyBalance = currencyBalance;
	}

}
