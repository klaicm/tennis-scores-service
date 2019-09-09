package klaicm.backlayer.tennisscores.services.map;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.services.MatchService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("mapservice")
public class MatchMapService extends AbstractMapService<Match, Long> implements MatchService {

    @Override
    public Set<Match> findAll() {
        return super.findAll();
    }

    @Override
    public Match findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Match save(Match object) {
        return super.save(object);
    }

    @Override
    public void delete(Match object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
