package com.Makket.demo.Repository;


import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Makket.demo.Model.Product;

@Repository
public interface ProductRepository extends MongoRepository <Product, String> {


	List<Product> findByProduct(String product);






}
