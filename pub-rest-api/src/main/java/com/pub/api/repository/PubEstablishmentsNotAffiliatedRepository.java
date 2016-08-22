package com.pub.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pub.api.mongo.entity.PubEstablishmentsNotAffiliated;

public interface PubEstablishmentsNotAffiliatedRepository
		extends MongoRepository<PubEstablishmentsNotAffiliated, String> {

}
