package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "TERMINAL_PRINTER")
public class TerminalPrinter {
	public static final String TERMINAL_PRINTER_ID = "terminal_printer_id";
	public static final String TERMINAL_PRINTER_NAME = "terminal_printer_name";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TERMINAL_PRINTER_ID, unique = true, nullable = false)
	private Integer terminalPrinterId;

	@Column(name = TERMINAL_PRINTER_NAME)
	private String terminalPrinterName;

	@ManyToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = VirtualPrinter.VIRTUAL_PRINTER_ID, referencedColumnName = VirtualPrinter.VIRTUAL_PRINTER_ID)
	private VirtualPrinter virtualPrinter;

	public TerminalPrinter() {

	}

	public Integer getTerminalPrinterId() {
		return terminalPrinterId;
	}

	public void setTerminalPrinterId(Integer terminalPrinterId) {
		this.terminalPrinterId = terminalPrinterId;
	}

	public String getTerminalPrinterName() {
		return terminalPrinterName;
	}

	public void setTerminalPrinterName(String terminalPrinterName) {
		this.terminalPrinterName = terminalPrinterName;
	}

	public VirtualPrinter getVirtualPrinter() {
		return virtualPrinter;
	}

	public void setVirtualPrinter(VirtualPrinter virtualPrinter) {
		this.virtualPrinter = virtualPrinter;
	}
}
