package com.seenu.engagement.engagementservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.seenu.engagement.engagementservice.model.Engagement;
import com.seenu.engagement.engagementservice.model.Meeting;

@RestController
@RequestMapping("")
public class EngagementController {

	@Autowired
	RestTemplate restTemplate;
	
	private static String MEETING_API_PATH = "http://meeting-service/";
	
	@RequestMapping("/all")
	public List<Engagement> getAllEngagments(){
	
		List<Engagement> list = new ArrayList<Engagement>();
		Engagement engag1 =new Engagement("1","Audit Engagment","Exam");
		Engagement engag2 =new Engagement("1","RBI Engagment","Non-Exam");
		
		list.add(engag1);
		list.add(engag2);
		
		return list;
	}
	
	@RequestMapping("/view/{id}")
	public Engagement getEngagment(@PathVariable("id") String id){
	
		Engagement engag =new Engagement("1","Audit Engagment","Exam");
		System.out.println("Inside meeting engag");
	    
	    ResponseEntity<List<Meeting>> response = restTemplate.exchange(MEETING_API_PATH+"all",HttpMethod.GET, null, new ParameterizedTypeReference<List<Meeting>>(){});
	    List<Meeting> meetings = response.getBody();
	    engag.setMeetings(meetings);
	    
		return engag;
	}
	
}
