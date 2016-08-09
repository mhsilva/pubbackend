package com.pub.api.service;

import com.pub.api.request.PubCallWaiter;
import com.pub.api.response.PubStatus;

public interface PubCallWaiterService {

	public PubStatus callWaiter(PubCallWaiter callWaiter);
}
