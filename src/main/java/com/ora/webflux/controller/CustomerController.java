package com.ora.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ora.webflux.dto.Customer;
import com.ora.webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<Customer> getAllUsingStream() throws Exception{
		return customerService.loadAllCustomersWithFlux();
	}
	
	
}
