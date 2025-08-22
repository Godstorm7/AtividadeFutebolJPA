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
        @NamedQuery(name = "Time.findCampeonatos", query = "SELECT c FROM Campeonato c JOIN c.times t WHERE t.nome = :nomeTime")
})
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id")
    private Tecnico tecnico;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id")
    private Set<Jogador> jogadores;
}
