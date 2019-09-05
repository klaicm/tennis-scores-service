package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping("/matches")
    private Set<Match> getAllMatches() {
        System.out.println(matchService.test());
        System.out.println(matchService.findAll().size());
        return matchService.findAll();
    }

}
