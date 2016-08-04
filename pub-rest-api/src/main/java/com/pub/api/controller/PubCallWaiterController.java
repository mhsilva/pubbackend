package com.pub.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.request.PubCallWaiter;
import com.pub.api.response.PubStatus;
import com.pub.api.service.PubCallWaiterService;
import com.pub.api.utils.PubMessageUtil;

@RestController
@RequestMapping(value = "/callwaiter")
public class PubCallWaiterController {
	public final AtomicLong idCounter = new AtomicLong();
	public static final String WAITER_CALLED_TO_TABLE = "Waiter {0} called for table {1}.";

	@Autowired
	private PubCallWaiterService pubCallWaiterService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody PubStatus callWaiter(@RequestBody PubCallWaiter callWaiter) {
		List<PubWaiter> waiters = pubCallWaiterService.callWaiter(callWaiter);
		List<String> content = new ArrayList<>();
		for (PubWaiter pubWaiter : waiters) {
			content.add(PubMessageUtil.formatMessage(WAITER_CALLED_TO_TABLE, pubWaiter.getName(),
					callWaiter.getTableNumber()));
		}
		return new PubStatus(idCounter.incrementAndGet(), content);
	}
}
