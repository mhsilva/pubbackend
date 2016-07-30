package com.pub.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.api.mongo.entity.PubWaiter;
import com.pub.api.repository.PubWaiterRepository;
import com.pub.api.service.PubWaiterService;
import com.pub.api.utils.PubObjectUtil;

@Service
public class PubWaiterServiceImpl implements PubWaiterService {

	@Autowired
	private PubWaiterRepository waiterRepository;

	@Override
	public List<PubWaiter> getAll() {
		return waiterRepository.findAll();
	}

	@Override
	public PubWaiter getByLogin(String login) {
		return waiterRepository.findByLogin(login);
	}

	@Override
	public PubWaiter save(PubWaiter waiter) {
		PubWaiter persistedEntity = getByLogin(waiter.getLogin());
		if (persistedEntity != null) {
			persistedEntity.setName(PubObjectUtil.ifNull(waiter.getName(), persistedEntity.getName()));
			persistedEntity.setToken(PubObjectUtil.ifNull(waiter.getToken(), persistedEntity.getToken()));
		} else {
			persistedEntity = waiter;
		}
		return waiterRepository.save(persistedEntity);
	}
}
