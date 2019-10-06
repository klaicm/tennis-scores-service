package klaicm.backlayer.tennisscores.services.jpadata;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.repositories.MatchRepository;
import klaicm.backlayer.tennisscores.services.MatchService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservice")
public class MatchJpaService implements MatchService {

    private final MatchRepository matchRepository;

    public MatchJpaService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Set<Match> findAll() {
        Set<Match> matches = new HashSet<>();
        matchRepository.findAll().forEach(matches::add);
        return matches;
    }

    @Override
    public Match findById(Long aLong) {
        return matchRepository.findById(aLong).orElse(null);
    }

    @Override
    public Match save(Match object) {
        return matchRepository.save(object);
    }

    @Override
    public void delete(Match object) {
        matchRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public Set<Match> getPlayerMatches(Long id) {
        return matchRepository.getPlayerMatches(id);
    }
}
