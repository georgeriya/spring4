package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.services.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping(value="/payments",produces="application/json",consumes="application/json")
	public Payment add(Payment entity) {
		return this.service.save(entity);
	}
	
	@GetMapping(value= "/payments")
	public List<Payment> getAll(){
		
		List<Payment> pmtList = new ArrayList<>();
		this.service.findAll().forEach(eachObject -> {pmtList.add(eachObject);});;
		
		
		return pmtList;
	}
}
