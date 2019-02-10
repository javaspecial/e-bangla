package com.basemodel;

import java.util.List;

import org.springframework.format.Printer;

import com.model.OrderType;
import com.model.PrinterGroup;
import com.model.Ticket;
import com.model.TicketItemDiscount;
import com.model.TicketItemModifier;

public class BaseTicketItem {

	public BaseTicketItem() {
	}

	private Ticket ticket;
	private PrinterGroup printerGroup;

	private java.util.List<TicketItemModifier> ticketItemModifiers;
	private java.util.List<TicketItemModifier> addOns;
	private java.util.List<TicketItemDiscount> discounts;

	/**
	 * Return the value associated with the column: TICKET_ID
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * Set the value related to the column: TICKET_ID
	 * 
	 * @param ticket
	 *            the TICKET_ID value
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * Return the value associated with the column: PG_ID
	 */
	public PrinterGroup getPrinterGroup() {
		return printerGroup;
	}

	/**
	 * Set the value related to the column: PG_ID
	 * 
	 * @param printerGroup
	 *            the PG_ID value
	 */
	public void setPrinterGroup(PrinterGroup printerGroup) {
		this.printerGroup = printerGroup;
	}

	/**
	 * Return the value associated with the column: ticketItemModifiers
	 */
	public java.util.List<TicketItemModifier> getTicketItemModifiers() {
		return ticketItemModifiers;
	}

	/**
	 * Set the value related to the column: ticketItemModifiers
	 * 
	 * @param ticketItemModifiers
	 *            the ticketItemModifiers value
	 */
	public void setTicketItemModifiers(java.util.List<TicketItemModifier> ticketItemModifiers) {
		this.ticketItemModifiers = ticketItemModifiers;
	}

	public void addToticketItemModifiers(TicketItemModifier ticketItemModifier) {
		if (null == getTicketItemModifiers())
			setTicketItemModifiers(new java.util.ArrayList<TicketItemModifier>());
		getTicketItemModifiers().add(ticketItemModifier);
	}

	/**
	 * Return the value associated with the column: addOns
	 */
	public java.util.List<TicketItemModifier> getAddOns() {
		return addOns;
	}

	/**
	 * Set the value related to the column: addOns
	 * 
	 * @param addOns
	 *            the addOns value
	 */
	public void setAddOns(java.util.List<TicketItemModifier> addOns) {
		this.addOns = addOns;
	}

	public void addToaddOns(TicketItemModifier ticketItemModifier) {
		if (null == getAddOns())
			setAddOns(new java.util.ArrayList<TicketItemModifier>());
		getAddOns().add(ticketItemModifier);
	}

	/**
	 * Return the value associated with the column: discounts
	 */
	public java.util.List<TicketItemDiscount> getDiscounts() {
		return discounts;
	}

	/**
	 * Set the value related to the column: discounts
	 * 
	 * @param discounts
	 *            the discounts value
	 */
	public void setDiscounts(java.util.List<TicketItemDiscount> discounts) {
		this.discounts = discounts;
	}

	public void addTodiscounts(TicketItemDiscount ticketItemDiscount) {
		if (null == getDiscounts())
			setDiscounts(new java.util.ArrayList<TicketItemDiscount>());
		getDiscounts().add(ticketItemDiscount);
	}

	public List<Printer> getPrinters(OrderType orderType) {
		// PosPrinters printers = PosPrinters.load();
		// PrinterGroup printerGroup = getPrinterGroup();
		//
		// List<Printer> printerAll = new ArrayList<Printer>();
		//
		// if (printerGroup == null) {
		// printerAll.add(printers.getDefaultKitchenPrinter());
		// return printerAll;
		// }
		//
		// List<String> printerNames = printerGroup.getPrinterNames();
		// List<Printer> kitchenPrinters = printers.getKitchenPrinters();
		// for (Printer printer : kitchenPrinters) {
		// if
		// (printerNames.contains(printer.getVirtualPrinter().getVirtualPrinterName()))
		// {
		// printerAll.add(printer);
		// }
		// }
		// return printerAll;
		return null; // test purpose
	}

}