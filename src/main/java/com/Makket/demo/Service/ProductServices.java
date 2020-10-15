package com.Makket.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Makket.demo.Model.Product;
import com.Makket.demo.Repository.ProductRepository;



@Service
public class ProductServices {

private static final String String = null;
//	@Autowired
//	private Product product;
	
	@Autowired 
	private ProductRepository productRepository;
	
	

	public ResponseEntity<List<Product>> getAllProducts() {
		// TODO Auto-generated method stub
		try {
			List<Product> product= new ArrayList<Product>();
			
			productRepository.findAll().forEach(product::add);
			if(product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	public ResponseEntity<Product> createNewProduct(Product product) {
		// TODO Auto-generated method stub
		 try {
		   	 	Product _product = productRepository.insert(product);
		   	 	return new ResponseEntity<>(_product, HttpStatus.CREATED);
		   	 } catch (Exception e) {
		   	 	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	   	 }

		
	}


	public ResponseEntity<Product> getProductById(String id) {
		// TODO Auto-generated method stub
		Optional<Product> productNew = productRepository.findById(id);
		
		if(productNew.isPresent())
		 {
			return new ResponseEntity<>(productNew.get(),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		 
	}


	public ResponseEntity<Product> updateProductById(Product updateProduct,String id) {
		// TODO Auto-generated method stub
		Optional<Product> oldProduct=  productRepository.findById(id);
		try {
			if (oldProduct.isPresent()){
				
				Product newProduct= oldProduct.get();
				newProduct.setProduct(updateProduct.getProduct());
				newProduct.setPrice(updateProduct.getPrice());
				newProduct.setImage1(updateProduct.getImage1());
				newProduct.setImage2(updateProduct.getImage2());
				newProduct.setQuantity(updateProduct.getQuantity());
				newProduct.setCategory(updateProduct.getCategory());
				newProduct.setDescription(updateProduct.getDescription());
				newProduct.setType(updateProduct.getType());
				newProduct.setCount(updateProduct.getCount());
				
				return new ResponseEntity<>(productRepository.save(newProduct),HttpStatus.OK);
				
			}else {
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}


	public ResponseEntity<Product> deleteProductById(String id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(id);
		try {
			if (product.isPresent()) {
				productRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	
		
	}


	public ResponseEntity<Product> deleteAllProduct() {
		// TODO Auto-generated method stub
		try {
			productRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//
//	public ResponseEntity<Product> getProductByName(String product) {
//		// TODO Auto-generated method stub
//		List<Product> productNew = productRepository.findByName(product);
//		try {
//		if(productNew.isEmpty())
//		 {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			
//		}else {
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//		}catch(Exception e){
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		 
//	}


	public ResponseEntity<List<Product>> getProductByProduct(String product) {
		// TODO Auto-generated method stub
		List<Product> productNew = productRepository.findByProduct(product);
		try {
		if(productNew.isEmpty())
		 {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	



	
}
