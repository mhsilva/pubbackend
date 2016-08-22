package com.pub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.api.mongo.entity.PubEstablishmentsNotAffiliated;
import com.pub.api.request.PubEstablishmentsNotAffiliatedRequest;
import com.pub.api.service.PubEstablishmentsNotAffiliatedService;

@RestController
@RequestMapping(value = "/establishmentsNotAffiliated")
public class PubEstablishmentsNotAffiliatedController {

	@Autowired
	private PubEstablishmentsNotAffiliatedService pubEstablishmentsNotAffiliatedService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody PubEstablishmentsNotAffiliated registerEstablishmentNotAffiliated(
			@RequestBody PubEstablishmentsNotAffiliatedRequest pubEstablishmentNotAffiliatedRequest) {
		return pubEstablishmentsNotAffiliatedService.save(pubEstablishmentNotAffiliatedRequest);
	}
}
