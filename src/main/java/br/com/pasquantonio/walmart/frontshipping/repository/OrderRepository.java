package br.com.pasquantonio.walmart.frontshipping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pasquantonio.walmart.frontshipping.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
