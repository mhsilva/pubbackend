package com.pub.api.service;

import com.pub.api.mongo.entity.PubEstablishmentsNotAffiliated;
import com.pub.api.request.PubEstablishmentsNotAffiliatedRequest;

public interface PubEstablishmentsNotAffiliatedService {
	public PubEstablishmentsNotAffiliated save(
			PubEstablishmentsNotAffiliatedRequest pubEstablishmentNotAffiliatedRequest);
}
