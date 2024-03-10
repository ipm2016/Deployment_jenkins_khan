package com.ora.webflux;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ora.webflux.dto.Customer;
import com.ora.webflux.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
 class MonoFluxTest {

	 @Autowired
	 CustomerService customerService;
	 
	@Test
	void testMono() {
		 Mono<?> monoString = Mono.just("ora")
				 .then(Mono.error(new RuntimeException("Exception")))
				 .log();
		 monoString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
	}
	
	@Test
	 void testFlux() {
		Flux<String> fluxString=  Flux.just("Ora","Oussama","RAHALI","RANIA")
				.concatWithValues("HI-")
				.concatWith(Flux.error(new RuntimeException("Exception FLux ")))
				.concatWithValues("Hola")
				.log();
		fluxString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
	}
	
	@Test
	void testCustomerGetAll() throws Exception{
		List<Customer> customers= customerService.loadAllCustomers();
	}
	
}
