package com.pub.api.service;

import java.util.List;

import com.pub.api.mongo.entity.PubEstablishment;

public interface PubEstablishmentService {

	public List<PubEstablishment> getAll();

	public PubEstablishment getByName(String name);

	public PubEstablishment save(PubEstablishment establishment);
}