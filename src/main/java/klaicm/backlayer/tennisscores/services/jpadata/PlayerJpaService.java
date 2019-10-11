package klaicm.backlayer.tennisscores.services.jpadata;

import klaicm.backlayer.tennisscores.model.ArchData;
import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.model.Player;
import klaicm.backlayer.tennisscores.repositories.PlayerRepository;
import klaicm.backlayer.tennisscores.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("jpaservice")
public class PlayerJpaService implements PlayerService {

    private static final int K = 32;

    @Autowired
    ArchDataJpaService archDataJpaService;

    @Autowired
    MatchJpaService matchJpaService;

    private final PlayerRepository playerRepository;

    public PlayerJpaService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Set<Player> findAll() {
        Set<Player> players = new HashSet<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    @Override
    public Player findById(Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        Set<ArchData> archData = archDataJpaService.getArchDataByPlayerId(player.getId());

        // Set<Match> playerMatches = matchJpaService.getPlayerMatches(player.getId());
        // player.setMatches(playerMatches);

        player.setArchData(archData);

        return player;

    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void delete(Player player) {
        playerRepository.delete(player);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    public void updatePlayerEloRating(Match match) {

        Map<String, Double> probabilityMap = this.calculateProbabilityOfWin(match);

        // double raUpdated = ra + K*(1 - ea);
        // double rbUpdated = rb + K*(0 - eb);
        int raUpdated = (int) Math.round(match.getPlayerW().getElo() + K*(1 - probabilityMap.get("ea")));
        int rbUpdated = (int) Math.round(match.getPlayerL().getElo() + K*(0 - probabilityMap.get("eb")));

        Player playerW = findById(match.getPlayerW().getId());
        Player playerL = findById(match.getPlayerL().getId());

        playerW.setElo(raUpdated);
        playerL.setElo(rbUpdated);

        this.save(playerW);
        this.save(playerL);
    }

    public Map<String, Double> calculateProbabilityOfWin(Match match) {
        Map<String, Double> probabilityMap = new HashMap<String, Double>();

        double ra = match.getPlayerW().getElo();
        double rb = match.getPlayerL().getElo();

        double ea = 1/(1+ Math.pow(10, ((rb-ra)/400)));
        probabilityMap.put("ea", ea);
        double eb = 1/(1+ Math.pow(10, ((ra-rb)/400)));
        probabilityMap.put("eb", eb);

        return probabilityMap;

    }
}
