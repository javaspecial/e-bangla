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
@Table(name = "TAX")
public class Tax {
	public static final String TAX_ID = "taxId";
	public static final String TAX_NAME = "name";
	public static final String TAX_RATE = "rate";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TAX_ID, unique = true, nullable = false)
	private Integer taxId;

	@Column(name = TAX_NAME)
	private String name;

	@Column(name = TAX_RATE)
	private double rate;

	@Column(name = TaxGroup.TAX_GROUP_ID)
	private Integer taxGroupId;

	public Tax() {
	}

	/**
	 * @return the taxGroupId
	 */
	public Integer getTaxGroupId() {
		return taxGroupId;
	}

	/**
	 * @param taxGroupId
	 *            the taxGroupId to set
	 */
	public void setTaxGroupId(Integer taxGroupId) {
		this.taxGroupId = taxGroupId;
	}

	/**
	 * @return the taxId
	 */
	public Integer getTaxId() {
		return taxId;
	}

	/**
	 * @param taxId
	 *            the taxId to set
	 */
	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	/**
	 * @return the taxName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param taxName
	 *            the taxName to set
	 */
	public void setName(String taxName) {
		this.name = taxName;
	}

	/**
	 * @return the taxRate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param taxRate
	 *            the taxRate to set
	 */
	public void setRate(double taxRate) {
		this.rate = taxRate;
	}

	public String getUniqueId() {
		return ("tax_" + getName() + "_" + getTaxId()).replaceAll("\\s+", "_");
	}
}
