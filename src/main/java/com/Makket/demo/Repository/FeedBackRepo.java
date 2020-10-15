package com.Makket.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Makket.demo.Model.FeedBack;



public interface FeedBackRepo extends MongoRepository <FeedBack,String> {
	
	@Query("{$or: [ { 'eMail': { $regex: ?0 , $options: 'i' } }, { 'feedBack':{ $regex: ?0, $options: 'i' } },{ 'phoneNum':{ $regex: ?0, $options: 'i' } } ]}")
	List<FeedBack> findBySearchContaining(String searched);
	
}
