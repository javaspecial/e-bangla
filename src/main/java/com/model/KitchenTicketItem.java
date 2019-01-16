package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "KITCHEN_TICKET_ITEM")
public class KitchenTicketItem {
	public final static String PROP_ID = "itemId";
	public final static String PROP_COOKABLE = "isCookable";
	public final static String PROP_MODIFIER_ID = "modifierId";
	public final static String PROP_MENU_ITEM_CODE = "menuItemCode";
	public final static String PROP_MENU_ITEM_NAME = "menuItemName";
	public final static String PROP_MENU_ITEM_GROUP_ID = "menuItemGroupId";
	public final static String PROP_MENU_ITEM_GROUP_NAME = "menuItemGroupName";
	public final static String PROP_QUANTITY = "quantity";
	public final static String PROP_FRACTIONAL_QUANTITY = "fractionalQuantity";
	public final static String PROP_FRACTIONAL_UNIT = "fractionalUnit";
	public final static String PROP_UNIT_NAME = "unitName";
	public final static String PROP_SORT_ORDER = "sortOrder";
	public final static String PROP_VOIDED = "voided";
	public final static String PROP_STATUS = "status";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PROP_ID, unique = true, nullable = false)
	private Integer itemId;

	@Column(name = KitchenTicket.KITCHEN_TICKET_ID)
	private Integer kitchenTicketId;

	@Column(name = PROP_COOKABLE)
	private boolean isCookable;

	@Column(name = PROP_MODIFIER_ID)
	private Integer modifierId;

	@Column(name = PROP_MENU_ITEM_CODE)
	private String menuItemCode;

	@Column(name = PROP_MENU_ITEM_NAME)
	private String menuItemName;

	@Column(name = PROP_MENU_ITEM_GROUP_ID)
	private Integer menuItemGroupId;

	@Column(name = PROP_MENU_ITEM_GROUP_NAME)
	private String menuItemGroupName;

	@Column(name = PROP_QUANTITY)
	private Integer quantity;

	@Column(name = PROP_FRACTIONAL_QUANTITY)
	private double fractionalQuantity;

	@Column(name = PROP_FRACTIONAL_UNIT)
	private boolean fractionalUnit;

	@Column(name = PROP_UNIT_NAME)
	private String unitName;

	@Column(name = PROP_SORT_ORDER)
	private Integer sortOrder;

	@Column(name = PROP_VOIDED)
	private boolean voided;

	@Column(name = PROP_STATUS)
	private String status;

	public KitchenTicketItem() {
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getKitchenTicketId() {
		return kitchenTicketId;
	}

	public void setKitchenTicketId(Integer kitchenTicketId) {
		this.kitchenTicketId = kitchenTicketId;
	}

	public boolean isCookable() {
		return isCookable;
	}

	public void setCookable(boolean isCookable) {
		this.isCookable = isCookable;
	}

	public Integer getModifierId() {
		return modifierId;
	}

	public void setModifierId(Integer modifierId) {
		this.modifierId = modifierId;
	}

	public String getMenuItemCode() {
		return menuItemCode;
	}

	public void setMenuItemCode(String menuItemCode) {
		this.menuItemCode = menuItemCode;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public Integer getMenuItemGroupId() {
		return menuItemGroupId;
	}

	public void setMenuItemGroupId(Integer menuItemGroupId) {
		this.menuItemGroupId = menuItemGroupId;
	}

	public String getMenuItemGroupName() {
		return menuItemGroupName;
	}

	public void setMenuItemGroupName(String menuItemGroupName) {
		this.menuItemGroupName = menuItemGroupName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getFractionalQuantity() {
		return fractionalQuantity;
	}

	public void setFractionalQuantity(double fractionalQuantity) {
		this.fractionalQuantity = fractionalQuantity;
	}

	public boolean isFractionalUnit() {
		return fractionalUnit;
	}

	public void setFractionalUnit(boolean fractionalUnit) {
		this.fractionalUnit = fractionalUnit;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public boolean isVoided() {
		return voided;
	}

	public void setVoided(boolean voided) {
		this.voided = voided;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}