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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author toxic-pc
 *
 */
@Entity
@Table(name = "TAX_GROUP")
public class TaxGroup {
	public static final String TAX_GROUP_ID = "taxGroupId";
	public static final String TAX_GROUP_NAME = "taxGroupName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = TAX_GROUP_ID, unique = true, nullable = false)
	private Integer taxGroupId;

	@Column(name = TAX_GROUP_NAME)
	private String taxGroupName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = TAX_GROUP_ID)
	private List<Tax> tax;

	public TaxGroup() {
	}

	/**
	 * @return the tax
	 */
	public List<Tax> getTax() {
		return tax;
	}

	/**
	 * @param tax
	 *            the tax to set
	 */
	public void setTax(List<Tax> tax) {
		this.tax = tax;
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
	 * @return the taxGroupName
	 */
	public String getTaxGroupName() {
		return taxGroupName;
	}

	/**
	 * @param taxGroupName
	 *            the taxGroupName to set
	 */
	public void setTaxGroupName(String taxGroupName) {
		this.taxGroupName = taxGroupName;
	}
}
