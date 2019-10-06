package klaicm.backlayer.tennisscores.repositories;

import klaicm.backlayer.tennisscores.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    @Query("select m from Match m where m.playerW.id = :playerId or m.playerL.id = :playerId")
    Set<Match> getPlayerMatches(@Param("playerId") Long playerId);
}
