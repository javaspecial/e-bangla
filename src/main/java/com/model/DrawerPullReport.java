package com.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "DRAWER_PULL_REPORT")
public class DrawerPullReport implements Comparable<Object>, Serializable {
	private static final long serialVersionUID = 1L;
	private int hashCode = Integer.MIN_VALUE;

	public final static String DRAWER_PULL_REPORT_ID = "drawer_pull_report_id";
	public final static String DRAWER_PULL_REPORT_TIME = "drawer_pull_report_time";
	public final static String DRAWER_PULL_REPORT_REG = "drawer_pull_report_reg";
	public final static String DRAWER_PULL_REPORT_TICKET_COUNT = "drawer_pull_report_ticket_count";
	public final static String DRAWER_PULL_REPORT_BEGIN_CASH = "drawer_pull_report_begin_cash";
	public final static String DRAWER_PULL_REPORT_NET_SALES = "drawer_pull_report_net_sales";
	public final static String DRAWER_PULL_REPORT_SALES_TAX = "drawer_pull_report_sales_tax";
	public final static String DRAWER_PULL_REPORT_CASH_TAX = "drawer_pull_report_cash_tax";
	public final static String DRAWER_PULL_REPORT_TOTAL_REVENUE = "drawer_pull_report_total_revenue";
	public final static String DRAWER_PULL_REPORT_GROSS_RECEIPTS = "drawer_pull_report_gross_receipts";
	public final static String DRAWER_PULL_REPORT_CASH_RECEIPT_NO = "drawer_pull_report_cash_receipt_no";
	public final static String DRAWER_PULL_REPORT_CASH_RECEIPT_AMOUNT = "drawer_pull_report_cash_receipt_amount";
	public final static String DRAWER_PULL_REPORT_CREDIT_CARD_RECEIPT_NO = "drawer_pull_report_credit_card_receipt_no";
	public final static String DRAWER_PULL_REPORT_CREDIT_CARD_RECEIPT_AMOUNT = "drawer_pull_report_credit_card_receipt_amount";
	public final static String DRAWER_PULL_REPORT_DEBIT_CARD_RECEIPT_NO = "drawer_pull_report_debit_card_receipt_no";
	public final static String DRAWER_PULL_REPORT_DEBIT_CARD_RECEIPT_AMOUNT = "drawer_pull_report_debit_card_receipt_amount";
	public final static String DRAWER_PULL_REPORT_REFUND_RECEIPT_COUNT = "drawer_pull_report_refund_receipt_count";
	public final static String DRAWER_PULL_REPORT_REFUND_AMOUNT = "drawer_pull_report_refund_amount";
	public final static String DRAWER_PULL_REPORT_RECEIPT_DIFFERENTIAL = "drawer_pull_report_receipt_differential";
	public final static String DRAWER_PULL_REPORT_CASH_BACK = "drawer_pull_report_cash_back";
	public final static String DRAWER_PULL_REPORT_CASH_TIPS = "drawer_pull_report_cash_tips";
	public final static String DRAWER_PULL_REPORT_CHARGED_TIPS = "drawer_pull_report_charged_tips";
	public final static String DRAWER_PULL_REPORT_TIPS_PAID = "drawer_pull_report_tips_paid";
	public final static String DRAWER_PULL_REPORT_TIPS_DIFFERENTIAL = "drawer_pull_report_tips_differential";
	public final static String DRAWER_PULL_REPORT_DRAWER_ACCOUNTABLE = "drawer_pull_report_drawer_accountable";
	public final static String DRAWER_PULL_REPORT_CASH_TO_DEPOSIT = "drawer_pull_report_cash_to_deposit";
	public final static String DRAWER_PULL_REPORT_VARIANCE = "drawer_pull_report_variance";
	public final static String DRAWER_PULLREPORT_SALES_DELIVERYCHARGE = "drawer_pullreport_sales_deliverycharge";
	public final static String DRAWER_PULLREPORT_PAYOUT_AMOUNT = "drawer_pullreport_payout_amount";
	public final static String DRAWER_PULLREPORT_PAYOUT_COUNT = "drawer_pullreport_payout_count";
	public final static String DRAWER_PULLREPORT_BLEED_AMOUNT = "drawer_pullreport_bleed_amount";
	public final static String DRAWER_PULLREPORT_BLEED_COUNT = "drawer_pullreport_bleed_count";
	public final static String DRAWER_PULLREPORT_TOTAL_VOID = "drawer_pullreport_total_void";
	public final static String DRAWER_PULL_VOID_TICKET_ENTRY = "drawer_pull_void_tickets";
	public final static String DRAWER_PULLREPORT_TOTAL_VOID_WST = "drawer_pullreport_total_void_wst";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_COUNT = "drawer_pullreport_total_discount_count";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_AMOUNT = "drawer_pullreport_total_discount_amount";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_SALES = "drawer_pullreport_total_discount_sales";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_GUEST = "drawer_pullreport_total_discount_guest";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_PARTY_SIZE = "drawer_pullreport_total_discount_party_size";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_CHECK_SIZE = "drawer_pullreport_total_discount_check_size";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_PERCENTAGE = "drawer_pullreport_total_discount_percentage";
	public final static String DRAWER_PULLREPORT_TOTAL_DISCOUNT_RATIO = "drawer_pullreport_total_discount_ratio";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DRAWER_PULL_REPORT_ID, unique = true, nullable = false)
	private Integer drawerPullReportId;

	@Column(name = DRAWER_PULL_REPORT_TIME)
	private Date drawerPullReportTime;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_COUNT)
	private Integer drawerPullReportTotalDiscountCount;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_AMOUNT)
	private double drawerPullReportTotalDiscountAmount;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_SALES)
	private double drawerPullReportTotalDiscountSales;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_GUEST)
	private Integer drawerPullReportTotalDiscountGuest;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_PARTY_SIZE)
	private Integer drawerPullReportTotalDiscountPartySize;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_CHECK_SIZE)
	private Integer drawerPullReportTotalDiscountCheckSize;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_PERCENTAGE)
	private double drawerPullReportTotalDiscountPercentage;

	@Column(name = DRAWER_PULLREPORT_TOTAL_DISCOUNT_RATIO)
	private double drawerPullReportTotalDiscountRatio;

	@Column(name = DRAWER_PULL_REPORT_REG)
	private String drawerPullReportReg;

	@Column(name = DRAWER_PULL_REPORT_TICKET_COUNT)
	private Integer drawerPullReportTicketCount;

	@Column(name = DRAWER_PULL_REPORT_BEGIN_CASH)
	private double drawerPullReportBeginCash;

	@Column(name = DRAWER_PULL_REPORT_NET_SALES)
	private double drawerPullReportNetSales;

	@Column(name = DRAWER_PULL_REPORT_SALES_TAX)
	private double drawerPullReportSalesTax;

	@Column(name = DRAWER_PULL_REPORT_CASH_TAX)
	private double drawerPullReportCashTax;

	@Column(name = DRAWER_PULL_REPORT_TOTAL_REVENUE)
	private double drawerPullReportTotalRevenue;

	@Column(name = DRAWER_PULL_REPORT_GROSS_RECEIPTS)
	private double drawerPullReportGrossReceipts;

	@Column(name = DRAWER_PULL_REPORT_CASH_RECEIPT_NO)
	private Integer drawerPullReportCashReceiptNo;

	@Column(name = DRAWER_PULL_REPORT_CASH_RECEIPT_AMOUNT)
	private double drawerPullReportCashReceiptAmount;

	@Column(name = DRAWER_PULL_REPORT_CREDIT_CARD_RECEIPT_NO)
	private Integer drawerPullReportCreditCardReceiptNo;

	@Column(name = DRAWER_PULL_REPORT_CREDIT_CARD_RECEIPT_AMOUNT)
	private double drawerPullReportCreditCardReceiptAmount;

	@Column(name = DRAWER_PULL_REPORT_DEBIT_CARD_RECEIPT_NO)
	private Integer drawerPullReportDebitCardReceiptNo;

	@Column(name = DRAWER_PULL_REPORT_DEBIT_CARD_RECEIPT_AMOUNT)
	private double drawerPullReportDebitCardReceiptAmount;

	@Column(name = DRAWER_PULL_REPORT_REFUND_RECEIPT_COUNT)
	private Integer drawerPullReportRefundReceiptCount;

	@Column(name = DRAWER_PULL_REPORT_REFUND_AMOUNT)
	private double drawerPullReportRefundAmount;

	@Column(name = DRAWER_PULL_REPORT_RECEIPT_DIFFERENTIAL)
	private double drawerPullReportReceiptDifferential;

	@Column(name = DRAWER_PULL_REPORT_CASH_BACK)
	private double drawerPullReportCashBack;

	@Column(name = DRAWER_PULL_REPORT_CASH_TIPS)
	private double drawerPullReportCashTips;

	@Column(name = DRAWER_PULL_REPORT_CHARGED_TIPS)
	private double drawerPullReportChargedTips;

	@Column(name = DRAWER_PULL_REPORT_TIPS_PAID)
	private double drawerPullReportTipsPaid;

	@Column(name = DRAWER_PULL_REPORT_TIPS_DIFFERENTIAL)
	private double drawerPullReportTipsDifferential;

	@Column(name = DRAWER_PULL_REPORT_DRAWER_ACCOUNTABLE)
	private double drawerPullReportDrawerAccountable;

	@Column(name = DRAWER_PULL_REPORT_CASH_TO_DEPOSIT)
	private double drawerPullReportCashToDeposit;

	@Column(name = DRAWER_PULL_REPORT_VARIANCE)
	private double drawerPullReportVariance;

	@Column(name = DRAWER_PULLREPORT_SALES_DELIVERYCHARGE)
	private double drawerPullReportSlesDeliveryCharge;

	@Column(name = DRAWER_PULLREPORT_PAYOUT_AMOUNT)
	private double drawerPullReportPayOutAmount;

	@Column(name = DRAWER_PULLREPORT_PAYOUT_COUNT)
	private Integer drawerPullReportPayOutCount;

	@Column(name = DRAWER_PULLREPORT_BLEED_AMOUNT)
	private double drawerPullReportBleedAmount;

	@Column(name = DRAWER_PULLREPORT_BLEED_COUNT)
	private Integer drawerPullReportBleedCount;

	@Column(name = DRAWER_PULLREPORT_TOTAL_VOID)
	private double drawerPullReportTotalVoid;

	@Column(name = DRAWER_PULLREPORT_TOTAL_VOID_WST)
	private double drawerPullReportTotalVoidWst;

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = CurrencyBalance.CURRENCY_BALANCE_ID)
	private Set<CurrencyBalance> currencyBalance;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = DRAWER_PULL_VOID_TICKET_ENTRY)
	private Set<DrawerPullVoidTicketEntry> drawerPullReportVoidTickets;

	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = Terminal.TERMINAL_ID, referencedColumnName = Terminal.TERMINAL_ID)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = User.USER_ID, referencedColumnName = User.USER_ID)
	private User assignedUser;

	@OneToOne(mappedBy = CashDrawerResetHistory.DRAWER_PULL_REPORT, cascade = CascadeType.ALL, optional = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private CashDrawerResetHistory cashDrawerResetHistory;

	public DrawerPullReport() {

	}

	public DrawerPullReport(Integer id) {
		this.setDrawerPullReportId(id);
	}

	public Integer getDrawerPullReportId() {
		return drawerPullReportId;
	}

	public Integer getDrawerPullReportTotalDiscountCount() {
		return drawerPullReportTotalDiscountCount;
	}

	public void setDrawerPullReportTotalDiscountCount(Integer drawerPullReportTotalDiscountCount) {
		this.drawerPullReportTotalDiscountCount = drawerPullReportTotalDiscountCount;
	}

	public double getDrawerPullReportTotalDiscountAmount() {
		return drawerPullReportTotalDiscountAmount;
	}

	public void setDrawerPullReportTotalDiscountAmount(double drawerPullReportTotalDiscountAmount) {
		this.drawerPullReportTotalDiscountAmount = drawerPullReportTotalDiscountAmount;
	}

	public double getDrawerPullReportTotalDiscountSales() {
		return drawerPullReportTotalDiscountSales;
	}

	public void setDrawerPullReportTotalDiscountSales(double drawerPullReportTotalDiscountSales) {
		this.drawerPullReportTotalDiscountSales = drawerPullReportTotalDiscountSales;
	}

	public Integer getDrawerPullReportTotalDiscountGuest() {
		return drawerPullReportTotalDiscountGuest;
	}

	public void setDrawerPullReportTotalDiscountGuest(Integer drawerPullReportTotalDiscountGuest) {
		this.drawerPullReportTotalDiscountGuest = drawerPullReportTotalDiscountGuest;
	}

	public Integer getDrawerPullReportTotalDiscountPartySize() {
		return drawerPullReportTotalDiscountPartySize;
	}

	public void setDrawerPullReportTotalDiscountPartySize(Integer drawerPullReportTotalDiscountPartySize) {
		this.drawerPullReportTotalDiscountPartySize = drawerPullReportTotalDiscountPartySize;
	}

	public Integer getDrawerPullReportTotalDiscountCheckSize() {
		return drawerPullReportTotalDiscountCheckSize;
	}

	public void setDrawerPullReportTotalDiscountCheckSize(Integer drawerPullReportTotalDiscountCheckSize) {
		this.drawerPullReportTotalDiscountCheckSize = drawerPullReportTotalDiscountCheckSize;
	}

	public double getDrawerPullReportTotalDiscountPercentage() {
		return drawerPullReportTotalDiscountPercentage;
	}

	public void setDrawerPullReportTotalDiscountPercentage(double drawerPullReportTotalDiscountPercentage) {
		this.drawerPullReportTotalDiscountPercentage = drawerPullReportTotalDiscountPercentage;
	}

	public double getDrawerPullReportTotalDiscountRatio() {
		return drawerPullReportTotalDiscountRatio;
	}

	public void setDrawerPullReportTotalDiscountRatio(double drawerPullReportTotalDiscountRatio) {
		this.drawerPullReportTotalDiscountRatio = drawerPullReportTotalDiscountRatio;
	}

	public Integer getDrawerPullReportPayOutCount() {
		return drawerPullReportPayOutCount;
	}

	public void setDrawerPullReportPayOutCount(Integer drawerPullReportPayOutCount) {
		this.drawerPullReportPayOutCount = drawerPullReportPayOutCount;
	}

	public void setDrawerPullReportId(Integer drawerPullReportId) {
		this.drawerPullReportId = drawerPullReportId;
	}

	public Integer getDrawerPullReportBleedCount() {
		return drawerPullReportBleedCount;
	}

	public void setDrawerPullReportBleedCount(Integer drawerPullReportBleedCount) {
		this.drawerPullReportBleedCount = drawerPullReportBleedCount;
	}

	public double getDrawerPullReportTotalVoidWst() {
		return drawerPullReportTotalVoidWst;
	}

	public void setDrawerPullReportTotalVoidWst(double drawerPullReportTotalVoidWst) {
		this.drawerPullReportTotalVoidWst = drawerPullReportTotalVoidWst;
	}

	public Date getDrawerPullReportTime() {
		return drawerPullReportTime;
	}

	public void setDrawerPullReportTime(Date drawerPullReportTime) {
		this.drawerPullReportTime = drawerPullReportTime;
	}

	public String getDrawerPullReportReg() {
		return drawerPullReportReg;
	}

	public void setDrawerPullReportReg(String drawerPullReportReg) {
		this.drawerPullReportReg = drawerPullReportReg;
	}

	public Integer getDrawerPullReportTicketCount() {
		return drawerPullReportTicketCount;
	}

	public void setDrawerPullReportTicketCount(Integer drawerPullReportTicketCount) {
		this.drawerPullReportTicketCount = drawerPullReportTicketCount;
	}

	public double getDrawerPullReportBeginCash() {
		return drawerPullReportBeginCash;
	}

	public void setDrawerPullReportBeginCash(double drawerPullReportBeginCash) {
		this.drawerPullReportBeginCash = drawerPullReportBeginCash;
	}

	public double getDrawerPullReportNetSales() {
		return drawerPullReportNetSales;
	}

	public void setDrawerPullReportNetSales(double drawerPullReportNetSales) {
		this.drawerPullReportNetSales = drawerPullReportNetSales;
	}

	public double getDrawerPullReportSalesTax() {
		return drawerPullReportSalesTax;
	}

	public void setDrawerPullReportSalesTax(double drawerPullReportSalesTax) {
		this.drawerPullReportSalesTax = drawerPullReportSalesTax;
	}

	public double getDrawerPullReportCashTax() {
		return drawerPullReportCashTax;
	}

	public void setDrawerPullReportCashTax(double drawerPullReportCashTax) {
		this.drawerPullReportCashTax = drawerPullReportCashTax;
	}

	public double getDrawerPullReportTotalRevenue() {
		return drawerPullReportTotalRevenue;
	}

	public void setDrawerPullReportTotalRevenue(double drawerPullReportTotalRevenue) {
		this.drawerPullReportTotalRevenue = drawerPullReportTotalRevenue;
	}

	public double getDrawerPullReportGrossReceipts() {
		return drawerPullReportGrossReceipts;
	}

	public void setDrawerPullReportGrossReceipts(double drawerPullReportGrossReceipts) {
		this.drawerPullReportGrossReceipts = drawerPullReportGrossReceipts;
	}

	public Integer getDrawerPullReportCashReceiptNo() {
		return drawerPullReportCashReceiptNo == null ? Integer.valueOf(0) : drawerPullReportCashReceiptNo;
	}

	public void setDrawerPullReportCashReceiptNo(Integer drawerPullReportCashReceiptNo) {
		this.drawerPullReportCashReceiptNo = drawerPullReportCashReceiptNo;
	}

	public double getDrawerPullReportCashReceiptAmount() {
		return drawerPullReportCashReceiptAmount;
	}

	public void setDrawerPullReportCashReceiptAmount(double drawerPullReportCashReceiptAmount) {
		this.drawerPullReportCashReceiptAmount = drawerPullReportCashReceiptAmount;
	}

	public Integer getDrawerPullReportCreditCardReceiptNo() {
		return drawerPullReportCreditCardReceiptNo == null ? Integer.valueOf(0) : drawerPullReportCreditCardReceiptNo;
	}

	public void setDrawerPullReportCreditCardReceiptNo(Integer drawerPullReportCreditCardReceiptNo) {
		this.drawerPullReportCreditCardReceiptNo = drawerPullReportCreditCardReceiptNo;
	}

	public double getDrawerPullReportCreditCardReceiptAmount() {
		return drawerPullReportCreditCardReceiptAmount;
	}

	public void setDrawerPullReportCreditCardReceiptAmount(double drawerPullReportCreditCardReceiptAmount) {
		this.drawerPullReportCreditCardReceiptAmount = drawerPullReportCreditCardReceiptAmount;
	}

	public Integer getDrawerPullReportDebitCardReceiptNo() {
		return drawerPullReportDebitCardReceiptNo == null ? Integer.valueOf(0) : drawerPullReportDebitCardReceiptNo;
	}

	public void setDrawerPullReportDebitCardReceiptNo(Integer drawerPullReportDebitCardReceiptNo) {
		this.drawerPullReportDebitCardReceiptNo = drawerPullReportDebitCardReceiptNo;
	}

	public double getDrawerPullReportDebitCardReceiptAmount() {
		return drawerPullReportDebitCardReceiptAmount;
	}

	public void setDrawerPullReportDebitCardReceiptAmount(double drawerPullReportDebitCardReceiptAmount) {
		this.drawerPullReportDebitCardReceiptAmount = drawerPullReportDebitCardReceiptAmount;
	}

	public Integer getDrawerPullReportRefundReceiptCount() {
		return drawerPullReportRefundReceiptCount == null ? Integer.valueOf(0) : drawerPullReportRefundReceiptCount;
	}

	public void setDrawerPullReportRefundReceiptCount(Integer drawerPullReportRefundReceiptCount) {
		this.drawerPullReportRefundReceiptCount = drawerPullReportRefundReceiptCount;
	}

	public double getDrawerPullReportRefundAmount() {
		return drawerPullReportRefundAmount;
	}

	public void setDrawerPullReportRefundAmount(double drawerPullReportRefundAmount) {
		this.drawerPullReportRefundAmount = drawerPullReportRefundAmount;
	}

	public double getDrawerPullReportReceiptDifferential() {
		return drawerPullReportReceiptDifferential;
	}

	public void setDrawerPullReportReceiptDifferential(double drawerPullReportReceiptDifferential) {
		this.drawerPullReportReceiptDifferential = drawerPullReportReceiptDifferential;
	}

	public double getDrawerPullReportCashBack() {
		return drawerPullReportCashBack;
	}

	public void setDrawerPullReportCashBack(double drawerPullReportCashBack) {
		this.drawerPullReportCashBack = drawerPullReportCashBack;
	}

	public double getDrawerPullReportCashTips() {
		return drawerPullReportCashTips;
	}

	public void setDrawerPullReportCashTips(double drawerPullReportCashTips) {
		this.drawerPullReportCashTips = drawerPullReportCashTips;
	}

	public double getDrawerPullReportChargedTips() {
		return drawerPullReportChargedTips;
	}

	public void setDrawerPullReportChargedTips(double drawerPullReportChargedTips) {
		this.drawerPullReportChargedTips = drawerPullReportChargedTips;
	}

	public double getDrawerPullReportTipsPaid() {
		return drawerPullReportTipsPaid;
	}

	public void setDrawerPullReportTipsPaid(double drawerPullReportTipsPaid) {
		this.drawerPullReportTipsPaid = drawerPullReportTipsPaid;
	}

	public double getDrawerPullReportTipsDifferential() {
		return drawerPullReportTipsDifferential;
	}

	public void setDrawerPullReportTipsDifferential(double drawerPullReportTipsDifferential) {
		this.drawerPullReportTipsDifferential = drawerPullReportTipsDifferential;
	}

	public double getDrawerPullReportDrawerAccountable() {
		return drawerPullReportDrawerAccountable;
	}

	public void setDrawerPullReportDrawerAccountable(double drawerPullReportDrawerAccountable) {
		this.drawerPullReportDrawerAccountable = drawerPullReportDrawerAccountable;
	}

	public double getDrawerPullReportCashToDeposit() {
		return drawerPullReportCashToDeposit;
	}

	public void setDrawerPullReportCashToDeposit(double drawerPullReportCashToDeposit) {
		this.drawerPullReportCashToDeposit = drawerPullReportCashToDeposit;
	}

	public double getDrawerPullReportVariance() {
		return drawerPullReportVariance;
	}

	public void setDrawerPullReportVariance(double drawerPullReportVariance) {
		this.drawerPullReportVariance = drawerPullReportVariance;
	}

	public Set<CurrencyBalance> getCurrencyBalance() {
		return currencyBalance;
	}

	public void setCurrencyBalance(Set<CurrencyBalance> currencyBalance) {
		this.currencyBalance = currencyBalance;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public CashDrawerResetHistory getCashDrawerResetHistory() {
		return cashDrawerResetHistory;
	}

	public void setCashDrawerResetHistory(CashDrawerResetHistory cashDrawerResetHistory) {
		this.cashDrawerResetHistory = cashDrawerResetHistory;
	}

	public double getDrawerPullReportSlesDeliveryCharge() {
		return drawerPullReportSlesDeliveryCharge;
	}

	public void setDrawerPullReportSlesDeliveryCharge(double drawerPullReportSlesDeliveryCharge) {
		this.drawerPullReportSlesDeliveryCharge = drawerPullReportSlesDeliveryCharge;
	}

	public double getDrawerPullReportPayOutAmount() {
		return drawerPullReportPayOutAmount;
	}

	public void setDrawerPullReportPayOutAmount(double drawerPullReportPayOutAmount) {
		this.drawerPullReportPayOutAmount = drawerPullReportPayOutAmount;
	}

	public double getDrawerPullReportBleedAmount() {
		return drawerPullReportBleedAmount;
	}

	public void setDrawerPullReportBleedAmount(double drawerPullReportBleedAmount) {
		this.drawerPullReportBleedAmount = drawerPullReportBleedAmount;
	}

	public double getDrawerPullReportTotalVoid() {
		return drawerPullReportTotalVoid;
	}

	public void setDrawerPullReportTotalVoid(double drawerPullReportTotalVoid) {
		this.drawerPullReportTotalVoid = drawerPullReportTotalVoid;
	}

	public Set<DrawerPullVoidTicketEntry> getDrawerPullReportVoidTickets() {
		return drawerPullReportVoidTickets;
	}

	public void setDrawerPullReportVoidTickets(Set<DrawerPullVoidTicketEntry> drawerPullReportVoidTickets) {
		this.drawerPullReportVoidTickets = drawerPullReportVoidTickets;
	}

	public void calculate() {
		setDrawerPullReportTotalRevenue(getDrawerPullReportNetSales() + getDrawerPullReportSalesTax()
				+ getDrawerPullReportSlesDeliveryCharge());
		setDrawerPullReportGrossReceipts(getDrawerPullReportTotalRevenue() + getDrawerPullReportChargedTips());

		double total = getDrawerPullReportCashReceiptAmount() + getDrawerPullReportCreditCardReceiptAmount()
				+ getDrawerPullReportDebitCardReceiptAmount() - getDrawerPullReportCashBack()
				- getDrawerPullReportRefundAmount();
		setDrawerPullReportReceiptDifferential(getDrawerPullReportGrossReceipts() - total);

		setDrawerPullReportTipsDifferential(getDrawerPullReportChargedTips() - getDrawerPullReportTipsPaid());

		double totalCash = getDrawerPullReportCashReceiptAmount();
		double tips = getDrawerPullReportTipsPaid();
		double totalPayout = getDrawerPullReportPayOutAmount();
		double beginCash = getDrawerPullReportBeginCash();
		double cashBack = getDrawerPullReportCashBack();
		double refundAmount = getDrawerPullReportRefundAmount();
		double drawerBleed = getDrawerPullReportBleedAmount();

		setDrawerPullReportDrawerAccountable(
				beginCash + totalCash - tips - totalPayout - cashBack - refundAmount - drawerBleed);

		Set<DrawerPullVoidTicketEntry> voidTickets = getDrawerPullReportVoidTickets();
		if (voidTickets != null) {
			double totalVoidAmount = 0;
			for (DrawerPullVoidTicketEntry entry : voidTickets) {
				totalVoidAmount += entry.getAmount();
			}
			setDrawerPullReportTotalVoid(totalVoidAmount);
		}
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof DrawerPullReport))
			return false;
		else {
			DrawerPullReport drawerPullReport = (DrawerPullReport) obj;
			if (null == this.getDrawerPullReportId() || null == drawerPullReport.getDrawerPullReportId())
				return false;
			else
				return (this.getDrawerPullReportId().equals(drawerPullReport.getDrawerPullReportId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getDrawerPullReportId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getDrawerPullReportId().hashCode();
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