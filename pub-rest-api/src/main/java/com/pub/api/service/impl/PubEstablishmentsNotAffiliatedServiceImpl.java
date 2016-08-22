package com.pub.api.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.api.mongo.entity.PubEstablishmentsNotAffiliated;
import com.pub.api.repository.PubEstablishmentsNotAffiliatedRepository;
import com.pub.api.request.PubEstablishmentsNotAffiliatedRequest;
import com.pub.api.service.PubEstablishmentsNotAffiliatedService;

@Service
public class PubEstablishmentsNotAffiliatedServiceImpl implements PubEstablishmentsNotAffiliatedService {

	@Autowired
	private PubEstablishmentsNotAffiliatedRepository establishmentsNotAffiliatedRepository;

	@Override
	public PubEstablishmentsNotAffiliated save(
			PubEstablishmentsNotAffiliatedRequest pubEstablishmentNotAffiliatedRequest) {
		PubEstablishmentsNotAffiliated pubEstablishmentNotAffiliated = new PubEstablishmentsNotAffiliated();
		pubEstablishmentNotAffiliated.setName(pubEstablishmentNotAffiliatedRequest.getName());
		pubEstablishmentNotAffiliated.setLocationId(pubEstablishmentNotAffiliatedRequest.getLocationId());
		pubEstablishmentNotAffiliated.setDate(Calendar.getInstance().getTime());
		return establishmentsNotAffiliatedRepository.save(pubEstablishmentNotAffiliated);
	}
}
