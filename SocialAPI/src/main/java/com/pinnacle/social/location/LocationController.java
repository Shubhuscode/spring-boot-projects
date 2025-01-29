package com.pinnacle.social.location;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@RestController
public class LocationController {
	
	  @Autowired
	   private LocationService locationService;
		
	   @RequestMapping(value = "/locations")
	   public List<Location> getAllLocations() 
	   {
		return locationService.getAllLocations();
	   }	
	   
	   @RequestMapping(value = "/locations/{id}")
	   public Location getLocation(@PathVariable String id) {
	   	return locationService.getLocation(id);
	   }
	   
	   @PostMapping("/add-locations")
	   public void addLocation(@RequestBody Location location) {
	   	locationService.addLocation(location);
	   }
	   
	   @DeleteMapping("/location/{id}")
	   public void deleteLocation(@PathVariable String id) {
	       locationService.deleteLocation(id);
	   }
	   
	   @PutMapping("/locations/{id}")
	   public void updateLocation(@RequestBody Location location, @PathVariable String id) {

	        locationService.updateLocation(id, location);
	          

	   }


}
