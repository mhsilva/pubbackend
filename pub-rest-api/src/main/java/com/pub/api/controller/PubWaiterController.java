package com.pub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.service.PubWaiterService;

@RestController
@RequestMapping(value = "/waiter")
public class PubWaiterController {

	@Autowired
	private PubWaiterService pubWaiterService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<PubWaiter> getAllWaiters() {
		return pubWaiterService.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "login" })
	public @ResponseBody PubWaiter getWaiterByLogin(@RequestParam(name = "login") String login) {
		return pubWaiterService.getByLogin(login);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody PubWaiter saveWaiter(@RequestBody PubWaiter waiter) {
		return pubWaiterService.save(waiter);
	}
}
