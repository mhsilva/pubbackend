package com.pub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.api.request.PubCallWaiter;
import com.pub.api.response.PubStatus;
import com.pub.api.service.PubCallWaiterService;

@RestController
@RequestMapping(value = "/callwaiter")
public class PubCallWaiterController {

	@Autowired
	private PubCallWaiterService pubCallWaiterService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody PubStatus callWaiter(@RequestBody PubCallWaiter callWaiter) {
		return pubCallWaiterService.callWaiter(callWaiter);
	}
}
