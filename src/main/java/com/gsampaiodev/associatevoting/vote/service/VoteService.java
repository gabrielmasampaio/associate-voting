package com.gsampaiodev.associatevoting.vote.service;

import com.gsampaiodev.associatevoting.agenda.model.Agenda;
import com.gsampaiodev.associatevoting.agenda.service.AgendaService;
import com.gsampaiodev.associatevoting.vote.model.Vote;
import com.gsampaiodev.associatevoting.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class VoteService {

    VoteRepository voteRepository;

    AgendaService agendaService;

    VoteService(VoteRepository voteRepository, AgendaService agendaService){
        this.voteRepository = voteRepository;
        this.agendaService = agendaService;
    }

    public List<Vote> getVotesByAgendaId(Integer agendaId) {
        Agenda agenda = agendaService.getAgendaById(agendaId);
        if(Objects.isNull(agenda)){
            return null; //Create Exception
        }
        return voteRepository.findByAgenda(agenda);
    }

    public Vote createVote(Integer agendaId, String accepted, Integer associateId) {
        Agenda agenda = agendaService.getAgendaById(agendaId);
        if(Objects.isNull(agenda)){
            return null; //Create Exception invalid agenda id
        }
        if(accepted.equalsIgnoreCase("yes")
                || accepted.equalsIgnoreCase("no")
                || isAgendaSessionOpen(agenda)){
            Vote vote = new Vote(accepted.equalsIgnoreCase("yes"), associateId, agenda);
            return voteRepository.save(vote);
        } else {
            return null; //Create Exception invalid vote
        }
    }

    public String getResult(Integer agendaId){
        List<Vote> votes = getVotesByAgendaId(agendaId);
        int countAccepted = 0;
        int countNotAccepted = 0;
        for(Vote vote : votes){
            if(vote.isAccepted()){
                countAccepted++;
            } else {
                countNotAccepted++;
            }
        }
        return "Accepted votes: " + countAccepted + "\nNot accepted votes: " + countNotAccepted;
    }

    private boolean isAgendaSessionOpen(Agenda agenda) {
        return agenda.getDeadline().isAfter(LocalDateTime.now());
    }


}
