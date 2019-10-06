package klaicm.backlayer.tennisscores.repositories;

import klaicm.backlayer.tennisscores.model.ArchData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ArchDataRepository extends CrudRepository<ArchData, Long> {

    @Query("select ar from ArchData ar where ar.player.id = :playerId")
    Set<ArchData> getArchDataByPlayerId(@Param("playerId") Long playerId);
}
