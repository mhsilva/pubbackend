package com.pub.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pub.api.mongo.entity.PubWaiter;

public interface PubWaiterRepository extends MongoRepository<PubWaiter, String> {

	public PubWaiter findByName(String name);

	public PubWaiter findByLogin(String login);
}