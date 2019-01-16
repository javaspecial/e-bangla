package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDER_TYPES")
public class OrderType {
	public final static String PROP_ID = "Id";
	public final static String PROP_NAME = "Name";
	public final static String PROP_TICKET_CREATED_DATE = "ticketCreateDate";
	public final static String PROP_IS_ENABLED = "isEnabled";
	public final static String PROP_IS_TABLE_SELECTION = "isTbleSelection";
	public final static String PROP_IS_GUEST_SELECTION = "isGuestSelection";
	public final static String PROP_IS_PRINT_TO_KITCHEN = "isPrintToKitchen";
	public final static String PROP_IS_PREPAID = "isPrepaid";
	public final static String PROP_IS_CLOSE_ON_PAID = "isClosedOnPaid";
	public final static String PROP_IS_REQUIRED_CUSTOMER_DATA = "isRequiredCustomerData";
	public final static String PROP_IS_DELIVERY = "isDelivery";
	public final static String PROP_IS_SHOW_ITEM_BARCODE = "isShowItemBarcode";
	public final static String PROP_IS_SHOW_IN_LOGIN_SCREEN = "isShowInLoginScreen";
	public final static String PROP_IS_HIDE_ITEM_WITH_EMPTY_INVENTORY = "isHideItem";
	public final static String PROP_IS_PRE_AUTH_CREDIT_CARD = "isPreAuthCreditCard";
	public final static String PROP_IS_SHOW_STOCK_COUNT_ON_BUTTON = "isShowStockCountOnButton";
	public final static String PROP_IS_SHOW_UNIT_PRICE_IN_TICKET_GRID = "isShowUnitPriceInTicketGrid";
	public final static String PROP_IS_ALLOW_SEAT_BASED_ORDER = "isAllowSeatBasedOrder";
	public final static String PROP_IS_SHOW_PRICE_ON_BUTTON = "showPriceOnButton";
	public final static String ORDER_TYPE_MENUITEM = "menuItem";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PROP_ID, unique = true, nullable = false)
	private Integer Id;

	@Column(name = PROP_NAME)
	private String Name;

	@Column(name = PROP_TICKET_CREATED_DATE)
	private boolean ticketCreateDate;

	@Column(name = PROP_IS_TABLE_SELECTION)
	private boolean isTbleSelection;

	@Column(name = PROP_IS_GUEST_SELECTION)
	private boolean isPrintToKitchen;

	@Column(name = PROP_IS_PRINT_TO_KITCHEN)
	private boolean isGuestSelection;

	@Column(name = PROP_IS_PREPAID)
	private boolean isPrepaid;

	@Column(name = PROP_IS_CLOSE_ON_PAID)
	private boolean isClosedOnPaid;

	@Column(name = PROP_IS_REQUIRED_CUSTOMER_DATA)
	private Boolean isRequiredCustomerData;

	@Column(name = PROP_IS_DELIVERY)
	private boolean isDelivery;

	@Column(name = PROP_IS_SHOW_ITEM_BARCODE)
	private boolean isShowItemBarcode;

	@Column(name = PROP_IS_SHOW_IN_LOGIN_SCREEN)
	private boolean isShowInLoginScreen;

	@Column(name = PROP_IS_HIDE_ITEM_WITH_EMPTY_INVENTORY)
	private boolean isHideItem;

	@Column(name = PROP_IS_PRE_AUTH_CREDIT_CARD)
	private boolean isPreAuthCreditCard;

	@Column(name = PROP_IS_SHOW_STOCK_COUNT_ON_BUTTON)
	private boolean isShowStockCountOnButton;

	@Column(name = PROP_IS_SHOW_UNIT_PRICE_IN_TICKET_GRID)
	private boolean isShowUnitPriceInTicketGrid;

	@Column(name = PROP_IS_ALLOW_SEAT_BASED_ORDER)
	private boolean isAllowSeatBasedOrder;

	@Column(name = PROP_IS_ENABLED)
	private boolean isEnabled;

	@Column(name = PROP_IS_SHOW_PRICE_ON_BUTTON)
	protected Boolean showPriceOnButton;

	@Transient
	protected Boolean showGuestSelection;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = ORDER_TYPE_MENUITEM, joinColumns = @JoinColumn(name = PROP_ID), inverseJoinColumns = @JoinColumn(name = MenuItem.MENU_ITEM_ID))
	private List<MenuItem> menuItem;

	public OrderType() {

	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public boolean isTicketCreateDate() {
		return ticketCreateDate;
	}

	public void setTicketCreateDate(boolean ticketCreateDate) {
		this.ticketCreateDate = ticketCreateDate;
	}

	public boolean isTbleSelection() {
		return isTbleSelection;
	}

	public void setTbleSelection(boolean isTbleSelection) {
		this.isTbleSelection = isTbleSelection;
	}

	public boolean isPrintToKitchen() {
		return isPrintToKitchen;
	}

	public void setPrintToKitchen(boolean isPrintToKitchen) {
		this.isPrintToKitchen = isPrintToKitchen;
	}

	public boolean isGuestSelection() {
		return isGuestSelection;
	}

	public void setGuestSelection(boolean isGuestSelection) {
		this.isGuestSelection = isGuestSelection;
	}

	public boolean isPrepaid() {
		return isPrepaid;
	}

	public void setPrepaid(boolean isPrepaid) {
		this.isPrepaid = isPrepaid;
	}

	public boolean isClosedOnPaid() {
		return isClosedOnPaid;
	}

	public void setClosedOnPaid(boolean isClosedOnPaid) {
		this.isClosedOnPaid = isClosedOnPaid;
	}

	public boolean isRequiredCustomerData() {
		return isRequiredCustomerData == null ? Boolean.FALSE : isRequiredCustomerData;
	}

	public void setRequiredCustomerData(boolean isRequiredCustomerData) {
		this.isRequiredCustomerData = isRequiredCustomerData;
	}

	public boolean isDelivery() {
		return isDelivery;
	}

	public void setDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}

	public boolean isShowItemBarcode() {
		return isShowItemBarcode;
	}

	public void setShowItemBarcode(boolean isShowItemBarcode) {
		this.isShowItemBarcode = isShowItemBarcode;
	}

	public boolean isShowInLoginScreen() {
		return isShowInLoginScreen;
	}

	public void setShowInLoginScreen(boolean isShowInLoginScreen) {
		this.isShowInLoginScreen = isShowInLoginScreen;
	}

	public boolean isHideItem() {
		return isHideItem;
	}

	public void setHideItem(boolean isHideItem) {
		this.isHideItem = isHideItem;
	}

	public boolean isPreAuthCreditCard() {
		return isPreAuthCreditCard;
	}

	public void setPreAuthCreditCard(boolean isPreAuthCreditCard) {
		this.isPreAuthCreditCard = isPreAuthCreditCard;
	}

	public boolean isShowStockCountOnButton() {
		return isShowStockCountOnButton;
	}

	public void setShowStockCountOnButton(boolean isShowStockCountOneButton) {
		this.isShowStockCountOnButton = isShowStockCountOneButton;
	}

	public boolean isShowUnitPriceInTicketGrid() {
		return isShowUnitPriceInTicketGrid;
	}

	public void setShowUnitPriceInTicketGrid(boolean isShowUnitPriceInTicketGrid) {
		this.isShowUnitPriceInTicketGrid = isShowUnitPriceInTicketGrid;
	}

	public boolean isAllowSeatBasedOrder() {
		return isAllowSeatBasedOrder;
	}

	public void setAllowSeatBasedOrder(boolean isAllowSeatBasedOrder) {
		this.isAllowSeatBasedOrder = isAllowSeatBasedOrder;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean isShowPriceOnButton() {
		return showPriceOnButton == null ? Boolean.FALSE : showPriceOnButton;
	}

	public void setShowPriceOnButton(Boolean showPriceOnButton) {
		this.showPriceOnButton = showPriceOnButton;
	}

	public Boolean isShowGuestSelection() {
		return showGuestSelection == null ? Boolean.FALSE : showGuestSelection;
	}

	public void setShowGuestSelection(java.lang.Boolean showGuestSelection) {
		this.showGuestSelection = showGuestSelection;
	}
}
