package com.pinnacle.ipl.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // Get all matches with team details
    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    // Get match by ID with team details
    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        return matchService.getMatch(id);
    }

    @PostMapping
    public void addMatch(@RequestBody Match match) {
        matchService.addMatch(match);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }

    @PutMapping("/{id}")
    public void updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        matchService.updateMatch(id, updatedMatch);
    }
}
