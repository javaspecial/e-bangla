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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.basemodel.BaseCashDrawerResetHistory;

@Entity
@Table(name = "CASH_DRAWER_RESET_HISTORY")
public class CashDrawerResetHistory extends BaseCashDrawerResetHistory {
	public final static String CASH_DRAWER_RESET_ID = "cash_drawer_reset_id";
	public final static String CASH_DRAWER_RESET_TIME = "cash_drawer_reset_time";
	public final static String DRAWER_PULL_REPORT = "drawerPullReport";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CASH_DRAWER_RESET_ID, unique = true, nullable = false)
	private Integer resetId;

	@Column(name = CASH_DRAWER_RESET_TIME)
	private Date resetTime;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = User.USER_ID, referencedColumnName = User.USER_ID)
	private User user;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = DRAWER_PULL_REPORT)
	private DrawerPullReport drawerPullReport;

	public CashDrawerResetHistory() {

	}

	public Integer getResetId() {
		return resetId;
	}

	public void setResetId(Integer resetId) {
		this.resetId = resetId;
	}

	public Date getResetTime() {
		return resetTime;
	}

	public void setResetTime(Date resetTime) {
		this.resetTime = resetTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DrawerPullReport getDrawerPullReport() {
		return drawerPullReport;
	}

	public void setDrawerPullReport(DrawerPullReport drawerPullReport) {
		this.drawerPullReport = drawerPullReport;
	}
}