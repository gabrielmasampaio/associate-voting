package com.gsampaiodev.associatevoting.agenda.service;

import com.gsampaiodev.associatevoting.agenda.model.Agenda;
import com.gsampaiodev.associatevoting.agenda.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    public AgendaRepository agendaRepository;

    AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> getAllAgenda() {
        return agendaRepository.findAll();
    }

    public Agenda getAgendaById(Integer id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        return agenda.orElse(null);
    }

    public Agenda createNewAgenda(Agenda newAgenda) {
        return agendaRepository.save(newAgenda);
    }

    public Agenda updateAgendaDeadline(Agenda agenda, LocalDateTime deadline) {
        if(deadline.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Deadline must be after today");
        }
        agenda.setDeadline(deadline);
        return agendaRepository.save(agenda);
    }

}
