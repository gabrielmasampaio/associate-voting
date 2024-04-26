package com.gsampaiodev.associatevoting.agenda.model;

import com.gsampaiodev.associatevoting.vote.model.Vote;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
public class Agenda {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        @NotNull LocalDateTime deadline;
        @OneToMany(mappedBy = "agenda")
        List<Vote> votes;
        @NotNull String title;
        String description;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public LocalDateTime getDeadline() {
                return deadline;
        }

        public void setDeadline(LocalDateTime deadline) {
                this.deadline = deadline;
        }

        public List<Vote> getVotes() {
                return votes;
        }

        public void setVotes(List<Vote> votes) {
                this.votes = votes;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Agenda agenda = (Agenda) o;
                return Objects.equals(id, agenda.id) && Objects.equals(deadline, agenda.deadline) && Objects.equals(votes, agenda.votes) && Objects.equals(title, agenda.title) && Objects.equals(description, agenda.description);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, deadline, votes, title, description);
        }

        @Override
        public String toString() {
                return "Agenda{" +
                        "id=" + id +
                        ", deadline=" + deadline +
                        ", votes=" + votes +
                        ", title='" + title + '\'' +
                        ", description='" + description + '\'' +
                        '}';
        }
}
