package com.pub.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.api.gcm.PubGcmRestService;
import com.pub.api.mongo.entity.PubEstablishment;
import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.request.PubCallWaiter;
import com.pub.api.service.PubCallWaiterService;
import com.pub.api.service.PubEstablishmentService;
import com.pub.api.service.PubWaiterService;
import com.pub.api.utils.PubMessageUtil;
import com.pub.api.utils.PubObjectUtil;

@Service
public class PubCallWaiterServiceImpl implements PubCallWaiterService {

	public static final String TABLE_CALLED = "Table {0} called.";

	@Autowired
	private PubEstablishmentService establishmentService;

	@Autowired
	private PubWaiterService waiterService;

	@Autowired
	private PubGcmRestService gcmRestService;

	@Override
	public List<PubWaiter> callWaiter(PubCallWaiter callWaiter) {
		PubEstablishment establishment = establishmentService.getByLocationId(callWaiter.getLocationId());
		List<PubWaiter> waiters = null;
		if (!PubObjectUtil.isEmpty(establishment)) {
			waiters = establishment.getWaiters();
		}
		for (PubWaiter pubWaiter : waiters) {
			gcmRestService.sendGcmNotification(pubWaiter.getToken(),
					PubMessageUtil.formatMessage(TABLE_CALLED, callWaiter.getTableNumber()));
		}
		return waiters;
	}
}
