package klaicm.backlayer.tennisscores.repositories;

import klaicm.backlayer.tennisscores.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
