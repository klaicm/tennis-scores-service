package klaicm.backlayer.tennisscores.services;

import klaicm.backlayer.tennisscores.model.ArchData;

import java.util.Set;

public interface ArchDataService extends CrudService<ArchData, Long> {

    Set<ArchData> getArchDataByPlayerId(Long id);
}
