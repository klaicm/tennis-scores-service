package klaicm.backlayer.tennisscores.repositories;

import klaicm.backlayer.tennisscores.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    @Override
    Set<Match> findAll();

}
