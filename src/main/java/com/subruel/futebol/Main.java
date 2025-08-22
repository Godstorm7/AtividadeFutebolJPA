package com.subruel.futebol;

import com.subruel.futebol.Service.CampeonatoService;
import com.subruel.futebol.domain.Campeonato;
import com.subruel.futebol.domain.Jogador;
import com.subruel.futebol.domain.Tecnico;
import com.subruel.futebol.domain.Time;

import java.time.LocalDate;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Tecnico tec = Tecnico.builder()
                .nome("Tite")
                .build();

        Tecnico tec2 = Tecnico.builder()
                .nome("Felipão")
                .build();

        Jogador jogador = Jogador.builder()
                .nome("CR7")
                .posicao("sla")
                .status("quase aposentado")
                .build();
        Jogador jogador2 = Jogador.builder()
                .nome("Messi")
                .posicao("sla")
                .status("quase aposentado")
                .build();
        Time time = Time.builder()
                .nome("Flamengo")
                .tecnico(tec)
                .jogadores(Set.of(jogador, jogador2))
                .build();

        Jogador jogador3 = Jogador.builder()
                .nome("Neymar")
                .posicao("sla")
                .status("quase aposentado")
                .build();
        Jogador jogador4 = Jogador.builder()
                .nome("Mbappé")
                .posicao("sla")
                .status("quase aposentado")
                .build();
        Time time2 = Time.builder()
                .nome("Palmeiras")
                .tecnico(tec2)
                .jogadores(Set.of(jogador3, jogador4))
                .build();
        Campeonato camp = Campeonato.builder()
                .nome("Brasileirão")
                .inicio(LocalDate.now())
                .fim(LocalDate.now().plusDays(30))
                .times(Set.of(time, time2))
                .build();

        var campeonatoService = new CampeonatoService();

        campeonatoService.saveAndUpdate(camp);
    }
}