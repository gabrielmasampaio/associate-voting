package com.gsampaiodev.associatevoting.agenda.controller;

import com.gsampaiodev.associatevoting.agenda.model.Agenda;
import com.gsampaiodev.associatevoting.agenda.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    AgendaService agendaService;

    AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }

    @GetMapping
    ResponseEntity<List<Agenda>> getAllAgenda(){
        List<Agenda> agendas = agendaService.getAllAgenda();
        return ResponseEntity.ok().body(agendas);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getAgenda(@PathVariable Integer id) {
        Agenda agenda = agendaService.getAgendaById(id);
        if (Objects.isNull(agenda)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agenda not found for id");
        }
        return ResponseEntity.ok().body(agenda);
    }

    @PostMapping
    ResponseEntity<?> postAgenda(@RequestBody Agenda newAgenda){
        Agenda agendaCreated = agendaService.createNewAgenda(newAgenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaCreated);
    }

    @PatchMapping("/{id}/openSession")
    ResponseEntity<?> openSession(@PathVariable Integer id, @RequestParam(name = "deadline", required = false) LocalDateTime newDeadLine){
        Agenda agenda = agendaService.getAgendaById(id);
        if(Objects.isNull(agenda)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agenda not found for id");
        }
        if(Objects.isNull(newDeadLine)){
            newDeadLine = LocalDateTime.now().plusMinutes(1);
        }
        agenda = agendaService.updateAgendaDeadline(agenda, newDeadLine);
        return ResponseEntity.ok().body(agenda);

    }

}
