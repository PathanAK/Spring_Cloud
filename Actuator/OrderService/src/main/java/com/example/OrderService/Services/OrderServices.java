package com.example.OrderService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.OrderService.Orders.Orders;
import com.example.OrderService.Repository.OrderRepository;

@Component
public class OrderServices {
	
	@Autowired
	OrderRepository repo;
	
	public List<Orders> findAllOrders() {
		return (List<Orders>) repo.findAll();
	}
	
	public Optional<Orders> findById(Integer id) {
		return repo.findById(id);
	}
	
	public Orders findByname(String name) {
		return repo.findByName(name);
	}
	
	public List<Orders> findByStatus(String status) {
		return repo.findByStatus(status);
	}
	
	public Orders insertOrder(Orders or) {
		return repo.save(or);
	}
	
	public Orders updateOrder(Integer oid, Orders or) {
		
	    Optional<Orders> optionalExisting = this.findById(oid);
	    
	    if (optionalExisting.isPresent()) {
	        Orders existing = optionalExisting.get();
	        
	        if (or.getName() != null)
	            existing.setName(or.getName());
	        if (or.getStatus() != null)
	        	existing.setStatus(or.getStatus());
	        if (or.getOid() != null)
	        	existing.setUid(or.getUid());
	        
	        return repo.save(existing);
	    } else {
	        // Handle the case when the order with the given ID doesn't exist
	        // You can throw an exception or return null depending on your requirements
	        return null;
	    }
	}
	
	public List<Orders> getOrderByUserId(Integer id) {
		return repo.findByUid(id);
	}
	
	public String deleteById(Integer oid) {
		repo.deleteById(oid);
		return "Order deleted with order id : " + oid;
		
	}
}
