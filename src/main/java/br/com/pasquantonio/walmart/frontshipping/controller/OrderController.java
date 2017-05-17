package br.com.pasquantonio.walmart.frontshipping.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pasquantonio.walmart.frontshipping.entity.Order;
import br.com.pasquantonio.walmart.frontshipping.repository.OrderRepository;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
	@Autowired	
	private OrderRepository orderRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, consumes="application/json",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes="application/json",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Order findById(@PathVariable("id") Integer id) {
		return orderRepository.findOne(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody @Valid Order shipping) {
		return orderRepository.save(shipping);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Order update(@RequestBody @Valid Order shipping, @PathVariable Long id) {
		return orderRepository.save(shipping);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes="application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		orderRepository.delete(id);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {EmptyResultDataAccessException.class, EntityNotFoundException.class})
	public void handleNotFound() {}
}
