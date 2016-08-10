package com.pub.api.mongo.entity;

import java.util.ArrayList;
import java.util.List;

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

	private List<PubTableQueue> tableQueue;

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

	public List<PubTableQueue> getTableQueue() {
		return tableQueue;
	}

	public void setTableQueue(List<PubTableQueue> tableQueue) {
		this.tableQueue = tableQueue;
	}

	public void addCall(PubTableQueue pubTableQueue) {
		if (PubObjectUtil.isEmpty(this.tableQueue)) {
			this.tableQueue = new ArrayList<>();
		}
		this.tableQueue.add(pubTableQueue);
		this.tableQueue = PubObjectUtil.getUniqueElemetsFromList(this.tableQueue);
	}
}
