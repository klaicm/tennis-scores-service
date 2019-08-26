package klaicm.backlayer.tennisscores.services.map;

import klaicm.backlayer.tennisscores.model.Season;
import klaicm.backlayer.tennisscores.services.SeasonService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SeasonServiceMap extends AbstractMapService<Season, Long> implements SeasonService {

    @Override
    public Set<Season> findAll() {
        return super.findAll();
    }

    @Override
    public Season findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Season save(Season object) {
        return super.save(object);
    }

    @Override
    public void delete(Season object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
