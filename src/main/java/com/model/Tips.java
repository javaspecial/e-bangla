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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "TIPS")
public class Tips {
	public static final String TIPS_ID = "tipsId";
	public static final String TIPS_AMOUNT = "tipsAmount";
	public static final String TIPS_PAID = "tipsPaid";
	public static final String TIPS_REFUNDED = "tipsRefunded";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TIPS_ID, unique = true, nullable = false)
	private Integer tipsId;

	@Column(name = TIPS_AMOUNT)
	private double tipsAmount;

	@Column(name = TIPS_PAID)
	private boolean tipsPaid;

	@Column(name = TIPS_REFUNDED)
	private boolean tipsRefunded;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Ticket.TICKET_ID, referencedColumnName = Ticket.TICKET_ID)
	private Ticket ticket;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = User.USER_ID, referencedColumnName = User.USER_ID)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Terminal.TERMINAL_ID, referencedColumnName = Terminal.TERMINAL_ID)
	private Terminal terminal;

	public Tips() {
	}

	public Integer getTipsId() {
		return tipsId;
	}

	public void setTipsId(Integer tipsId) {
		this.tipsId = tipsId;
	}

	public double getTipsAmount() {
		return tipsAmount;
	}

	public void setTipsAmount(double tipsAmount) {
		this.tipsAmount = tipsAmount;
	}

	public boolean getTipsPaid() {
		return tipsPaid;
	}

	public void setTipsPaid(boolean tipsPaid) {
		this.tipsPaid = tipsPaid;
	}

	public boolean getTipsRefunded() {
		return tipsRefunded;
	}

	public void setTipsRefunded(boolean tipsRefunded) {
		this.tipsRefunded = tipsRefunded;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public boolean isRefunded() {
		return false;
	}
}
