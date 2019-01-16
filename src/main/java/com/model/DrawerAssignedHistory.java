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
@Table(name = "DRAWER_ASSIGNED_HISTORY")
public class DrawerAssignedHistory {
	public static final String DRAWER_ASSIGNED_HISTORY_ID = "drawer_assigned_history_id";
	public static final String DRAWER_ASSIGNED_HISTORY_TIME = "drawer_assigned_history_time";
	public static final String DRAWER_ASSIGNED_HISTORY_OPERATION = "drawer_assigned_history_operation";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DRAWER_ASSIGNED_HISTORY_ID, unique = true, nullable = false)
	private Integer drawerAssignHistoryId;

	@Column(name = DRAWER_ASSIGNED_HISTORY_TIME)
	private Date drawerAssignedHistoryTime;

	@Column(name = DRAWER_ASSIGNED_HISTORY_OPERATION)
	private String drawerAssignedHistoryOperation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = User.USER_ID, referencedColumnName = User.USER_ID)
	private User drawerAssignedUser;

	public DrawerAssignedHistory() {
	}

	public Integer getDrawerAssignHistoryId() {
		return drawerAssignHistoryId;
	}

	public void setDrawerAssignHistoryId(Integer drawerAssignHistoryId) {
		this.drawerAssignHistoryId = drawerAssignHistoryId;
	}

	public Date getDrawerAssignedHistoryTime() {
		return drawerAssignedHistoryTime;
	}

	public void setDrawerAssignedHistoryTime(Date drawerAssignedHistoryTime) {
		this.drawerAssignedHistoryTime = drawerAssignedHistoryTime;
	}

	public String getDrawerAssignedHistoryOperation() {
		return drawerAssignedHistoryOperation;
	}

	public void setDrawerAssignedHistoryOperation(String drawerAssignedHistoryOperation) {
		this.drawerAssignedHistoryOperation = drawerAssignedHistoryOperation;
	}

	public User getDrawerAssignedUser() {
		return drawerAssignedUser;
	}

	public void setDrawerAssignedUser(User drawerAssignedUser) {
		this.drawerAssignedUser = drawerAssignedUser;
	}
}
