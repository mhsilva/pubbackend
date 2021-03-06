package com.pub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pub.api.mongo.entity.PubEstablishment;
import com.pub.api.response.PubEstablishmentStatus;
import com.pub.api.service.PubEstablishmentService;

@RestController
@RequestMapping(value = "/establishment")
public class PubEstablishmentController {

	@Autowired
	private PubEstablishmentService pubEstablishmentService;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<PubEstablishment> getAllEstablishments() {
		return pubEstablishmentService.getAll();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, params = { "name" })
	public @ResponseBody List<PubEstablishment> getEstablishmentsByName(@RequestParam(name = "name") String name) {
		return pubEstablishmentService.getByName(name);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "locationId" })
	public @ResponseBody PubEstablishment getEstablishmentsByLocationId(
			@RequestParam(name = "locationId") String locationId) {
		return pubEstablishmentService.getByLocationId(locationId);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "registered" })
	public @ResponseBody Boolean getRegisteredEstablishmentsByLocationId(
			@RequestParam(name = "registered") String locationId) {
		return pubEstablishmentService.getRegisteredEstablishmentsByLocationId(locationId);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "locationIdList" })
	public @ResponseBody List<PubEstablishmentStatus> getEstablishmentStatus(@RequestParam String[] locationIdList) {
		return pubEstablishmentService.getEstablishmentStatus(locationIdList);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody PubEstablishment saveEstablishment(@RequestBody PubEstablishment establishment) {
		return pubEstablishmentService.save(establishment);
	}
}
