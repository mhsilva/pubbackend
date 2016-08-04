package com.pub.api.service;

import java.util.List;

import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.request.PubCallWaiter;

public interface PubCallWaiterService {

	public List<PubWaiter> callWaiter(PubCallWaiter callWaiter);
}
