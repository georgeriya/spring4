package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Store;
import com.example.demo.services.StoreService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StoreController {

	@Autowired
	public StoreService repo;
	
	@ApiOperation(value="Fetch the details of all Global")
	@ApiResponses({
		@ApiResponse(code=200,message="Resource Found- Success")
	})

	
	@GetMapping("/allStores")
	public List<Store> getStores(){
		
		return this.repo.getAll();
	
	}
	
	@ApiParam(value="Fetch Details by id")
	
	@GetMapping("/allStores/{storeId}")
	public Store findStoreById(@PathVariable("storeId") int id) {
		
		return this.repo.findById(id);
	}
	
	
}
