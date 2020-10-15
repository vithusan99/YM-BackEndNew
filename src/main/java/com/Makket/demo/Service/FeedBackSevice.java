package com.Makket.demo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Makket.demo.Model.FeedBack;
import com.Makket.demo.Repository.FeedBackRepo;


@Service
public class FeedBackSevice {
	
	@Autowired
	FeedBackRepo feedBackRepo;

	public ResponseEntity<FeedBack> createFeedBack(FeedBack feedBack) {
		try {
			FeedBack newFeedBack = feedBackRepo.save(new FeedBack (feedBack.geteMail(),feedBack.getFeedBack(),feedBack.getPhoneNum()));
			return new ResponseEntity<>(newFeedBack,HttpStatus.CREATED);
			}catch(Exception e) {
				return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
			}
	}

	public ResponseEntity<Map<String, Object>> getAllFeedBackInPage(int pageNo, int pageSize) {
		try {
			Map<String, Object> response = new HashMap<>();
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
            Page<FeedBack> page = feedBackRepo.findAll(pageable);
            response.put("data", page.getContent());
            response.put("Total_No_Of_Pages", page.getTotalPages());
            response.put("Total_No_Of_Elements", page.getTotalElements());
            response.put("Current_Page_No", page.getNumber());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e) {
        	return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
        }
	}

	public ResponseEntity<Map<String, Object>> getSerchedPage(String searched, int pageNo, int pageSize) {
		List<FeedBack> searchedFeedBack = feedBackRepo.findBySearchContaining(searched);
		Map<String, Object> response = new HashMap<>();
		PagedListHolder<FeedBack> page = new PagedListHolder<FeedBack>(searchedFeedBack);
		page.setPageSize(pageSize); // number of items per page
		page.setPage(pageNo); 
		
		response.put("data", page.getPageList());
		response.put("Total_No_Of_Elements", page.getNrOfElements());
		response.put("Total_No_Of_Pages", page.getPage());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<FeedBack> deleteFeedBackById(String id) {
		try {
			Optional<FeedBack> feedBackData = feedBackRepo.findById(id);
			
			if(feedBackData.isPresent()) {
				feedBackRepo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
	    	return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
	}


	
}


