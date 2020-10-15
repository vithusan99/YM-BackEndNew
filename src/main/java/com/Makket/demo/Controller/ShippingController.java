package com.Makket.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Makket.demo.Model.Shipping;
import com.Makket.demo.Service.ShippingService;

@CrossOrigin ("*")
@RestController
@RequestMapping(value = "/shipping")
public class ShippingController {

	@Autowired
	ShippingService shippingService;
	
	@PostMapping
	public ResponseEntity<Shipping> createShipping (@RequestBody Shipping shipping){
		return shippingService.createShipping(shipping);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Map<String, Object>> getAllShipping(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return shippingService.getAllShippingInPage(pageNo,pageSize);
	}
	@GetMapping(value = "/page/serachedPages")
	public ResponseEntity<Map<String,Object>> getSerchedShipping(
			@RequestParam(name = "serched",defaultValue = "null") String searched,
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize
			){
		return shippingService.getSerchedPage(searched,pageNo,pageSize);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Shipping> deleteShipping (@PathVariable String id){
		return shippingService.deleteShippingById(id);
	}

}
