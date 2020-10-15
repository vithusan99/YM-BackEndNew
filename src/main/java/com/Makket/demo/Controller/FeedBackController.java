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

import com.Makket.demo.Model.FeedBack;
import com.Makket.demo.Service.FeedBackSevice;



@CrossOrigin ("*")
@RestController
@RequestMapping(value = "/feedback")
public class FeedBackController {
	
	@Autowired
	FeedBackSevice feedBackSevice;
	
	@PostMapping
	public ResponseEntity<FeedBack> createFeedBack (@RequestBody FeedBack shipping){
		return feedBackSevice.createFeedBack(shipping);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Map<String, Object>> getAllFeedBack(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return feedBackSevice.getAllFeedBackInPage(pageNo,pageSize);
	}
	@GetMapping(value = "/page/serachedPages")
	public ResponseEntity<Map<String,Object>> getSerchedFeedBack(
			@RequestParam(name = "serched",defaultValue = "null") String searched,
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize
			){
		return feedBackSevice.getSerchedPage(searched,pageNo,pageSize);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FeedBack> deleteFeedBack (@PathVariable String id){
		return feedBackSevice.deleteFeedBackById(id);
	}

}
