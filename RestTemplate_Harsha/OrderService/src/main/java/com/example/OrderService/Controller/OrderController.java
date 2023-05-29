package com.example.OrderService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.Orders.Orders;
import com.example.OrderService.Services.OrderServices;

@RestController
public class OrderController {
	
	@Autowired
	OrderServices service;
	
	@GetMapping("/orders")
	public List<Orders> getAllOrder() {
		return service.findAllOrders();
	}
	
	@GetMapping("/orderById/{oid}")
	public Optional<Orders> getOrderByid(@PathVariable Integer oid) {
		return service.findById(oid);
	}
	
	@GetMapping("/orderByName/{name}")
	public Orders getOrderByName(@PathVariable String name) {
		return service.findByname(name);
	}
	
	@GetMapping("/greet")
	public String demoGreet() {
		return "Hello From OrderService...!!! Test 2 Updated...!!";
	}
	
	@GetMapping("/orderbyStatus/{status}")
	public List<Orders> getOrderByStatus(@PathVariable String status) {
		return service.findByStatus(status);
	}
	
	@GetMapping("/userorders/{id}")
	public List<Orders> getOrderByUid(@PathVariable Integer id) {
		return service.getOrderByUserId(id);
	}
	
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE )
	public Orders insertOrder(@RequestBody Orders or) {
		return service.insertOrder(or);
	}
	
	@PutMapping(value = "/update/{oid}", consumes = MediaType.APPLICATION_JSON_VALUE )
	public Orders updateOrder(@PathVariable Integer oid , @RequestBody Orders or) {
		return service.updateOrder(oid, or);
	}
	
	@DeleteMapping("/delete/{oid}")
	public String deleteOrder(@PathVariable Integer oid) {
		return service.deleteById(oid);
	}
}
