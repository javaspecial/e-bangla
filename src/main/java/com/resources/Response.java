package com.resources;

import java.util.List;

public class Response<E> {
	private String status;
	private Object data;
	private int numRows;
	private int currentRowIndex;
	private int pageSize = 10;
	private List<E> rows;
	private Object model;
	private int startNumber = 0;
	private int endNumber;
	private int totalNumber;

	public Response() {
	}

	public Response(String status, Object data) {
		this.status = status;
		this.data = data;
	}

	public Response(String status, Object data, Object model) {
		this.status = status;
		this.data = data;
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCurrentRowIndex() {
		return currentRowIndex;
	}

	public void setCurrentRowIndex(int currentRowIndex) {
		this.currentRowIndex = currentRowIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> list) {
		this.rows = list;
	}

	public boolean hasNext() {
		return (currentRowIndex + pageSize) < numRows;
	}

	public boolean hasPrevious() {
		return currentRowIndex > 0;
	}

	public int getNextPage() {
		if (numRows == 0) {
			return 0;
		}
		return getCurrentRowIndex() + getPageSize();
	}

	public int getPreviousPage() {
		int i = getCurrentRowIndex() - getPageSize();
		if (i < 0) {
			i = 0;
		}
		return i;
	}

	public int getLastPage() {
		int totalPage = getNumRows() / getPageSize();
		return totalPage * getPageSize();
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

}
