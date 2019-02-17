package com.resources;

public class Response {
	private String status;
	private Object data;
	private int totalCount;

	public Response() {
	}

	public Response(String status, Object data, int totalCount) {
		this.status = status;
		this.data = data;
		this.totalCount = totalCount;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
