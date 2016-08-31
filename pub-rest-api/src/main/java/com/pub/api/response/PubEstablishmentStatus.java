package com.pub.api.response;

import java.util.List;

import com.pub.api.mongo.entity.PubEstablishmentTables;

public class PubEstablishmentStatus {

	private String locationId;
	private boolean registered;
	private List<PubEstablishmentTables> tables;

	public List<PubEstablishmentTables> getTables() {
		return tables;
	}

	public void setTables(List<PubEstablishmentTables> tables) {
		this.tables = tables;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

}
