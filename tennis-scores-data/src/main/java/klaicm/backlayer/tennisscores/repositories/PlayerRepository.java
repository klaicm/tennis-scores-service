package klaicm.backlayer.tennisscores.repositories;

import klaicm.backlayer.tennisscores.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
