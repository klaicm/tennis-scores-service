package klaicm.backlayer.tennisscores.services.map;

import klaicm.backlayer.tennisscores.model.Match;
import klaicm.backlayer.tennisscores.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MatchServiceMap extends AbstractMapService<Match, Long> implements MatchService {

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

    @Override
    public String test() {
        return "test test";
    }
}
