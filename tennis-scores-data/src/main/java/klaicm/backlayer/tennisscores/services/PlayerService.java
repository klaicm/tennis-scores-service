package klaicm.backlayer.tennisscores.services;

import klaicm.backlayer.tennisscores.model.Player;

public interface PlayerService extends CrudService<Player, Long> {

    Player findByLastName(String lastName);
}
