package com.pub.api.service;

import java.util.List;

import com.pub.api.mongo.entity.PubWaiter;

public interface PubWaiterService {

	public PubWaiter save(PubWaiter waiter);

	public List<PubWaiter> getAll();

	public PubWaiter getByLogin(String login);

	public PubWaiter getById(String id);
}
