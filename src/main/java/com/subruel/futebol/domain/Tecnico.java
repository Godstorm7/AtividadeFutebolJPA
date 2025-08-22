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
        @NamedQuery(name = "Tecnico.findAll",
                query = "SELECT t FROM Tecnico t"),
        @NamedQuery(name = "Tecnico.findJogadoresTreinadosPeloTecnico",
                query = "SELECT j FROM Jogador j JOIN j.time t JOIN t.tecnico tec  WHERE tec.nome = :nomeTecnico")
})
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
