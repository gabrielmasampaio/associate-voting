package com.gsampaiodev.associatevoting.agenda.repository;

import com.gsampaiodev.associatevoting.agenda.model.Agenda;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface AgendaRepository extends ListCrudRepository<Agenda, Integer> {

    List<Agenda> findAll();

    @Override
    Optional<Agenda> findById(Integer integer);

    Agenda save(Agenda agenda);

    void delete(Agenda agenda);

    void deleteById(Integer id);

}
