package com.pub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.api.mongo.entity.PubEstablishment;
import com.pub.api.service.PubEstablishmentService;

@RestController
@RequestMapping(value = "/establishment")
public class PubEstablishmentController {

	@Autowired
	private PubEstablishmentService pubEstablishmentService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<PubEstablishment> getAllEstablishments() {
		return pubEstablishmentService.getAll();
	}

}
