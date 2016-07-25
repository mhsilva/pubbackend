package com.pub.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pub.api.mongo.entity.PubEstablishment;

public interface PubEstablishmentRepository extends MongoRepository<PubEstablishment, String> {

	public List<PubEstablishment> findByName(String name);

}
