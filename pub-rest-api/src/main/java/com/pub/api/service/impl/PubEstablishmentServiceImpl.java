package com.pub.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.api.mongo.entity.PubEstablishment;
import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.repository.PubEstablishmentRepository;
import com.pub.api.service.PubEstablishmentService;
import com.pub.api.service.PubWaiterService;

@Service
public class PubEstablishmentServiceImpl implements PubEstablishmentService {

	@Autowired
	private PubEstablishmentRepository establishmentRepository;

	@Autowired
	private PubWaiterService waiterService;

	@Override
	public List<PubEstablishment> getAll() {
		return establishmentRepository.findAll();
	}

	@Override
	public PubEstablishment getByName(String name) {
		return establishmentRepository.findByName(name);
	}

	@Override
	public PubEstablishment save(PubEstablishment establishment) {
		List<PubWaiter> waiters = new ArrayList<>();
		for (PubWaiter waiter : establishment.getWaiters()) {
			PubWaiter pubWaiter = waiterService.save(waiter);
			waiters.add(pubWaiter);
		}
		establishment.setWaiters(waiters);
		return establishmentRepository.save(establishment);
	}
}