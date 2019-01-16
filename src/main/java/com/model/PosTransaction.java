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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.basemodel.BasePosTransaction;
//import com.soft.pos.helper.GlobalIdGenerator;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "POS_TRANSACTION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pos_transaction_payment_type", discriminatorType = DiscriminatorType.STRING, length = 30)
public class PosTransaction extends BasePosTransaction {
	private static final long serialVersionUID = 1L;
	public static final String POS_TRANSACTION_ID = "pos_transaction_id";
	public static final String POS_TRANSACTION_TIME = "pos_transaction_time";
	public static final String POS_TRANSACTION_AMOUNT = "pos_transaction_amount";
	public static final String POS_TRANSACTION_TIPS_AMOUNT = "pos_transaction_tips_amount";
	public static final String POS_TRANSACTION_TIPS_EXCEED_AMOUNT = "pos_transaction_tips_exceed_amount";
	public static final String POS_TRANSACTION_TENDER_AMOUNT = "pos_transaction_tender_amount";
	public static final String POS_TRANSACTION_TYPE = "pos_transaction_type";
	public static final String POS_TRANSACTION_CUSTOM_PAYMENT_NAME = "pos_transaction_custom_payment_name";
	public static final String POS_TRANSACTION_CUSTOM_PAYMENT_REF = "pos_transaction_custom_payment_ref";
	public static final String POS_TRANSACTION_CUSTOM_PAYMENT_FIELD_NAME = "pos_transaction_custom_payment_field_name";
	public static final String POS_TRANSACTION_PAYMENT_SUB_TYPE = "pos_transaction_payment_sub_type";
	public static final String POS_TRANSACTION_CAPTURED = "pos_transaction_captured";
	public static final String POS_TRANSACTION_VOIDED = "pos_transaction_voided";
	public static final String POS_TRANSACTION_AUTHORIZABLE = "pos_transaction_authorizable";
	public static final String POS_TRANSACTION_CARD_HOLDER_NAME = "pos_transaction_card_holder_name";
	public static final String POS_TRANSACTION_CARD_NUMBER = "pos_transaction_card_number";
	public static final String POS_TRANSACTION_CARD_AUTH_CODE = "pos_transaction_card_auth_code";
	public static final String POS_TRANSACTION_CARD_TYPE = "pos_transaction_card_type";
	public static final String POS_TRANSACTION_CARD_TRANSACTION_ID = "pos_transaction_card_transaction_id";
	public static final String POS_TRANSACTION_CARD_MERCHANT_GATEWAY = "pos_transaction_card_merchant_gateway";
	public static final String POS_TRANSACTION_CARD_READER = "pos_transaction_card_reader";
	public static final String POS_TRANSACTION_CARD_AID = "pos_transaction_card_aid";
	public static final String POS_TRANSACTION_CARD_ARQC = "pos_transaction_card_arqc";
	public static final String POS_TRANSACTION_CARD_EXT_DATA = "pos_transaction_card_ext_data";
	public static final String POS_TRANSACTION_DRAWER_RESETTED = "pos_transaction_drawer_resetted";
	public static final String POS_TRANSACTION_NOTE = "pos_transaction_note";
	public static final String PROPERTIES = "properties";
	public static final String POS_TRANSACTION = "pos_transaction";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = POS_TRANSACTION_ID, unique = true, nullable = false)
	private Integer posTransactionId;

	@Column(name = Ticket.TICKET_ID, insertable = false, updatable = false)
	private Integer ticketId;

	@Column(name = POS_TRANSACTION_TIME)
	private Date posTransactionTime;

	@Column(name = POS_TRANSACTION_AMOUNT)
	private double posTransactionAmount;

	@Column(name = POS_TRANSACTION_TIPS_AMOUNT)
	private double posTransactionTipsAmount;

	@Column(name = POS_TRANSACTION_TIPS_EXCEED_AMOUNT)
	private double posTransactionTipsExceedAmount;

	@Column(name = POS_TRANSACTION_TENDER_AMOUNT)
	private double posTransactionTenderAmount;

	@Column(name = POS_TRANSACTION_TYPE)
	private String posTransactionType;

	@Column(name = POS_TRANSACTION_CUSTOM_PAYMENT_NAME)
	private String posTransactionCustomPaymentName;

	@Column(name = POS_TRANSACTION_CUSTOM_PAYMENT_REF)
	private String posTransactionCustomPaymentRef;

	@Column(name = POS_TRANSACTION_CUSTOM_PAYMENT_FIELD_NAME)
	private String posTransactionCustomPaymentFieldName;

	@Column(name = POS_TRANSACTION_PAYMENT_SUB_TYPE)
	private String posTransactionCustomPaymentSubType;

	@Column(name = POS_TRANSACTION_CAPTURED)
	private boolean posTransactionCaptured;

	@Column(name = POS_TRANSACTION_VOIDED)
	private boolean posTransactionVoided;

	@Column(name = POS_TRANSACTION_AUTHORIZABLE)
	private boolean posTransactionAuthorizable;

	@Column(name = POS_TRANSACTION_CARD_HOLDER_NAME)
	private String posTransactionCardHolderName;

	@Column(name = POS_TRANSACTION_CARD_NUMBER)
	private String posTransactionCardNumber;

	@Column(name = POS_TRANSACTION_CARD_AUTH_CODE)
	private String posTransactionCardAuthCode;

	@Column(name = POS_TRANSACTION_CARD_TYPE)
	private String posTransactionCardType;

	@Column(name = POS_TRANSACTION_CARD_TRANSACTION_ID)
	private String posTransactionCardTransactionId;

	@Column(name = POS_TRANSACTION_CARD_MERCHANT_GATEWAY)
	private String posTransactionCardMerchantGateway;

	@Column(name = POS_TRANSACTION_CARD_READER)
	private String posTransactionCardReader;

	@Column(name = POS_TRANSACTION_CARD_AID)
	private String posTransactionCardAid;

	@Column(name = POS_TRANSACTION_CARD_ARQC)
	private String posTransactionCardArqc;

	@Column(name = POS_TRANSACTION_CARD_EXT_DATA)
	private String posTransactionCardExtData;

	@Column(name = POS_TRANSACTION_DRAWER_RESETTED)
	private boolean posTransactionDrawerResetted;

	@Column(name = POS_TRANSACTION_NOTE)
	private String posTransactionNote;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = User.USER_ID, referencedColumnName = User.USER_ID)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = PayoutReason.PAYOUT_REASON_ID, referencedColumnName = PayoutReason.PAYOUT_REASON_ID)
	private PayoutReason payoutReason;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = PayoutRecepient.PAYOUT_RECEPIENT_ID, referencedColumnName = PayoutRecepient.PAYOUT_RECEPIENT_ID)
	private PayoutRecepient payoutRecepient;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Ticket.TICKET_ID, referencedColumnName = Ticket.TICKET_ID)
	private Ticket ticket;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Terminal.TERMINAL_ID, referencedColumnName = Terminal.TERMINAL_ID)
	private Terminal terminal;

	@ElementCollection
	@MapKeyColumn(name = POS_TRANSACTION)
	@Column(name = PROPERTIES)
	@CollectionTable(name = POS_TRANSACTION + "_" + PROPERTIES)
	private Map<String, String> properties;

	private String cardTrack;
	private String cardNo;
	private String cardExpYear;
	private String cardExpMonth;

	public PosTransaction() {
		super();
	}

	public PosTransaction(Integer id) {
		super(id);
	}

	public PosTransaction(Integer id, String transactionType, String paymentType) {
		super(id, transactionType, paymentType);
	}

	@Override
	protected void initialize() {
		/*String generateGlobalId = GlobalIdGenerator.generateGlobalId();
		setGlobalId(generateGlobalId);*/
	}

	public Integer getPosTransactionId() {
		return posTransactionId;
	}

	public void setPosTransactionId(Integer posTransactionId) {
		this.posTransactionId = posTransactionId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Date getPosTransactionTime() {
		return posTransactionTime;
	}

	public void setPosTransactionTime(Date posTransactionTime) {
		this.posTransactionTime = posTransactionTime;
	}

	public double getPosTransactionAmount() {
		return posTransactionAmount;
	}

	public void setPosTransactionAmount(double posTransactionAmount) {
		this.posTransactionAmount = posTransactionAmount;
	}

	public double getPosTransactionTipsAmount() {
		return posTransactionTipsAmount;
	}

	public void setPosTransactionTipsAmount(double posTransactionTipsAmount) {
		this.posTransactionTipsAmount = posTransactionTipsAmount;
	}

	public double getPosTransactionTipsExceedAmount() {
		return posTransactionTipsExceedAmount;
	}

	public void setPosTransactionTipsExceedAmount(double posTransactionTipsExceedAmount) {
		this.posTransactionTipsExceedAmount = posTransactionTipsExceedAmount;
	}

	public double getPosTransactionTenderAmount() {
		return posTransactionTenderAmount;
	}

	public void setPosTransactionTenderAmount(double posTransactionTenderAmount) {
		this.posTransactionTenderAmount = posTransactionTenderAmount;
	}

	public String getPosTransactionType() {
		return posTransactionType;
	}

	public void setPosTransactionType(String posTransactionType) {
		this.posTransactionType = posTransactionType;
	}

	public String getPosTransactionCustomPaymentName() {
		return posTransactionCustomPaymentName;
	}

	public void setPosTransactionCustomPaymentName(String posTransactionCustomPaymentName) {
		this.posTransactionCustomPaymentName = posTransactionCustomPaymentName;
	}

	public String getPosTransactionCustomPaymentRef() {
		return posTransactionCustomPaymentRef;
	}

	public void setPosTransactionCustomPaymentRef(String posTransactionCustomPaymentRef) {
		this.posTransactionCustomPaymentRef = posTransactionCustomPaymentRef;
	}

	public String getPosTransactionCustomPaymentFieldName() {
		return posTransactionCustomPaymentFieldName;
	}

	public void setPosTransactionCustomPaymentFieldName(String posTransactionCustomPaymentFieldName) {
		this.posTransactionCustomPaymentFieldName = posTransactionCustomPaymentFieldName;
	}

	public String getPosTransactionCustomPaymentSubType() {
		return posTransactionCustomPaymentSubType;
	}

	public void setPosTransactionCustomPaymentSubType(String posTransactionCustomPaymentSubType) {
		this.posTransactionCustomPaymentSubType = posTransactionCustomPaymentSubType;
	}

	public boolean isPosTransactionCaptured() {
		return posTransactionCaptured;
	}

	public void setPosTransactionCaptured(boolean posTransactionCaptured) {
		this.posTransactionCaptured = posTransactionCaptured;
	}

	public boolean isPosTransactionVoided() {
		return posTransactionVoided;
	}

	public void setPosTransactionVoided(boolean posTransactionVoided) {
		this.posTransactionVoided = posTransactionVoided;
	}

	public boolean isPosTransactionAuthorizable() {
		return posTransactionAuthorizable;
	}

	public void setPosTransactionAuthorizable(boolean posTransactionAuthorizable) {
		this.posTransactionAuthorizable = posTransactionAuthorizable;
	}

	public String getPosTransactionCardHolderName() {
		return posTransactionCardHolderName;
	}

	public void setPosTransactionCardHolderName(String posTransactionCardHolderName) {
		this.posTransactionCardHolderName = posTransactionCardHolderName;
	}

	public String getPosTransactionCardNumber() {
		return posTransactionCardNumber;
	}

	public void setPosTransactionCardNumber(String posTransactionCardNumber) {
		this.posTransactionCardNumber = posTransactionCardNumber;
	}

	public String getPosTransactionCardAuthCode() {
		return posTransactionCardAuthCode;
	}

	public void setPosTransactionCardAuthCode(String posTransactionCardAuthCode) {
		this.posTransactionCardAuthCode = posTransactionCardAuthCode;
	}

	public String getPosTransactionCardType() {
		return posTransactionCardType;
	}

	public void setPosTransactionCardType(String posTransactionCardType) {
		this.posTransactionCardType = posTransactionCardType;
	}

	public String getPosTransactionCardTransactionId() {
		return posTransactionCardTransactionId;
	}

	public void setPosTransactionCardTransactionId(String posTransactionCardTransactionId) {
		this.posTransactionCardTransactionId = posTransactionCardTransactionId;
	}

	public String getPosTransactionCardMerchantGateway() {
		return posTransactionCardMerchantGateway;
	}

	public void setPosTransactionCardMerchantGateway(String posTransactionCardMerchantGateway) {
		this.posTransactionCardMerchantGateway = posTransactionCardMerchantGateway;
	}

	public String getPosTransactionCardReader() {
		return posTransactionCardReader;
	}

	public void setPosTransactionCardReader(String posTransactionCardReader) {
		this.posTransactionCardReader = posTransactionCardReader;
	}

	public String getPosTransactionCardAid() {
		return posTransactionCardAid;
	}

	public void setPosTransactionCardAid(String posTransactionCardAid) {
		this.posTransactionCardAid = posTransactionCardAid;
	}

	public String getPosTransactionCardArqc() {
		return posTransactionCardArqc;
	}

	public void setPosTransactionCardArqc(String posTransactionCardArqc) {
		this.posTransactionCardArqc = posTransactionCardArqc;
	}

	public String getPosTransactionCardExtData() {
		return posTransactionCardExtData;
	}

	public void setPosTransactionCardExtData(String posTransactionCardExtData) {
		this.posTransactionCardExtData = posTransactionCardExtData;
	}

	public boolean isPosTransactionDrawerResetted() {
		return posTransactionDrawerResetted;
	}

	public void setPosTransactionDrawerResetted(boolean posTransactionDrawerResetted) {
		this.posTransactionDrawerResetted = posTransactionDrawerResetted;
	}

	public String getPosTransactionNote() {
		return posTransactionNote;
	}

	public void setPosTransactionNote(String posTransactionNote) {
		this.posTransactionNote = posTransactionNote;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PayoutReason getPayoutReason() {
		return payoutReason;
	}

	public void setPayoutReason(PayoutReason payoutReason) {
		this.payoutReason = payoutReason;
	}

	public PayoutRecepient getPayoutRecepient() {
		return payoutRecepient;
	}

	public void setPayoutRecepient(PayoutRecepient payoutRecepient) {
		this.payoutRecepient = payoutRecepient;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public String getCardTrack() {
		return cardTrack;
	}

	public void setCardTrack(String cardTrack) {
		this.cardTrack = cardTrack;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardExpYear() {
		return cardExpYear;
	}

	public void setCardExpYear(String cardExpYear) {
		this.cardExpYear = cardExpYear;
	}

	public String getCardExpMonth() {
		return cardExpMonth;
	}

	public void setCardExpMonth(String cardExpMonth) {
		this.cardExpMonth = cardExpMonth;
	}

	public boolean isCard() {
		return (this instanceof CreditCardTransaction) || (this instanceof DebitCardTransaction);
	}

	public void addProperty(String name, String value) {
		if (getProperties() == null) {
			setProperties(new HashMap<String, String>());
		}

		getProperties().put(name, value);
	}

	public boolean hasProperty(String key) {
		return getProperty(key) != null;
	}

	public String getProperty(String key) {
		if (getProperties() == null) {
			return null;
		}
		return getProperties().get(key);
	}
}
