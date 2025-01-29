package com.pinnacle.ipl.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    
    @GetMapping
    public List<Performance> getAllPerformances() {
        return performanceService.getAllPerformances();
    }

   
    @GetMapping("/{id}")
    public Performance getPerformanceById(@PathVariable Long id) {
        return performanceService.getPerformance(id);
    }

    
    @PostMapping
    public void addPerformance(@RequestBody Performance performance) {
        performanceService.addPerformance(performance);
    }

    
    @DeleteMapping("/{id}")
    public void deletePerformance(@PathVariable Long id) {
        performanceService.deletePerformance(id);
    }

   
    @PutMapping("/{id}")
    public void updatePerformance(@PathVariable Long id, @RequestBody Performance updatedPerformance) {
        performanceService.updatePerformance(id, updatedPerformance);
    }
}
