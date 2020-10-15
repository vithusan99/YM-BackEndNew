package com.Makket.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Makket.demo.Model.Product;
import com.Makket.demo.Service.ProductServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")

public class ProductController {

	@Autowired
	ProductServices productServices;
	
	@PostMapping
	public ResponseEntity<Product>createNewProduct(@RequestBody Product product){
		return productServices.createNewProduct(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>>getAllProducts() {
		return productServices.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product>getProductById(@PathVariable String id){
		return productServices.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public   ResponseEntity<Product>updateProductById(@RequestBody Product updateProduct ,@PathVariable String id){
		return productServices.updateProductById(updateProduct,id);
	}
	@DeleteMapping("/{id}")
	public  ResponseEntity<Product>deleteProductById(@PathVariable String id){
		return  productServices.deleteProductById(id);
	}
	@DeleteMapping
	public  ResponseEntity<Product>deleteAllProduct(){
		return  productServices.deleteAllProduct();
	}
	@GetMapping(params="product")
	public ResponseEntity<List<Product>> getProductByProduct(@RequestParam String product){
		return productServices.getProductByProduct(product);
	}
	
}
