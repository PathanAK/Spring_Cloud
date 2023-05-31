package com.example.OrderService.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.OrderService.Orders.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
	
	public Orders findByName(String name);
	
	public List<Orders> findByStatus(String status);
	
	public List<Orders> findByUid(Integer id);

}
