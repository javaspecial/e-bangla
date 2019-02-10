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

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "PRINTER_GROUP")
public class PrinterGroup {

	public static final String PRINTER_GROUP_ID = "printerGroupId";
	public static final String PRINTER_GROUP_NAME = "printerGroupName";
	public static final String PRINTER_GROUP_IS_DEFAULT = "printerGroupIsDefault";
	public static final String PRINTER_NAMES = "printerNames";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PRINTER_GROUP_ID, unique = true, nullable = false)
	private Integer printerGroupId;

	@Column(name = PRINTER_GROUP_NAME)
	private String printerGroupName;

	@Column(name = PRINTER_GROUP_IS_DEFAULT)
	private Boolean printerGroupIsDefault;

	@ElementCollection
	@CollectionTable(name = PRINTER_NAMES, joinColumns = @JoinColumn(name = PRINTER_GROUP_ID))
	@Column(name = PRINTER_NAMES)
	private List<String> printerNames;

	public PrinterGroup() {
	}

	/**
	 * @return the printerGroupId
	 */
	public Integer getPrinterGroupId() {
		return printerGroupId;
	}

	/**
	 * @param printerGroupId
	 *            the printerGroupId to set
	 */
	public void setPrinterGroupId(Integer printerGroupId) {
		this.printerGroupId = printerGroupId;
	}

	/**
	 * @return the printerGroupName
	 */
	public String getPrinterGroupName() {
		return printerGroupName;
	}

	/**
	 * @param printerGroupName
	 *            the printerGroupName to set
	 */
	public void setPrinterGroupName(String printerGroupName) {
		this.printerGroupName = printerGroupName;
	}

	/**
	 * @return the printerGroupIsDefault
	 */
	public Boolean getPrinterGroupIsDefault() {
		return printerGroupIsDefault;
	}

	/**
	 * @param printerGroupIsDefault
	 *            the printerGroupIsDefault to set
	 */
	public void setPrinterGroupIsDefault(Boolean printerGroupIsDefault) {
		this.printerGroupIsDefault = printerGroupIsDefault;
	}

	/**
	 * Return the value associated with the column: printerNames
	 */
	public java.util.List<String> getPrinterNames() {
		return printerNames;
	}

	/**
	 * Set the value related to the column: printerNames
	 * 
	 * @param printerNames
	 *            the printerNames value
	 */
	public void setPrinterNames(java.util.List<String> printerNames) {
		this.printerNames = printerNames;
	}

}
