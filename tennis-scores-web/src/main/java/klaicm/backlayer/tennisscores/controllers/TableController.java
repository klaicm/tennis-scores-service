package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.model.Player;
import klaicm.backlayer.tennisscores.repositories.PlayerRepository;
import klaicm.backlayer.tennisscores.services.jpadata.PlayerJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class TableController {

    @Autowired
    PlayerJpaService playerJpaService;

    @RequestMapping("/table")
    public String getTable(Model model) {
        Set<Player> allPlayers = playerJpaService.findAll();
        model.addAttribute("players", allPlayers);
        return "table/index";
    }

}