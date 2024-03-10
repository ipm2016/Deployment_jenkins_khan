package com.ora.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.ora.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomarDao {

	public List<Customer> getCustomers() throws Exception {
		return IntStream.rangeClosed(1, 50)
				.peek(i -> {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				})
				.peek(i -> System.out.println("proccesing customer"+i))
				.mapToObj(i -> new Customer(i, "customer" + i))
				.toList();
	}
	
	
	public Flux<Customer> getCustomersWithFlux() throws Exception {
		return Flux.range(1, 50)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("proccesing customer"+i))
				.map(i -> new Customer(i, "customer" + i));
	}
	
	
}
