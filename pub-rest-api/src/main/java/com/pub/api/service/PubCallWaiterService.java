package com.pub.api.service;

import java.util.List;

import com.pub.api.mongo.entity.PubWaiter;

public interface PubCallWaiterService {

	public List<PubWaiter> callWaiter(String locationId);
}
