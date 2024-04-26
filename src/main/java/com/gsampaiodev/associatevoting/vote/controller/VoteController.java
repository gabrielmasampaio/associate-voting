package com.gsampaiodev.associatevoting.vote.controller;

import com.gsampaiodev.associatevoting.vote.model.Vote;
import com.gsampaiodev.associatevoting.vote.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vote")
public class VoteController {

    VoteService voteService;

    VoteController(VoteService voteService) {
        this.voteService = voteService;
    }


    @GetMapping("")
    ResponseEntity<?> getVotesByAgenda(@RequestParam("agendaId") Integer agendaId){
        List<Vote> votes = voteService.getVotesByAgendaId(agendaId);
        if (Objects.isNull(votes)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agenda not found for id");
        }
        return ResponseEntity.ok().body(votes);
    }

    @PostMapping("")
    ResponseEntity<?> createVote(
            @RequestParam("agendaId") Integer agendaId,
            @RequestParam("vote") String accepted,
            @RequestParam("associateId") Integer associateId){
        Vote vote = voteService.createVote(agendaId, accepted, associateId);
        if(Objects.isNull(vote)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to vote for agenda");
        } else {
            return ResponseEntity.ok().body(vote);
        }
    }

    @GetMapping("/result")
    ResponseEntity<?> getResult(@RequestParam("agendaId") Integer agendaId){
        String result = voteService.getResult(agendaId);
        return ResponseEntity.ok().body(result);
    }

}
