package com.seenu.meetingservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.seenu.meetingservice.model.Engagement;
import com.seenu.meetingservice.model.Meeting;

@RestController
@RequestMapping("")
public class MeetingController {

	@Autowired
	RestTemplate restTemplate;
	
	private static String ENGAGEMENT_API_PATH = "http://engagement-service/";
	
	
	@GetMapping
	@RequestMapping("/all")
	public List<Meeting> getAllMeetings(){
		 List<Meeting> list = new ArrayList<Meeting>();
		 Meeting meet1 = new Meeting("1000","Team Meeting with ROSE",new Date(),new Date());
		 Meeting meet2 = new Meeting("1010","ROSE Microservice",new Date(),new Date());
		 Meeting meet3 = new Meeting("1020","ROSE Global standup",new Date(),new Date());
		 
		 list.add(meet1);
		 list.add(meet2);
		 list.add(meet3);
		 
		 return list;
	}
	
	@GetMapping
	@RequestMapping("/engagement")
	public String getEngagementDetails(){
		System.out.println("Inside meeting engag");
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
		return restTemplate.exchange(ENGAGEMENT_API_PATH+"engagement/all",HttpMethod.GET, entity, String.class).getBody();
		
	}
}
