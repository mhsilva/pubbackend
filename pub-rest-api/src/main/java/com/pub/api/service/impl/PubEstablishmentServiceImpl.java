package com.pub.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.api.mongo.entity.PubEstablishment;
import com.pub.api.repository.PubEstablishmentRepository;
import com.pub.api.service.PubEstablishmentService;

@Service
public class PubEstablishmentServiceImpl implements PubEstablishmentService {

	@Autowired
	private PubEstablishmentRepository establishmentRepository;

	public List<PubEstablishment> getAll() {
		return establishmentRepository.findAll();
	}

	public PubEstablishment getByName(String name) {
		return establishmentRepository.findByName(name);
	}

}
