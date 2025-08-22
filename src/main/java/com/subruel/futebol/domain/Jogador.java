package com.subruel.futebol.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@NamedQueries({
        @NamedQuery(name = "Jogador.findByName", query = "SELECT j FROM Jogador j WHERE j.nome = :nome"),
        @NamedQuery(name = "Jogador.findByStatus", query = "SELECT j FROM Jogador j WHERE j.status = :status"),
        @NamedQuery(name = "Jogador.findByTime", query = "SELECT j FROM Jogador j WHERE j.time.nome = :nomeTime")
})
public class Jogador {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String posicao;
    private String status;
}
