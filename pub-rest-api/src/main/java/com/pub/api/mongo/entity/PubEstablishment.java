package com.pub.api.mongo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "establishments")
public class PubEstablishment {

	@Id
	private String id;

	private String name;
	private String locationId;

	@DBRef
	private List<PubWaiter> waiters;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public List<PubWaiter> getWaiters() {
		return waiters;
	}

	public void setWaiters(List<PubWaiter> waiters) {
		this.waiters = waiters;
	}
}
