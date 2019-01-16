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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "TERMINAL")
public class Terminal {

	public static final String ID = "id";
	public static final String TERMINAL_ID = "terminalId";
	public static final String TERMINAL_NAME = "terminalName";
	public static final String TERMINAL_KEY = "terminalKey";
	public static final String TERMINAL_CURRENT_BALANCE = "currentBalance";
	public static final String TERMINAL_OPENING_BALANCE = "openingBalance";
	public static final String TERMINAL_HAS_CASH_DRAWER = "hasCashDrawer";
	public static final String MENU_ITEM = "menuItem";
	public static final String ASSIGNED_USER = "assignedUser";
	public static final String TERMINAL_MENUITEM = "terminal_menuitem";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TERMINAL_ID, unique = true, nullable = false)
	private Integer terminalId;

	@Column(name = ID)
	private Integer id;

	@Column(name = TERMINAL_NAME)
	private String terminalName;

	@Column(name = TERMINAL_KEY)
	private String terminalKey;

	@Column(name = TERMINAL_OPENING_BALANCE)
	private double openingBalance;

	@Column(name = TERMINAL_CURRENT_BALANCE)
	private double currentBalance;

	@Column(name = TERMINAL_HAS_CASH_DRAWER)
	private boolean hasCashDrawer;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = TERMINAL_MENUITEM, joinColumns = @JoinColumn(name = TERMINAL_ID), inverseJoinColumns = @JoinColumn(name = MenuItem.MENU_ITEM_ID))
	private List<MenuItem> menuItem;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = ASSIGNED_USER, referencedColumnName = User.USER_ID)
	private User assignedUser;

	public Terminal() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the terminalId
	 */
	public Integer getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId
	 *            the terminalId to set
	 */
	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the terminalName
	 */
	public String getTerminalName() {
		return terminalName;
	}

	/**
	 * @param terminalName
	 *            the terminalName to set
	 */
	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	/**
	 * @return the terminalKey
	 */
	public String getTerminalKey() {
		return terminalKey;
	}

	/**
	 * @param terminalKey
	 *            the terminalKey to set
	 */
	public void setTerminalKey(String terminalKey) {
		this.terminalKey = terminalKey;
	}

	/**
	 * @return the openingBalance
	 */
	public double getOpeningBalance() {
		return openingBalance;
	}

	/**
	 * @param openingBalance
	 *            the openingBalance to set
	 */
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	/**
	 * @return the currentBalance
	 */
	public double getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance
	 *            the currentBalance to set
	 */
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the hasCashDrawer
	 */
	public boolean isHasCashDrawer() {
		return hasCashDrawer;
	}

	/**
	 * @param hasCashDrawer
	 *            the hasCashDrawer to set
	 */
	public void setHasCashDrawer(boolean hasCashDrawer) {
		this.hasCashDrawer = hasCashDrawer;
	}

	public List<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(List<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public boolean isCashDrawerAssigned() {
		return getAssignedUser() != null;
	}
}
