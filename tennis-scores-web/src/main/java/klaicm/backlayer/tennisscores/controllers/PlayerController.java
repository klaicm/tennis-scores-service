package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.model.Player;
import klaicm.backlayer.tennisscores.repositories.MatchRepository;
import klaicm.backlayer.tennisscores.repositories.PlayerRepository;
import klaicm.backlayer.tennisscores.services.MatchService;
import klaicm.backlayer.tennisscores.services.PlayerService;
import klaicm.backlayer.tennisscores.services.jpadata.MatchJpaService;
import klaicm.backlayer.tennisscores.services.jpadata.PlayerJpaService;
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
    PlayerJpaService playerJpaService;

    @Autowired
    MatchJpaService matchJpaService;

    @RequestMapping("{id}")
    public Player getPlayer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("player", playerJpaService.findById(id));
        return playerJpaService.findById(id);
        // return "player/index";
    }

    @RequestMapping("matches/{id}")
    public String getMatchesOfPlayer(@PathVariable("id") Long id, Model model) {
        Set<Match> playerMatches = new HashSet<>();
        String name = playerJpaService.findById(id).getFirstName() + " " + playerJpaService.findById(id).getLastName();

        matchJpaService.findAll().forEach(match -> {
            if (match.getPlayerW().getId() == id || match.getPlayerL().getId() == id) {
                playerMatches.add(match);
            }

        });

        if (playerMatches.size() > 0) {
            model.addAttribute("playerMatches", playerMatches);
        }

        return "playerMatches/index";
    }

}
