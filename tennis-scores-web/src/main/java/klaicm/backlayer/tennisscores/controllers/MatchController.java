package klaicm.backlayer.tennisscores.controllers;

import klaicm.backlayer.tennisscores.services.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @RequestMapping("")
    public String getAllMatches(Model model) {
        model.addAttribute("matches", matchService.findAll());

        return "matches/index";
    }

}
