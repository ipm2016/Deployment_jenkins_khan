package com.ora.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ora.webflux.dao.CustomarDao;
import com.ora.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	
	@Autowired
	private CustomarDao dao;

	
	public List<Customer> loadAllCustomers() throws Exception{
		long start = System.currentTimeMillis();
		 List<Customer> customers= dao.getCustomers();
		 long end = System.currentTimeMillis();
		 System.out.println("Total execution time "+(end - start));
		 return customers;
	}
	
	public Flux<Customer> loadAllCustomersWithFlux() throws Exception{
		long start = System.currentTimeMillis();
		 Flux<Customer> customers= dao.getCustomersWithFlux();
		 long end = System.currentTimeMillis();
		 System.out.println("Total execution time "+(end - start));
		 return customers;
	}
	
}
