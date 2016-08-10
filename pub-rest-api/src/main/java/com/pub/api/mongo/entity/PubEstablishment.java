package com.pub.api.mongo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pub.api.utils.PubObjectUtil;

@Document(collection = "establishments")
public class PubEstablishment {

	@Id
	private String id;

	private String name;
	private String locationId;

	@DBRef
	private List<PubWaiter> waiters;

	private Set<PubTableQueue> tableQueue;

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

	public Set<PubTableQueue> getTableQueue() {
		return tableQueue;
	}

	public void setTableQueue(Set<PubTableQueue> tableQueue) {
		this.tableQueue = tableQueue;
	}

	public void addCall(PubTableQueue pubTableQueue) {
		if (PubObjectUtil.isEmpty(this.tableQueue)) {
			this.tableQueue = new HashSet<>();
		}
		this.tableQueue.add(pubTableQueue);
	}
}
