package com.pub.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.api.entity.CallWaiter;
import com.pub.api.entity.Status;
import com.pub.api.utils.PubMessageUtil;

@RestController
@RequestMapping(value = "/callwaiter")
public class CallWaiterController {
	public final AtomicLong idCounter = new AtomicLong();
	public static final String WAITER_CALLED_TO_TABLE = "Waiter called for table {0}.";

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Status callWaiter(@RequestBody CallWaiter callWaiter) {
		return new Status(idCounter.incrementAndGet(),
				PubMessageUtil.formatMessage(WAITER_CALLED_TO_TABLE, callWaiter.getTableNumber()));
	}
}
