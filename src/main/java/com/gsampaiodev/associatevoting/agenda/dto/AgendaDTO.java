package com.gsampaiodev.associatevoting.agenda.dto;

import com.gsampaiodev.associatevoting.vote.dto.VoteDTO;

import java.time.LocalDateTime;
import java.util.List;

public record AgendaDTO(
        Integer id,
        LocalDateTime deadline,
        String title,
        String description,
        List<VoteDTO> votes
) {
}