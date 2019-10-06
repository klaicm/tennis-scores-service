package klaicm.backlayer.tennisscores.services.jpadata;

import klaicm.backlayer.tennisscores.model.ArchData;
import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.model.Player;
import klaicm.backlayer.tennisscores.repositories.PlayerRepository;
import klaicm.backlayer.tennisscores.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class PlayerJpaService implements PlayerService {

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
    public Player findById(Long aLong) {
        Player player = playerRepository.findById(aLong).orElse(null);
        Set<ArchData> archData = archDataJpaService.getArchDataByPlayerId(player.getId());

        // Set<Match> playerMatches = matchJpaService.getPlayerMatches(player.getId());
        // player.setMatches(playerMatches);

        player.setArchData(archData);

        return player;

    }

    @Override
    public Player save(Player object) {
        return playerRepository.save(object);
    }

    @Override
    public void delete(Player object) {
        playerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
