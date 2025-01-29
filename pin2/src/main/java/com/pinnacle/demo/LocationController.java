package com.pinnacle.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	
	@RequestMapping(value = "/locations")
	   public List<Location> getAllLocations() 
	   {
		Location location1 = new Location("l1", "New York");
		Location location2 = new Location("l2", "Delhi");
		Location location3 = new Location("l3", "Mumbai");	
			
		return Arrays.asList(location1, location2, location3);
	   }	

}
