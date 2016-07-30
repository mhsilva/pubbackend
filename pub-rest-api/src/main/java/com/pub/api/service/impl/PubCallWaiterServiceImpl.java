package com.pub.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.api.mongo.entity.PubEstablishment;
import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.service.PubCallWaiterService;
import com.pub.api.service.PubEstablishmentService;
import com.pub.api.service.PubWaiterService;
import com.pub.api.utils.PubObjectUtil;

@Service
public class PubCallWaiterServiceImpl implements PubCallWaiterService {

	@Autowired
	private PubEstablishmentService establishmentService;

	@Autowired
	private PubWaiterService waiterService;

	@Override
	public List<PubWaiter> callWaiter(String locationId) {
		PubEstablishment establishment = establishmentService.getByLocationId(locationId);
		List<PubWaiter> waiters = null;
		if (!PubObjectUtil.isEmpty(establishment)) {
			waiters = establishment.getWaiters();
		}
		// Call the waiters.
		return waiters;
	}
}
