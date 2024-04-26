package com.gsampaiodev.associatevoting.vote.dto;

public record VoteDTO(
        Integer id,
        boolean accepted,
        long associateId
) {
}