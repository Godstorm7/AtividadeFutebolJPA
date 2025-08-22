package com.subruel.futebol;

import com.subruel.futebol.Service.CampeonatoService;
import com.subruel.futebol.Service.JogadorService;
import com.subruel.futebol.Service.TecnicoService;
import com.subruel.futebol.Service.TimeService;
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
        var tec = Tecnico.builder()
                .nome("Tite")
                .build();

        var tec2 = Tecnico.builder()
                .nome("Felipão")
                .build();

        var jogador = Jogador.builder()
                .nome("CR7")
                .posicao("sla")
                .status("quase aposentado")
                .build();
        var jogador2 = Jogador.builder()
                .nome("Messi")
                .posicao("sla")
                .status("quase aposentado")
                .build();

        var jogador3 = Jogador.builder()
                .nome("Neymar")
                .posicao("sla")
                .status("quase aposentado")
                .build();
        var jogador4 = Jogador.builder()
                .nome("Mbappé")
                .posicao("sla")
                .status("quase aposentado")
                .build();
        var time = Time.builder()
                .nome("Flamengo")
                .tecnico(tec)
                .jogadores(Set.of(jogador, jogador2))
                .build();
        var time2 = Time.builder()
                .nome("Palmeiras")
                .tecnico(tec2)
                .jogadores(Set.of(jogador3, jogador4))
                .build();
        var camp = Campeonato.builder()
                .nome("Brasileirão")
                .inicio(LocalDate.now())
                .fim(LocalDate.now().plusDays(30))
                .times(Set.of(time, time2))
                .build();

        var campeonatoService = new CampeonatoService();
        var timeService = new TimeService();
        var jogadorService = new JogadorService();
        var tecnicoService = new TecnicoService();

//        jogadorService.saveAndUpdate(jogador);
//        jogadorService.saveAndUpdate(jogador2);
//        jogadorService.saveAndUpdate(jogador3);
//        jogadorService.saveAndUpdate(jogador4);
//
//        tecnicoService.saveAndUpdate(tec);
//        tecnicoService.saveAndUpdate(tec2);

//        timeService.saveAndUpdate(time);
//        timeService.saveAndUpdate(time2);


        var camp2 = Campeonato.builder()
                .nome("Copa do Mundo")
                .inicio(LocalDate.now())
                .fim(LocalDate.now().plusDays(60))
                .times(Set.of(timeService.getTimes().getFirst()))
                .build();
        var camp3 = Campeonato.builder()
                .nome("Copa América")
                .inicio(LocalDate.now())
                .fim(LocalDate.now().plusDays(90))
                .times(Set.of(timeService.getTimes().getLast()))
                .build();
//        campeonatoService.saveAndUpdate(camp);
//        campeonatoService.saveAndUpdate(camp2);
//        campeonatoService.saveAndUpdate(camp3);

        //Consultas Times checked
//        System.out.println(timeService.getTimeByNome("Flamengo"));
//        System.out.println(timeService.getTimeByJogador("CR7"));
//        timeService.getCampeonatosByTime("Flamengo")
//                .forEach(c -> {
//                    System.out.println("Campeonato: " + c.getNome());;
//                });



        // Consultas Campeonato checked
//        campeonatoService.getTimesByCampeonato("Brasileirão")
//                .forEach(t -> {
//                    System.out.println("Time: " + t.getNome());;
//                });



        // Consultas Jogador checked
//        System.out.println(jogadorService.getJogadorByNome("CR7"));
//        System.out.println(jogadorService.getJogadorByStatus("quase aposentado"));
//        jogadorService.getJogadorByTime("Flamengo")
//                .forEach(j -> {
//                    System.out.println("Jogador: " + j.getNome());
//                });

        // Consultas Técnico checked
//        tecnicoService.getJogadoresTreinadosPeloTecnico("Tite")
//                .forEach(j -> {
//                    System.out.println("Jogador treinado por Tite: " + j.getNome());
//                });
    }
}