package klaicm.backlayer.tennisscores.bootstrap;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.model.Player;
import klaicm.backlayer.tennisscores.services.MatchService;
import klaicm.backlayer.tennisscores.services.PlayerService;
import klaicm.backlayer.tennisscores.services.SeasonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final PlayerService playerService;
    private final MatchService matchService;
    private final SeasonService seasonService;

    public DataLoader(PlayerService playerService, MatchService matchService, SeasonService seasonService) {
        this.playerService = playerService;
        this.matchService = matchService;
        this.seasonService = seasonService;
    }


    @Override
    public void run(String... args) throws Exception {

        Player player1 = new Player();
        player1.setFirstName("Ivan");
        player1.setLastName("Ivić");

        playerService.save(player1);

        Player player2 = new Player();
        player2.setFirstName("Pero");
        player2.setLastName("Perić");

        playerService.save(player2);

        Player player3 = new Player();
        player3.setFirstName("Marko");
        player3.setLastName("Marić");

        playerService.save(player3);

        System.out.println("Loaded Players...");

        Match match1 = new Match();
        match1.setPlayerW(playerService.findById((long) 2).getFirstName() + " " + playerService.findById((long) 2).getLastName());
        match1.setPlayerL(playerService.findById((long) 3).getFirstName() + " " + playerService.findById((long) 3).getLastName());
        match1.setResult("6:3 6:3");
        match1.setDate(LocalDate.of(2019,8,25));

        matchService.save(match1);

        Match match2 = new Match();
        match2.setPlayerW(playerService.findById((long) 3).getFirstName() + " " + playerService.findById((long) 3).getLastName());
        match2.setPlayerL(playerService.findById((long) 1).getFirstName() + " " + playerService.findById((long) 1).getLastName());
        match2.setResult("6:1 6:2");
        match1.setDate(LocalDate.of(2019,8,25));

        matchService.save(match2);

        System.out.println(matchService.findAll().iterator().next().getPlayerW().equalsIgnoreCase("Marko Marić"));

    }
}
