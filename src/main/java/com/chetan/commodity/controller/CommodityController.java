package com.chetan.commodity.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.commodity.service.ICommodityService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class CommodityController {
	@Autowired
	ICommodityService iCommodityService;

	@Operation(method = "Get", summary = "Get Price of All Commodities", description = "We can get the price of all commodities. And can also select the range by adding date parameter in request. Format of date will be yyyy-mm-dd")
	@GetMapping("/all")
	public ResponseEntity<List<Map<String, Object>>> getAll(
			@RequestParam(value = "date", required = false) String date) {
		List<Map<String, Object>> commodities = iCommodityService.getAll(date);
		return new ResponseEntity<>(commodities, HttpStatus.OK);

	}

	@Operation(method = "Get", summary = "Get Price of Single Commodity by Name", description = "We can get the price of single commodity by adding name of commodity in request parameter. We can also select the range by adding date parameter in request. Format of date will be yyyy-mm-dd. Can also sort the result on the basis of price by adding sort parameter in request.")
	@GetMapping("/one")
	public ResponseEntity<List<Map<String, Object>>> getOne(@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "sort", required = false) String sort) {
		List<Map<String, Object>> commodities = iCommodityService.getOne(date, name, sort);
		return new ResponseEntity<>(commodities, HttpStatus.OK);

	}

}
