package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.repositories.MatchRepository;
import klaicm.backlayer.tennisscores.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@Controller
public class MatchController {

    @Autowired
    MatchRepository matchRepository;

    @RequestMapping("/allMatches")
    public String listPlayers(Model model) {
        Set<Match> allMatches = matchRepository.findAll();
        model.addAttribute("matches", allMatches);

        System.out.println("Amount of played matches: " + allMatches.size());
        return "matches/index";
    }

}
