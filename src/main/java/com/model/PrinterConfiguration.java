package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRINT_CONFIGURATION")
public class PrinterConfiguration {
	public final static String PRINT_CONFIGURATION_ID = "print_configuration_id";
	public final static String PRINT_CONFIGURATION_RECEIPT_PRINTER = "print_configuration_receipt_printer";
	public final static String PRINT_CONFIGURATION_WRTS = "print_configuration_wrts";
	public final static String PRINT_CONFIGURATION_WKTP = "print_configuration_wktp";
	public final static String PRINT_CONFIGURATION_UNPFT = "print_configuration_unpft";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PRINT_CONFIGURATION_ID, unique = true, nullable = false)
	private Integer printConfigurationId;

	@Column(name = PRINT_CONFIGURATION_RECEIPT_PRINTER)
	private boolean printConfigurationReceiptPrinter;

	@Column(name = PRINT_CONFIGURATION_WRTS)
	private boolean printConfigurationWrts;

	@Column(name = PRINT_CONFIGURATION_WKTP)
	private boolean printConfigurationWktp;

	@Column(name = PRINT_CONFIGURATION_UNPFT)
	private boolean printConfigurationUnfpt;

	public PrinterConfiguration() {
	}

	public Integer getPrintConfigurationId() {
		return printConfigurationId;
	}

	public void setPrintConfigurationId(Integer printConfigurationId) {
		this.printConfigurationId = printConfigurationId;
	}

	public boolean isPrintConfigurationReceiptPrinter() {
		return printConfigurationReceiptPrinter;
	}

	public void setPrintConfigurationReceiptPrinter(boolean printConfigurationReceiptPrinter) {
		this.printConfigurationReceiptPrinter = printConfigurationReceiptPrinter;
	}

	public boolean isPrintConfigurationWrts() {
		return printConfigurationWrts;
	}

	public void setPrintConfigurationWrts(boolean printConfigurationWrts) {
		this.printConfigurationWrts = printConfigurationWrts;
	}

	public boolean isPrintConfigurationWktp() {
		return printConfigurationWktp;
	}

	public void setPrintConfigurationWktp(boolean printConfigurationWktp) {
		this.printConfigurationWktp = printConfigurationWktp;
	}

	public boolean isPrintConfigurationUnfpt() {
		return printConfigurationUnfpt;
	}

	public void setPrintConfigurationUnfpt(boolean printConfigurationUnfpt) {
		this.printConfigurationUnfpt = printConfigurationUnfpt;
	}
}
