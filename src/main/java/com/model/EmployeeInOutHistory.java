package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_IN_OUT_HISTORY")
public class EmployeeInOutHistory {
	public final static String EMPLOYEE_IN_OUT_HISTORY_ID = "employee_in_out_history_id";
	public final static String EMPLOYEE_IN_OUT_HISTORY_OUT_TIME = "employee_in_out_history_out_time";
	public final static String EMPLOYEE_IN_OUT_HISTORY_IN_TIME = "employee_in_out_history_in_time";
	public final static String EMPLOYEE_IN_OUT_HISTORY_OUT_HOUR = "employee_in_out_history_out_hour";
	public final static String EMPLOYEE_IN_OUT_HISTORY_IN_HOUR = "employee_in_out_history_in_hour";
	public final static String EMPLOYEE_IN_OUT_HISTORY_CLOCK_OUT = "employee_in_out_history_clock_out";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = EMPLOYEE_IN_OUT_HISTORY_ID, unique = true, nullable = false)
	private Integer imployeeInOutHistoryId;

	@Column(name = EMPLOYEE_IN_OUT_HISTORY_OUT_TIME)
	private Date imployeeInOutHistoryOutTime;

	@Column(name = EMPLOYEE_IN_OUT_HISTORY_IN_TIME)
	private Date imployeeInOutHistoryInTime;

	@Column(name = EMPLOYEE_IN_OUT_HISTORY_OUT_HOUR)
	private Short imployeeInOutHistoryOutHour;

	@Column(name = EMPLOYEE_IN_OUT_HISTORY_IN_HOUR)
	private Short imployeeInOutHistoryInHour;

	@Column(name = EMPLOYEE_IN_OUT_HISTORY_CLOCK_OUT)
	private boolean imployeeInOutHistoryClockOut;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Shift.SHIFT_ID, referencedColumnName = Shift.SHIFT_ID)
	private Shift shift;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = User.USER_ID, referencedColumnName = User.USER_ID)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Terminal.TERMINAL_ID, referencedColumnName = Terminal.TERMINAL_ID)
	private Terminal terminal;

	public EmployeeInOutHistory() {
	}

	public Integer getImployeeInOutHistoryId() {
		return imployeeInOutHistoryId;
	}

	public void setImployeeInOutHistoryId(Integer imployeeInOutHistoryId) {
		this.imployeeInOutHistoryId = imployeeInOutHistoryId;
	}

	public Date getImployeeInOutHistoryOutTime() {
		return imployeeInOutHistoryOutTime;
	}

	public void setImployeeInOutHistoryOutTime(Date imployeeInOutHistoryOutTime) {
		this.imployeeInOutHistoryOutTime = imployeeInOutHistoryOutTime;
	}

	public Date getImployeeInOutHistoryInTime() {
		return imployeeInOutHistoryInTime;
	}

	public void setImployeeInOutHistoryInTime(Date imployeeInOutHistoryInTime) {
		this.imployeeInOutHistoryInTime = imployeeInOutHistoryInTime;
	}

	public Short getImployeeInOutHistoryOutHour() {
		return imployeeInOutHistoryOutHour;
	}

	public void setImployeeInOutHistoryOutHour(Short imployeeInOutHistoryOutHour) {
		this.imployeeInOutHistoryOutHour = imployeeInOutHistoryOutHour;
	}

	public Short getImployeeInOutHistoryInHour() {
		return imployeeInOutHistoryInHour;
	}

	public void setImployeeInOutHistoryInHour(Short imployeeInOutHistoryInHour) {
		this.imployeeInOutHistoryInHour = imployeeInOutHistoryInHour;
	}

	public boolean isImployeeInOutHistoryClockOut() {
		return imployeeInOutHistoryClockOut;
	}

	public void setImployeeInOutHistoryClockOut(boolean imployeeInOutHistoryClockOut) {
		this.imployeeInOutHistoryClockOut = imployeeInOutHistoryClockOut;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
}
