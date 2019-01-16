package com.soft.pos.interface_;

public interface ITicketItem {
	String getItemCode();
	
	boolean canAddCookingInstruction();
	boolean canAddDiscount();
	boolean canVoid();
	boolean canAddAdOn();
	
	Boolean isPrintedToKitchen();
	
	String getNameDisplay();

	Double getUnitPriceDisplay();

	String getItemQuantityDisplay();

	Double getTaxAmountWithoutModifiersDisplay();

	Double getTotalAmountWithoutModifiersDisplay();
	
	Double getSubTotalAmountDisplay();

	Double getSubTotalAmountWithoutModifiersDisplay();
	
	void setDiscountAmount(Double amount);
	Double getDiscountAmount();
	
	String getKitchenStatus();
}
