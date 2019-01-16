package com.basemodel;

import java.io.Serializable;

import com.model.PosTransaction;

public abstract class BasePosTransaction implements Serializable {

	public static String REF = "PosTransaction"; //$NON-NLS-1$
	public static String PROP_USER = "user"; //$NON-NLS-1$
	public static String PROP_CARD_A_I_D = "cardAID"; //$NON-NLS-1$
	public static String PROP_CUSTOM_PAYMENT_FIELD_NAME = "customPaymentFieldName"; //$NON-NLS-1$
	public static String PROP_RECEPIENT = "recepient"; //$NON-NLS-1$
	public static String PROP_GIFT_CERT_CASH_BACK_AMOUNT = "giftCertCashBackAmount"; //$NON-NLS-1$
	public static String PROP_CUSTOM_PAYMENT_REF = "customPaymentRef"; //$NON-NLS-1$
	public static String PROP_TRANSACTION_TYPE = "transactionType"; //$NON-NLS-1$
	public static String PROP_AUTHORIZABLE = "authorizable"; //$NON-NLS-1$
	public static String PROP_GIFT_CERT_NUMBER = "giftCertNumber"; //$NON-NLS-1$
	public static String PROP_CARD_READER = "cardReader"; //$NON-NLS-1$
	public static String PROP_TICKET = "ticket"; //$NON-NLS-1$
	public static String PROP_CARD_EXT_DATA = "cardExtData"; //$NON-NLS-1$
	public static String PROP_CARD_A_R_Q_C = "cardARQC"; //$NON-NLS-1$
	public static String PROP_CARD_HOLDER_NAME = "cardHolderName"; //$NON-NLS-1$
	public static String PROP_CARD_MERCHANT_GATEWAY = "cardMerchantGateway"; //$NON-NLS-1$
	public static String PROP_CARD_TYPE = "cardType"; //$NON-NLS-1$
	public static String PROP_DRAWER_RESETTED = "drawerResetted"; //$NON-NLS-1$
	public static String PROP_TRANSACTION_TIME = "transactionTime"; //$NON-NLS-1$
	public static String PROP_CARD_AUTH_CODE = "cardAuthCode"; //$NON-NLS-1$
	public static String PROP_REASON = "reason"; //$NON-NLS-1$
	public static String PROP_GIFT_CERT_FACE_VALUE = "giftCertFaceValue"; //$NON-NLS-1$
	public static String PROP_CARD_NUMBER = "cardNumber"; //$NON-NLS-1$
	public static String PROP_GLOBAL_ID = "globalId"; //$NON-NLS-1$
	public static String PROP_AMOUNT = "amount"; //$NON-NLS-1$
	public static String PROP_CAPTURED = "captured"; //$NON-NLS-1$
	public static String PROP_TERMINAL = "terminal"; //$NON-NLS-1$
	public static String PROP_NOTE = "note"; //$NON-NLS-1$
	public static String PROP_CUSTOM_PAYMENT_NAME = "customPaymentName"; //$NON-NLS-1$
	public static String PROP_TIPS_EXCEED_AMOUNT = "tipsExceedAmount"; //$NON-NLS-1$
	public static String PROP_PAYMENT_TYPE = "paymentType"; //$NON-NLS-1$
	public static String PROP_TIPS_AMOUNT = "tipsAmount"; //$NON-NLS-1$
	public static String PROP_TENDER_AMOUNT = "tenderAmount"; //$NON-NLS-1$
	public static String PROP_CARD_TRANSACTION_ID = "cardTransactionId"; //$NON-NLS-1$
	public static String PROP_ID = "id"; //$NON-NLS-1$
	public static String PROP_VOIDED = "voided"; //$NON-NLS-1$
	public static String PROP_GIFT_CERT_PAID_AMOUNT = "giftCertPaidAmount"; //$NON-NLS-1$

	// constructors
	public BasePosTransaction() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePosTransaction(Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePosTransaction(Integer id, String transactionType, String paymentType) {

		this.setId(id);
		this.setTransactionType(transactionType);
		this.setPaymentType(paymentType);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	protected String globalId;
	protected java.util.Date transactionTime;
	protected Double amount;
	protected Double tipsAmount;
	protected Double tipsExceedAmount;
	protected Double tenderAmount;
	protected String transactionType;
	protected String customPaymentName;
	protected String customPaymentRef;
	protected String customPaymentFieldName;
	protected String paymentType;
	protected Boolean captured;
	protected Boolean voided;
	protected Boolean authorizable;
	protected String cardHolderName;
	protected String cardNumber;
	protected String cardAuthCode;
	protected String cardType;
	protected String cardTransactionId;
	protected String cardMerchantGateway;
	protected String cardReader;
	protected String cardAID;
	protected String cardARQC;
	protected String cardExtData;
	protected String giftCertNumber;
	protected Double giftCertFaceValue;
	protected Double giftCertPaidAmount;
	protected Double giftCertCashBackAmount;
	protected Boolean drawerResetted;
	protected String note;

	public Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: GLOBAL_ID
	 */
	public String getGlobalId() {
		return globalId;
	}

	/**
	 * Set the value related to the column: GLOBAL_ID
	 * 
	 * @param globalId
	 *            the GLOBAL_ID value
	 */
	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	/**
	 * Return the value associated with the column: TRANSACTION_TIME
	 */
	public java.util.Date getTransactionTime() {
		return transactionTime;
	}

	/**
	 * Set the value related to the column: TRANSACTION_TIME
	 * 
	 * @param transactionTime
	 *            the TRANSACTION_TIME value
	 */
	public void setTransactionTime(java.util.Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	/**
	 * Return the value associated with the column: AMOUNT
	 */
	public Double getAmount() {
		return amount == null ? Double.valueOf(0) : amount;
	}

	/**
	 * Set the value related to the column: AMOUNT
	 * 
	 * @param amount
	 *            the AMOUNT value
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Return the value associated with the column: TIPS_AMOUNT
	 */
	public Double getTipsAmount() {
		return tipsAmount == null ? Double.valueOf(0) : tipsAmount;
	}

	/**
	 * Set the value related to the column: TIPS_AMOUNT
	 * 
	 * @param tipsAmount
	 *            the TIPS_AMOUNT value
	 */
	public void setTipsAmount(Double tipsAmount) {
		this.tipsAmount = tipsAmount;
	}

	/**
	 * Return the value associated with the column: TIPS_EXCEED_AMOUNT
	 */
	public Double getTipsExceedAmount() {
		return tipsExceedAmount == null ? Double.valueOf(0) : tipsExceedAmount;
	}

	/**
	 * Set the value related to the column: TIPS_EXCEED_AMOUNT
	 * 
	 * @param tipsExceedAmount
	 *            the TIPS_EXCEED_AMOUNT value
	 */
	public void setTipsExceedAmount(Double tipsExceedAmount) {
		this.tipsExceedAmount = tipsExceedAmount;
	}

	/**
	 * Return the value associated with the column: TENDER_AMOUNT
	 */
	public Double getTenderAmount() {
		return tenderAmount == null ? Double.valueOf(0) : tenderAmount;
	}

	/**
	 * Set the value related to the column: TENDER_AMOUNT
	 * 
	 * @param tenderAmount
	 *            the TENDER_AMOUNT value
	 */
	public void setTenderAmount(Double tenderAmount) {
		this.tenderAmount = tenderAmount;
	}

	/**
	 * Return the value associated with the column: TRANSACTION_TYPE
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * Set the value related to the column: TRANSACTION_TYPE
	 * 
	 * @param transactionType
	 *            the TRANSACTION_TYPE value
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * Return the value associated with the column: CUSTOM_PAYMENT_NAME
	 */
	public String getCustomPaymentName() {
		return customPaymentName;
	}

	/**
	 * Set the value related to the column: CUSTOM_PAYMENT_NAME
	 * 
	 * @param customPaymentName
	 *            the CUSTOM_PAYMENT_NAME value
	 */
	public void setCustomPaymentName(String customPaymentName) {
		this.customPaymentName = customPaymentName;
	}

	/**
	 * Return the value associated with the column: CUSTOM_PAYMENT_REF
	 */
	public String getCustomPaymentRef() {
		return customPaymentRef;
	}

	/**
	 * Set the value related to the column: CUSTOM_PAYMENT_REF
	 * 
	 * @param customPaymentRef
	 *            the CUSTOM_PAYMENT_REF value
	 */
	public void setCustomPaymentRef(String customPaymentRef) {
		this.customPaymentRef = customPaymentRef;
	}

	/**
	 * Return the value associated with the column: CUSTOM_PAYMENT_FIELD_NAME
	 */
	public String getCustomPaymentFieldName() {
		return customPaymentFieldName;
	}

	/**
	 * Set the value related to the column: CUSTOM_PAYMENT_FIELD_NAME
	 * 
	 * @param customPaymentFieldName
	 *            the CUSTOM_PAYMENT_FIELD_NAME value
	 */
	public void setCustomPaymentFieldName(String customPaymentFieldName) {
		this.customPaymentFieldName = customPaymentFieldName;
	}

	/**
	 * Return the value associated with the column: PAYMENT_SUB_TYPE
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * Set the value related to the column: PAYMENT_SUB_TYPE
	 * 
	 * @param paymentType
	 *            the PAYMENT_SUB_TYPE value
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * Return the value associated with the column: CAPTURED
	 */
	public Boolean isCaptured() {
		return captured == null ? Boolean.FALSE : captured;
	}

	/**
	 * Set the value related to the column: CAPTURED
	 * 
	 * @param captured
	 *            the CAPTURED value
	 */
	public void setCaptured(Boolean captured) {
		this.captured = captured;
	}

	/**
	 * Return the value associated with the column: VOIDED
	 */
	public Boolean isVoided() {
		return voided == null ? Boolean.FALSE : voided;
	}

	/**
	 * Set the value related to the column: VOIDED
	 * 
	 * @param voided
	 *            the VOIDED value
	 */
	public void setVoided(Boolean voided) {
		this.voided = voided;
	}

	/**
	 * Return the value associated with the column: AUTHORIZABLE
	 */
	public Boolean isAuthorizable() {
		return authorizable == null ? Boolean.FALSE : authorizable;
	}

	/**
	 * Set the value related to the column: AUTHORIZABLE
	 * 
	 * @param authorizable
	 *            the AUTHORIZABLE value
	 */
	public void setAuthorizable(Boolean authorizable) {
		this.authorizable = authorizable;
	}

	/**
	 * Return the value associated with the column: CARD_HOLDER_NAME
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * Set the value related to the column: CARD_HOLDER_NAME
	 * 
	 * @param cardHolderName
	 *            the CARD_HOLDER_NAME value
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * Return the value associated with the column: CARD_NUMBER
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Set the value related to the column: CARD_NUMBER
	 * 
	 * @param cardNumber
	 *            the CARD_NUMBER value
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Return the value associated with the column: CARD_AUTH_CODE
	 */
	public String getCardAuthCode() {
		return cardAuthCode;
	}

	/**
	 * Set the value related to the column: CARD_AUTH_CODE
	 * 
	 * @param cardAuthCode
	 *            the CARD_AUTH_CODE value
	 */
	public void setCardAuthCode(String cardAuthCode) {
		this.cardAuthCode = cardAuthCode;
	}

	/**
	 * Return the value associated with the column: CARD_TYPE
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * Set the value related to the column: CARD_TYPE
	 * 
	 * @param cardType
	 *            the CARD_TYPE value
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * Return the value associated with the column: CARD_TRANSACTION_ID
	 */
	public String getCardTransactionId() {
		return cardTransactionId;
	}

	/**
	 * Set the value related to the column: CARD_TRANSACTION_ID
	 * 
	 * @param cardTransactionId
	 *            the CARD_TRANSACTION_ID value
	 */
	public void setCardTransactionId(String cardTransactionId) {
		this.cardTransactionId = cardTransactionId;
	}

	/**
	 * Return the value associated with the column: CARD_MERCHANT_GATEWAY
	 */
	public String getCardMerchantGateway() {
		return cardMerchantGateway;
	}

	/**
	 * Set the value related to the column: CARD_MERCHANT_GATEWAY
	 * 
	 * @param cardMerchantGateway
	 *            the CARD_MERCHANT_GATEWAY value
	 */
	public void setCardMerchantGateway(String cardMerchantGateway) {
		this.cardMerchantGateway = cardMerchantGateway;
	}

	/**
	 * Return the value associated with the column: CARD_READER
	 */
	public String getCardReader() {
		return cardReader;
	}

	/**
	 * Set the value related to the column: CARD_READER
	 * 
	 * @param cardReader
	 *            the CARD_READER value
	 */
	public void setCardReader(String cardReader) {
		this.cardReader = cardReader;
	}

	/**
	 * Return the value associated with the column: CARD_AID
	 */
	public String getCardAID() {
		return cardAID;
	}

	/**
	 * Set the value related to the column: CARD_AID
	 * 
	 * @param cardAID
	 *            the CARD_AID value
	 */
	public void setCardAID(String cardAID) {
		this.cardAID = cardAID;
	}

	/**
	 * Return the value associated with the column: CARD_ARQC
	 */
	public String getCardARQC() {
		return cardARQC;
	}

	/**
	 * Set the value related to the column: CARD_ARQC
	 * 
	 * @param cardARQC
	 *            the CARD_ARQC value
	 */
	public void setCardARQC(String cardARQC) {
		this.cardARQC = cardARQC;
	}

	/**
	 * Return the value associated with the column: CARD_EXT_DATA
	 */
	public String getCardExtData() {
		return cardExtData;
	}

	/**
	 * Set the value related to the column: CARD_EXT_DATA
	 * 
	 * @param cardExtData
	 *            the CARD_EXT_DATA value
	 */
	public void setCardExtData(String cardExtData) {
		this.cardExtData = cardExtData;
	}

	/**
	 * Return the value associated with the column: GIFT_CERT_NUMBER
	 */
	public String getGiftCertNumber() {
		return giftCertNumber;
	}

	/**
	 * Set the value related to the column: GIFT_CERT_NUMBER
	 * 
	 * @param giftCertNumber
	 *            the GIFT_CERT_NUMBER value
	 */
	public void setGiftCertNumber(String giftCertNumber) {
		this.giftCertNumber = giftCertNumber;
	}

	/**
	 * Return the value associated with the column: GIFT_CERT_FACE_VALUE
	 */
	public Double getGiftCertFaceValue() {
		return giftCertFaceValue == null ? Double.valueOf(0) : giftCertFaceValue;
	}

	/**
	 * Set the value related to the column: GIFT_CERT_FACE_VALUE
	 * 
	 * @param giftCertFaceValue
	 *            the GIFT_CERT_FACE_VALUE value
	 */
	public void setGiftCertFaceValue(Double giftCertFaceValue) {
		this.giftCertFaceValue = giftCertFaceValue;
	}

	/**
	 * Return the value associated with the column: GIFT_CERT_PAID_AMOUNT
	 */
	public Double getGiftCertPaidAmount() {
		return giftCertPaidAmount == null ? Double.valueOf(0) : giftCertPaidAmount;
	}

	/**
	 * Set the value related to the column: GIFT_CERT_PAID_AMOUNT
	 * 
	 * @param giftCertPaidAmount
	 *            the GIFT_CERT_PAID_AMOUNT value
	 */
	public void setGiftCertPaidAmount(Double giftCertPaidAmount) {
		this.giftCertPaidAmount = giftCertPaidAmount;
	}

	/**
	 * Return the value associated with the column: GIFT_CERT_CASH_BACK_AMOUNT
	 */
	public Double getGiftCertCashBackAmount() {
		return giftCertCashBackAmount == null ? Double.valueOf(0) : giftCertCashBackAmount;
	}

	/**
	 * Set the value related to the column: GIFT_CERT_CASH_BACK_AMOUNT
	 * 
	 * @param giftCertCashBackAmount
	 *            the GIFT_CERT_CASH_BACK_AMOUNT value
	 */
	public void setGiftCertCashBackAmount(Double giftCertCashBackAmount) {
		this.giftCertCashBackAmount = giftCertCashBackAmount;
	}

	/**
	 * Return the value associated with the column: DRAWER_RESETTED
	 */
	public Boolean isDrawerResetted() {
		return drawerResetted == null ? Boolean.FALSE : drawerResetted;
	}

	/**
	 * Set the value related to the column: DRAWER_RESETTED
	 * 
	 * @param drawerResetted
	 *            the DRAWER_RESETTED value
	 */
	public void setDrawerResetted(Boolean drawerResetted) {
		this.drawerResetted = drawerResetted;
	}

	/**
	 * Return the value associated with the column: NOTE
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Set the value related to the column: NOTE
	 * 
	 * @param note
	 *            the NOTE value
	 */
	public void setNote(String note) {
		this.note = note;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof PosTransaction))
			return false;
		else {
			PosTransaction posTransaction = (PosTransaction) obj;
			if (null == this.getId() || null == posTransaction.getId())
				return false;
			else
				return (this.getId().equals(posTransaction.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode())
			return 1;
		else if (obj.hashCode() < hashCode())
			return -1;
		else
			return 0;
	}

	public String toString() {
		return super.toString();
	}

}