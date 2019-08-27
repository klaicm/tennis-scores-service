package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.services.MatchService;
import klaicm.backlayer.tennisscores.services.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;
    private final MatchService matchService;

    public PlayerController(PlayerService playerService, MatchService matchService) {
        this.playerService = playerService;
        this.matchService = matchService;
    }

    @RequestMapping("/table")
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "players/index";
    }

    @RequestMapping("player/{id}")
    public String getPlayer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("player", playerService.findById(id));
        System.out.println(matchService.findAll().contains(playerService.findById(id)));
        return "player/index";
    }

    @RequestMapping("matches/{id}")
    public String getMatchesOfPlayer(@PathVariable("id") Long id, Model model) {
        String name = playerService.findById(id).getFirstName() + " " + playerService.findById(id).getLastName();
        List<Match> matchList = new ArrayList<>();
        if (matchService.findAll().iterator().next().getPlayerW().equalsIgnoreCase(playerService.findById(id).getFirstName() + " " + playerService.findById(id).getLastName())) {
            matchList.add(matchService.findById((long) 2));
            model.addAttribute("playerMatches", matchList);
        }

        return "playerMatches/index";
    }

}
