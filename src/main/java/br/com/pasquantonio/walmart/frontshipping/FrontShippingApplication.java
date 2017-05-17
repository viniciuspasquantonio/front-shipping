package br.com.pasquantonio.walmart.frontshipping;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class FrontShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontShippingApplication.class, args);
	}
}
