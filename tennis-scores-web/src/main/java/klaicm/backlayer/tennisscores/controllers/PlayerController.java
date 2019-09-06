package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.model.Player;
import klaicm.backlayer.tennisscores.repositories.MatchRepository;
import klaicm.backlayer.tennisscores.repositories.PlayerRepository;
import klaicm.backlayer.tennisscores.services.MatchService;
import klaicm.backlayer.tennisscores.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    MatchRepository matchRepository;

    @RequestMapping("{id}")
    public String getPlayer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("player", playerRepository.findById((long) 1));
        return "player/index";
    }

    @RequestMapping("matches/{id}")
    public String getMatchesOfPlayer(@PathVariable("id") Long id, Model model) {
        Set<Match> playerMatches = new HashSet<>();
        Optional<Player> player = playerRepository.findById((long) 2);
        String name = playerRepository.findById(id).get().getFirstName() + " " + playerRepository.findById(id).get().getLastName();

        matchRepository.findAll().forEach(match -> {
            if (match.getPlayerW() == 1) {
                playerMatches.add(match);
            }

        });

        if (playerMatches.size() > 0) {
            model.addAttribute("playerMatches", playerMatches);
        }

        return "playerMatches/index";
    }

}
