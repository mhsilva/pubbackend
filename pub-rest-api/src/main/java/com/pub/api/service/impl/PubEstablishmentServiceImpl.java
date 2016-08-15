package com.pub.api.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.api.mongo.entity.PubEstablishment;
import com.pub.api.mongo.entity.PubTableQueue;
import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.repository.PubEstablishmentRepository;
import com.pub.api.response.PubEstablishmentStatus;
import com.pub.api.service.PubEstablishmentService;
import com.pub.api.service.PubWaiterService;
import com.pub.api.utils.PubObjectUtil;

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
	public List<PubEstablishment> getByName(String name) {
		return establishmentRepository.findByNameLike(name);
	}

	@Override
	public PubEstablishment getById(String id) {
		return establishmentRepository.findById(id);
	}

	@Override
	public PubEstablishment getByLocationId(String locationId) {
		return establishmentRepository.findByLocationId(locationId);
	}

	@Override
	public Boolean getRegisteredEstablishmentsByLocationId(String locationId) {
		PubEstablishment pubEstablishment = establishmentRepository.findByLocationId(locationId);
		return !PubObjectUtil.isEmpty(pubEstablishment);
	}

	@Override
	public List<PubEstablishmentStatus> getEstablishmentStatus(String[] locationIdList) {
		List<PubEstablishmentStatus> pubEstablishmentStatusCollection = new ArrayList<>();
		for (String locationId : locationIdList) {
			PubEstablishment pubEstablishment = this.getByLocationId(locationId);
			PubEstablishmentStatus pubEstablishmentStatus = new PubEstablishmentStatus();
			pubEstablishmentStatus.setLocationId(locationId);
			pubEstablishmentStatus.setRegistered(!PubObjectUtil.isEmpty(pubEstablishment));
			pubEstablishmentStatusCollection.add(pubEstablishmentStatus);
		}
		return pubEstablishmentStatusCollection;
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

	@Override
	public void addCall(String call, PubEstablishment pubEstablishment) {
		PubTableQueue pubTableQueue = new PubTableQueue();
		pubTableQueue.setCall(call);
		pubTableQueue.setCallDate(Calendar.getInstance().getTime());
		pubEstablishment.addCall(pubTableQueue);
		this.save(pubEstablishment);
	}
}
