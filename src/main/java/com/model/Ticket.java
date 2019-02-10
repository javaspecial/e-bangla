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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "TICKET")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	public final static String TICKET_ID = "ticketId";
	public final static String TICKET_GLOBAL_ID = "ticketGlobalId";
	public final static String TICKET_CREATE_DATE = "ticketCreateDate";
	public final static String TICKET_CLOSING_DATE = "ticketClosingDate";
	public final static String TICKET_ACTIVE_DATE = "ticketActiveDate";
	public final static String TICKET_DELIVEERY_DATE = "ticketDeliveryDate";
	public final static String TICKET_CREATION_HOUR = "ticketCreationHour";
	public final static String TICKET_PAID = "ticketPaid";
	public final static String TICKET_VOIDED = "ticketVoided";
	public final static String TICKET_VOID_REASON = "ticketVoidReason";
	public final static String TICKET_WASTED = "ticketWasted";
	public final static String TICKET_REFUNDED = "ticketRefunded";
	public final static String TICKET_SETTLED = "ticketSettled";
	public final static String TICKET_SUB_TOTAL = "ticketSubTotal";
	public final static String TICKET_TOTAL_DISCOUNT = "ticketTotalDiscount";
	public final static String TICKET_TOTAL_TAX = "ticketTotalTax";
	public final static String TICKET_TOTAL_PRICE = "ticketTotalPrice";
	public final static String TICKET_PAID_AMOUNT = "ticketPaidAmount";
	public final static String TICKET_DUE_AMOUNT = "ticketDueAmount";
	public final static String TICKET_ADVANCE_AMOUNT = "ticketAdvanceAmount";
	public final static String TICKET_STATUS = "ticketStatus";
	public final static String TICKET_IS_TAX_EXEMPT = "ticketIsTaxExempt";
	public final static String TICKET_IS_RE_OPENED = "ticketIsReOpened";
	public final static String TICKET_SERVICE_CHARGE = "ticketServiceCharge";
	public final static String TICKET_CUSTOMER_ID = "ticketCustomerId";
	public final static String TICKET_TYPE = "ticketType";
	public final static String TICKET = "ticket";
	public final static String PROPERTIES = "properties";
	public final static String TICKET_TERMINAL = "terminal";
	public final static String TIPS = "tips";
	public static final String CUSTOMER_NAME = "customerName";
	public static final String CUSTOMER_MOBILE = "customerPhone";
	public static final String ORDER_TYPE = "orderType";
	public static final String PROP_TABLE_NUMBERS = "tableNumbers";
	public static final String NUMBER_OF_GUESTS = "numberOfGuest";
	public static final String CUSTOMER_ID = "customerId";
	private static final String CUSTOMER_ZIP_CODE = "customerZipCode";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TICKET_ID, unique = true, nullable = false)
	private Integer ticketId;

	@Column(name = TICKET_GLOBAL_ID)
	private String ticketGlobalId;

	@Column(name = TICKET_CREATE_DATE)
	private Date ticketCreateDate;

	@Column(name = TICKET_CLOSING_DATE)
	private Date ticketClosingDate;

	@Column(name = TICKET_ACTIVE_DATE)
	private Date ticketActiveDate;

	@Column(name = TICKET_DELIVEERY_DATE)
	private Date ticketDeliveryDate;

	@Column(name = TICKET_CREATION_HOUR)
	private Integer ticketCreationHour;

	@Column(name = TICKET_PAID)
	private Boolean ticketPaid;

	@Column(name = TICKET_VOIDED)
	private Boolean ticketVoided;

	@Column(name = TICKET_VOID_REASON)
	private String ticketVoidReason;

	@Column(name = TICKET_WASTED)
	private Boolean ticketWasted;

	@Column(name = TICKET_REFUNDED)
	private Boolean ticketRefunded;

	@Column(name = TICKET_SETTLED)
	private Boolean ticketSettled;

	@Column(name = TICKET_SUB_TOTAL)
	private double ticketSubTotal;

	@Column(name = TICKET_TOTAL_DISCOUNT)
	private double ticketTotalDiscount;

	@Column(name = TICKET_TOTAL_TAX)
	private double ticketTotalTax;

	@Column(name = TICKET_TOTAL_PRICE)
	private double ticketTotalPrice;

	@Column(name = TICKET_PAID_AMOUNT)
	private double ticketPaidAmount;

	@Column(name = TICKET_DUE_AMOUNT)
	private double ticketDueAmount;

	@Column(name = TICKET_ADVANCE_AMOUNT)
	private double ticketAdvanceAmount;

	@Column(name = TICKET_STATUS)
	private String ticketStatus;

	@Column(name = TICKET_IS_TAX_EXEMPT)
	private Boolean ticketIsTaxExempt;

	@Column(name = TICKET_IS_RE_OPENED)
	private Boolean ticketIsReOpened;

	@Column(name = TICKET_SERVICE_CHARGE)
	private double ticketServiceCharge;

	@Column(name = TICKET_CUSTOMER_ID)
	private Integer ticketCustomerId;

	@Column(name = TICKET_TYPE)
	private String ticketType;

	@Column(name = NUMBER_OF_GUESTS)
	private Integer numberOfGuest;

	@Transient
	private List<Object> deletedItems;

	@Transient
	protected Double adjustmentAmount;

	@Transient
	protected Boolean closed;

	@Transient
	private boolean priceIncludesTax;

	@ElementCollection
	@MapKeyColumn(name = TICKET)
	@Column(name = PROPERTIES)
	@JoinTable(name = TICKET + "_" + PROPERTIES)
	private Map<String, String> properties;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = TICKET_ID)
	private List<TicketItem> ticketItem;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = TICKET_ID)
	private List<TicketDiscount> ticketDiscount;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = TICKET_ID, insertable = false, updatable = false)
	private Set<PosTransaction> posTransaction;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = Shift.SHIFT_ID, referencedColumnName = Shift.SHIFT_ID)
	private Shift shift;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = User.USER_ID, referencedColumnName = User.USER_ID)
	private User owner;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = TIPS, referencedColumnName = Tips.TIPS_ID)
	private Tips tips;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = TICKET_TERMINAL, referencedColumnName = Terminal.TERMINAL_ID)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = ORDER_TYPE, referencedColumnName = OrderType.PROP_ID)
	private OrderType orderType;

	@ElementCollection
	@CollectionTable(name = PROP_TABLE_NUMBERS, joinColumns = @JoinColumn(name = TICKET_ID))
	@Column(name = PROP_TABLE_NUMBERS)
	private List<Integer> tableNumbers;

	public Ticket() {
	}

	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId
	 *            the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the ticketGlobalId
	 */
	public String getTicketGlobalId() {
		return ticketGlobalId;
	}

	/**
	 * @param ticketGlobalId
	 *            the ticketGlobalId to set
	 */
	public void setTicketGlobalId(String ticketGlobalId) {
		this.ticketGlobalId = ticketGlobalId;
	}

	/**
	 * @return the ticketCreateDate
	 */
	public Date getTicketCreateDate() {
		return ticketCreateDate;
	}

	/**
	 * @param ticketCreateDate
	 *            the ticketCreateDate to set
	 */
	public void setTicketCreateDate(Date ticketCreateDate) {
		this.ticketCreateDate = ticketCreateDate;
	}

	/**
	 * @return the ticketClosingDate
	 */
	public Date getTicketClosingDate() {
		return ticketClosingDate;
	}

	/**
	 * @param ticketClosingDate
	 *            the ticketClosingDate to set
	 */
	public void setTicketClosingDate(Date ticketClosingDate) {
		this.ticketClosingDate = ticketClosingDate;
	}

	/**
	 * @return the ticketActiveDate
	 */
	public Date getTicketActiveDate() {
		return ticketActiveDate;
	}

	/**
	 * @param ticketActiveDate
	 *            the ticketActiveDate to set
	 */
	public void setTicketActiveDate(Date ticketActiveDate) {
		this.ticketActiveDate = ticketActiveDate;
	}

	/**
	 * @return the ticketDeliveryDate
	 */
	public Date getTicketDeliveryDate() {
		return ticketDeliveryDate;
	}

	/**
	 * @param ticketDeliveryDate
	 *            the ticketDeliveryDate to set
	 */
	public void setTicketDeliveryDate(Date ticketDeliveryDate) {
		this.ticketDeliveryDate = ticketDeliveryDate;
	}

	/**
	 * @return the ticketCreationHour
	 */
	public Integer getTicketCreationHour() {
		return ticketCreationHour;
	}

	/**
	 * @param ticketCreationHour
	 *            the ticketCreationHour to set
	 */
	public void setTicketCreationHour(Integer ticketCreationHour) {
		this.ticketCreationHour = ticketCreationHour;
	}

	/**
	 * @return the ticketPain
	 */
	public Boolean getTicketPaid() {
		return ticketPaid;
	}

	/**
	 * @param ticketPain
	 *            the ticketPain to set
	 */
	public void setTicketPaid(Boolean ticketPaid) {
		this.ticketPaid = ticketPaid;
	}

	/**
	 * @return the ticketVoided
	 */
	public Boolean getTicketVoided() {
		return ticketVoided;
	}

	/**
	 * @param ticketVoided
	 *            the ticketVoided to set
	 */
	public void setTicketVoided(Boolean ticketVoided) {
		this.ticketVoided = ticketVoided;
	}

	/**
	 * @return the ticketVoidReason
	 */
	public String getTicketVoidReason() {
		return ticketVoidReason;
	}

	/**
	 * @param ticketVoidReason
	 *            the ticketVoidReason to set
	 */
	public void setTicketVoidReason(String ticketVoidReason) {
		this.ticketVoidReason = ticketVoidReason;
	}

	/**
	 * @return the ticketWasted
	 */
	public Boolean getTicketWasted() {
		return ticketWasted;
	}

	/**
	 * @param ticketWasted
	 *            the ticketWasted to set
	 */
	public void setTicketWasted(Boolean ticketWasted) {
		this.ticketWasted = ticketWasted;
	}

	/**
	 * @return the ticketRefunded
	 */
	public Boolean getTicketRefunded() {
		return ticketRefunded;
	}

	/**
	 * @param ticketRefunded
	 *            the ticketRefunded to set
	 */
	public void setTicketRefunded(Boolean ticketRefunded) {
		this.ticketRefunded = ticketRefunded;
	}

	/**
	 * @return the ticketSettled
	 */
	public Boolean getTicketSettled() {
		return ticketSettled;
	}

	/**
	 * @param ticketSettled
	 *            the ticketSettled to set
	 */
	public void setTicketSettled(Boolean ticketSettled) {
		this.ticketSettled = ticketSettled;
	}

	/**
	 * @return the ticketSubTotal
	 */
	public double getTicketSubTotal() {
		return ticketSubTotal;
	}

	/**
	 * @param ticketSubTotal
	 *            the ticketSubTotal to set
	 */
	public void setTicketSubTotal(double ticketSubTotal) {
		this.ticketSubTotal = ticketSubTotal;
	}

	/**
	 * @return the ticketTotalDiscount
	 */
	public double getTicketTotalDiscount() {
		return ticketTotalDiscount;
	}

	/**
	 * @param ticketTotalDiscount
	 *            the ticketTotalDiscount to set
	 */
	public void setTicketTotalDiscount(double ticketTotalDiscount) {
		this.ticketTotalDiscount = ticketTotalDiscount;
	}

	/**
	 * @return the ticketTotalTax
	 */
	public double getTicketTotalTax() {
		return ticketTotalTax;
	}

	/**
	 * @param ticketTotalTax
	 *            the ticketTotalTax to set
	 */
	public void setTicketTotalTax(double ticketTotalTax) {
		this.ticketTotalTax = ticketTotalTax;
	}

	/**
	 * @return the ticketTotalPrice
	 */
	public double getTicketTotalPrice() {
		return ticketTotalPrice;
	}

	/**
	 * @param ticketTotalPrice
	 *            the ticketTotalPrice to set
	 */
	public void setTicketTotalPrice(double ticketTotalPrice) {
		this.ticketTotalPrice = ticketTotalPrice;
	}

	/**
	 * @return the ticketPaidAmount
	 */
	public double getTicketPaidAmount() {
		return ticketPaidAmount;
	}

	/**
	 * @param ticketPaidAmount
	 *            the ticketPaidAmount to set
	 */
	public void setTicketPaidAmount(double ticketPaidAmount) {
		this.ticketPaidAmount = ticketPaidAmount;
	}

	/**
	 * @return the ticketDueAmount
	 */
	public double getTicketDueAmount() {
		return ticketDueAmount;
	}

	/**
	 * @param ticketDueAmount
	 *            the ticketDueAmount to set
	 */
	public void setTicketDueAmount(double ticketDueAmount) {
		this.ticketDueAmount = ticketDueAmount;
	}

	/**
	 * @return the ticketAdvanceAmount
	 */
	public double getTicketAdvanceAmount() {
		return ticketAdvanceAmount;
	}

	/**
	 * @param ticketAdvanceAmount
	 *            the ticketAdvanceAmount to set
	 */
	public void setTicketAdvanceAmount(double ticketAdvanceAmount) {
		this.ticketAdvanceAmount = ticketAdvanceAmount;
	}

	/**
	 * @return the ticketStatus
	 */
	public String getTicketStatus() {
		return ticketStatus;
	}

	/**
	 * @param ticketStatus
	 *            the ticketStatus to set
	 */
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	/**
	 * @return the ticketIsTaxExempt
	 */
	public Boolean getTicketIsTaxExempt() {
		return ticketIsTaxExempt;
	}

	/**
	 * @param ticketIsTaxExempt
	 *            the ticketIsTaxExempt to set
	 */
	public void setTicketIsTaxExempt(Boolean ticketIsTaxExempt) {
		this.ticketIsTaxExempt = ticketIsTaxExempt;
	}

	/**
	 * @return the ticketIsReOpened
	 */
	public Boolean getTicketIsReOpened() {
		return ticketIsReOpened;
	}

	/**
	 * @param ticketIsReOpened
	 *            the ticketIsReOpened to set
	 */
	public void setTicketIsReOpened(Boolean ticketIsReOpened) {
		this.ticketIsReOpened = ticketIsReOpened;
	}

	/**
	 * @return the ticketServiceCharge
	 */
	public double getTicketServiceCharge() {
		return ticketServiceCharge;
	}

	/**
	 * @param ticketServiceCharge
	 *            the ticketServiceCharge to set
	 */
	public void setTicketServiceCharge(double ticketServiceCharge) {
		this.ticketServiceCharge = ticketServiceCharge;
	}

	/**
	 * @return the ticketCustomerId
	 */
	public Integer getTicketCustomerId() {
		return ticketCustomerId;
	}

	/**
	 * @param ticketCustomerId
	 *            the ticketCustomerId to set
	 */
	public void setTicketCustomerId(Integer ticketCustomerId) {
		this.ticketCustomerId = ticketCustomerId;
	}

	/**
	 * @return the ticketType
	 */
	public String getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType
	 *            the ticketType to set
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * @return the properties
	 */
	public Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	/**
	 * @return the ticketItem
	 */
	public List<TicketItem> getTicketItem() {
		return ticketItem;
	}

	/**
	 * @param ticketItem
	 *            the ticketItem to set
	 */
	public void setTicketItem(List<TicketItem> ticketItem) {
		this.ticketItem = ticketItem;
	}

	/**
	 * @return the ticketDiscount
	 */
	public List<TicketDiscount> getTicketDiscount() {
		return ticketDiscount;
	}

	/**
	 * @param ticketDiscount
	 *            the ticketDiscount to set
	 */
	public void setTicketDiscount(List<TicketDiscount> ticketDiscount) {
		this.ticketDiscount = ticketDiscount;
	}

	/**
	 * @return the posTransaction
	 */
	public Set<PosTransaction> getPosTransaction() {
		return posTransaction;
	}

	/**
	 * @param posTransaction
	 *            the posTransaction to set
	 */
	public void setPosTransaction(Set<PosTransaction> posTransaction) {
		this.posTransaction = posTransaction;
	}

	/**
	 * @return the shift
	 */
	public Shift getShift() {
		return shift;
	}

	/**
	 * @param shift
	 *            the shift to set
	 */
	public void setShift(Shift shift) {
		this.shift = shift;
	}

	/**
	 * @return the user
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setOwner(User Owner) {
		this.owner = Owner;
	}

	/**
	 * @return the tips
	 */
	public Tips getTips() {
		return tips;
	}

	/**
	 * @param tips
	 *            the tips to set
	 */
	public void setTips(Tips tips) {
		this.tips = tips;
	}

	/**
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public List<Integer> getTableNumbers() {
		return tableNumbers;
	}

	public void setTableNumbers(List<Integer> tableNumbers) {
		this.tableNumbers = tableNumbers;
	}

	public Integer getNumberOfGuest() {
		return numberOfGuest;
	}

	public void setNumberOfGuest(Integer numberOfGuest) {
		this.numberOfGuest = numberOfGuest;
	}

	public Boolean isClosed() {
		return closed == null ? Boolean.FALSE : closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public java.lang.Double getAdjustmentAmount() {
		return adjustmentAmount == null ? Double.valueOf(0) : adjustmentAmount;
	}

	public void setAdjustmentAmount(java.lang.Double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}
}
