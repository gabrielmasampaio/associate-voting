package com.gsampaiodev.associatevoting.vote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gsampaiodev.associatevoting.agenda.model.Agenda;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"associateId", "agendaId"})
})
public class Vote {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        boolean accepted;
        Integer associateId;
        @ManyToOne
        @JoinColumn(name = "agendaId")
        @JsonIgnore
        Agenda agenda;

        public Vote(boolean accepted, Integer associateId, Agenda agenda) {
                this.accepted = accepted;
                this.associateId = associateId;
                this.agenda = agenda;
        }

        public Vote() {}

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public boolean isAccepted() {
                return accepted;
        }

        public void setAccepted(boolean accepted) {
                this.accepted = accepted;
        }

        public long getAssociateId() {
                return associateId;
        }

        public void setAssociateId(Integer associateId) {
                this.associateId = associateId;
        }

        public Agenda getAgenda() {
                return agenda;
        }

        public void setAgenda(Agenda agenda) {
                this.agenda = agenda;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Vote vote = (Vote) o;
                return accepted == vote.accepted && associateId == vote.associateId && Objects.equals(id, vote.id) && Objects.equals(agenda, vote.agenda);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, accepted, associateId, agenda);
        }

        @Override
        public String toString() {
                return "Vote{" +
                        "id=" + id +
                        ", accepted=" + accepted +
                        ", associateId=" + associateId +
                        ", agenda=" + agenda +
                        '}';
        }
}
