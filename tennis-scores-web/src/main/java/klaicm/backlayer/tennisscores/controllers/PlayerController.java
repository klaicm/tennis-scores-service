package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.ArchData;
import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.model.Player;
import klaicm.backlayer.tennisscores.repositories.MatchRepository;
import klaicm.backlayer.tennisscores.repositories.PlayerRepository;
import klaicm.backlayer.tennisscores.services.MatchService;
import klaicm.backlayer.tennisscores.services.PlayerService;
import klaicm.backlayer.tennisscores.services.jpadata.ArchDataJpaService;
import klaicm.backlayer.tennisscores.services.jpadata.MatchJpaService;
import klaicm.backlayer.tennisscores.services.jpadata.PlayerJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    @Autowired
    PlayerJpaService playerJpaService;

    @Autowired
    MatchJpaService matchJpaService;

    @Autowired
    ArchDataJpaService archDataJpaService;

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("player", playerJpaService.findById(id));
        Player player = playerJpaService.findById(id);
        Set<ArchData> archData = new HashSet<>();

                //ovdje bi sada dobro dosao jedan fini select prema playerId
        archDataJpaService.findAll().forEach(archData1 -> {
            if (archData1.getPlayer().getId() == player.getId()) {
                archData.add(archData1);
            };
        });

        if (archData.size() > 0) {
            player.setArchData(archData);
        }

        return player;
    }

    @GetMapping("/player/matches/{id}")
    public Set<Match> getMatchesOfPlayer(@PathVariable("id") Long id, Model model) {
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

        return playerMatches;
    }

    @GetMapping("/player/arch/{id}")
    public ArchData getPlayerArchData(@PathVariable("id") Long id, Model model) {
        model.addAttribute("archData", archDataJpaService.findById(id));
        return archDataJpaService.findById(id);
    }

}
