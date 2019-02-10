package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOID_REASON")
public class VoidReason {
	public final static String VOID_REASON_ID = "void_reason_id";
	public final static String VOID_REASON_TEXT = "void_reason_text";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = VOID_REASON_ID, unique = true, nullable = false)
	private Integer voidReasonId;

	@Column(name = VOID_REASON_TEXT)
	private String voidReasonText;

	public VoidReason() {

	}
	public Integer getVoidReasonId() {
		return voidReasonId;
	}

	public void setVoidReasonId(Integer voidReasonId) {
		this.voidReasonId = voidReasonId;
	}

	public String getVoidReasonText() {
		return voidReasonText;
	}

	public void setVoidReasonText(String voidReasonText) {
		this.voidReasonText = voidReasonText;
	}
}
