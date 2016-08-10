package com.pub.api.mongo.entity;

import java.util.Date;

public class PubTableQueue {

	private String call;
	private Date callDate;

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public Date getCallDate() {
		return callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((call == null) ? 0 : call.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PubTableQueue)) {
			return false;
		}
		PubTableQueue other = (PubTableQueue) obj;
		return this.call.equals(other.getCall());
	}
}
