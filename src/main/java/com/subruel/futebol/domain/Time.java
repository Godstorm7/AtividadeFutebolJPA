package com.subruel.futebol.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@NamedQueries({
        @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t"),
        @NamedQuery(name = "Time.findByName", query = "SELECT t FROM Time t WHERE t.nome = :nome"),
        @NamedQuery(name = "Time.findByJogador", query = "SELECT t FROM Time t JOIN t.jogadores j WHERE j.nome = :nomeJogador"),
        @NamedQuery(name = "Time.findCampeonatos", query = "SELECT c FROM Time t JOIN t.campeonatos c")
})
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @OneToMany
    @JoinColumn(name = "jogador_id")
    private Set<Jogador> jogadores;
}
