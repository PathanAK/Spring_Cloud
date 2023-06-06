package com.example.OrderService.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderService.Orders.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
	
	public Orders findByName(String name);
	
	public List<Orders> findByStatus(String status);
	
	public List<Orders> findByUid(Integer id);

}
