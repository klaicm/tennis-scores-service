package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.repositories.MatchRepository;
import klaicm.backlayer.tennisscores.services.jpadata.MatchJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Set;

@Controller
public class MatchController {

    @Autowired
    MatchJpaService matchJpaService;

    @RequestMapping("/allMatches")
    public String listPlayers(Model model) {
        Set<Match> allMatches = matchJpaService.findAll();
        model.addAttribute("matches", allMatches);

        System.out.println("Amount of played matches: " + allMatches.size());
        return "matches/index";
    }

}
