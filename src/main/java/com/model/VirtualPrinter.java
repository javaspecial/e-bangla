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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "VIRTUAL_PRINTER")
public class VirtualPrinter {

	public final static int REPORT = 0;
	public final static int RECEIPT = 1;
	public final static int KITCHEN = 2;
	public final static int PACKING = 3;
	public final static int KITCHEN_DISPLAY = 4;

	public static final String VIRTUAL_PRINTER_ID = "virtualPrinterId";
	public static final String VIRTUAL_PRINTER_NAME = "virtualPrinterName";
	public static final String VIRTUAL_PRINTER_TYPE = "virtualPrinterType";
	public static final String VIRTUAL_PRINTER_ENABLED = "virtualPrinterEnabled";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = VIRTUAL_PRINTER_ID, unique = true, nullable = false)
	private Integer virtualPrinterId;

	@Column(name = VIRTUAL_PRINTER_NAME)
	private String virtualPrinterName;

	@Column(name = VIRTUAL_PRINTER_TYPE)
	private Integer virtualPrinterType;

	@Column(name = VIRTUAL_PRINTER_ENABLED)
	private String virtualPrinterEnabled;

	public VirtualPrinter() {
	}

	public VirtualPrinter(int number, String printerName) {
	}

	/**
	 * @return the virtualPrinterId
	 */
	public Integer getVirtualPrinterId() {
		return virtualPrinterId;
	}

	/**
	 * @param virtualPrinterId
	 *            the virtualPrinterId to set
	 */
	public void setVirtualPrinterId(Integer virtualPrinterId) {
		this.virtualPrinterId = virtualPrinterId;
	}

	/**
	 * @return the virtualPrinterName
	 */
	public String getVirtualPrinterName() {
		return virtualPrinterName;
	}

	/**
	 * @param virtualPrinterName
	 *            the virtualPrinterName to set
	 */
	public void setVirtualPrinterName(String virtualPrinterName) {
		this.virtualPrinterName = virtualPrinterName;
	}

	/**
	 * @return the virtualPrinterType
	 */
	public Integer getVirtualPrinterType() {
		return virtualPrinterType == null ? Integer.valueOf(0) : virtualPrinterType;
	}

	/**
	 * @param virtualPrinterType
	 *            the virtualPrinterType to set
	 */
	public void setVirtualPrinterType(Integer virtualPrinterType) {
		this.virtualPrinterType = virtualPrinterType;
	}

	/**
	 * @return the virtualPrinterEnabled
	 */
	public String getVirtualPrinterEnabled() {
		return virtualPrinterEnabled;
	}

	/**
	 * @param virtualPrinterEnabled
	 *            the virtualPrinterEnabled to set
	 */
	public void setVirtualPrinterEnabled(String virtualPrinterEnabled) {
		this.virtualPrinterEnabled = virtualPrinterEnabled;
	}
}
