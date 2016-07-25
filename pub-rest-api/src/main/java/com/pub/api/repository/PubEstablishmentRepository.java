package com.pub.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pub.api.mongo.entity.PubEstablishment;

public interface PubEstablishmentRepository extends MongoRepository<PubEstablishment, String> {

	public PubEstablishment findByName(String name);
}
