package com.gsampaiodev.associatevoting.vote.repository;

import com.gsampaiodev.associatevoting.agenda.model.Agenda;
import com.gsampaiodev.associatevoting.vote.model.Vote;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface VoteRepository extends ListCrudRepository<Vote, Integer> {

    Vote save(Vote vote);

    List<Vote> findByAgenda(Agenda agenda);

}
