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

import java.util.Date;

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
@Table(name = "SHIFT")
public class Shift {
	public static final String SHIFT_ID = "shiftId";
	public static final String SHIFT_NAME = "shiftName";
	public static final String SHIFT_START_TIME = "shiftStartTime";
	public static final String SHIFT_END_TIME = "shiftEndTime";
	public static final String SHIFT_LEN = "shiftLen";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = SHIFT_ID, unique = true, nullable = false)
	private Integer shiftId;

	@Column(name = SHIFT_NAME)
	private String shiftName;

	@Column(name = SHIFT_START_TIME)
	private Date shiftStartTime;

	@Column(name = SHIFT_END_TIME)
	private Date shiftEndTime;

	@Column(name = SHIFT_LEN)
	private Long shiftLen;

	public Shift() {

	}

	/**
	 * @return the shiftId
	 */
	public Integer getShiftId() {
		return shiftId;
	}

	/**
	 * @param shiftId the shiftId to set
	 */
	public void setShiftId(Integer shiftId) {
		this.shiftId = shiftId;
	}

	/**
	 * @return the shiftName
	 */
	public String getShiftName() {
		return shiftName;
	}

	/**
	 * @param shiftName the shiftName to set
	 */
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	/**
	 * @return the shiftStartTime
	 */
	public Date getShiftStartTime() {
		return shiftStartTime;
	}

	/**
	 * @param shiftStartTime the shiftStartTime to set
	 */
	public void setShiftStartTime(Date shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}

	/**
	 * @return the shiftEndTime
	 */
	public Date getShiftEndTime() {
		return shiftEndTime;
	}

	/**
	 * @param shiftEndTime the shiftEndTime to set
	 */
	public void setShiftEndTime(Date shiftEndTime) {
		this.shiftEndTime = shiftEndTime;
	}

	/**
	 * @return the shiftLen
	 */
	public Long getShiftLen() {
		return shiftLen;
	}

	/**
	 * @param shiftLen the shiftLen to set
	 */
	public void setShiftLen(Long shiftLen) {
		this.shiftLen = shiftLen;
	}
}
