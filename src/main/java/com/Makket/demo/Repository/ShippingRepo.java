package com.Makket.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Makket.demo.Model.Shipping;

public interface ShippingRepo extends MongoRepository<Shipping,String> {

	@Query("{$or: [ { 'eMail': { $regex: ?0 , $options: 'i' } }, { 'name':{ $regex: ?0, $options: 'i' } },{ 'phoneNum': { $regex: ?0 , $options: 'i' } },{ 'address.street': { $regex: ?0 , $options: 'i' } },{ 'address.city': { $regex: ?0 , $options: 'i' } },{ 'address.state': { $regex: ?0 , $options: 'i' } },{ 'address.country': { $regex: ?0 , $options: 'i' } } ]}")
	List<Shipping> findBySearchContaining(String searched);


}
