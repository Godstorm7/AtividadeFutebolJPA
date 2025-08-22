package com.subruel.futebol.Service;

import com.subruel.futebol.domain.Campeonato;
import com.subruel.futebol.domain.Time;
import com.subruel.futebol.factory.ConnectionFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TimeService {
    private ConnectionFactory con;

    public TimeService() {
        con = new ConnectionFactory();
    }

    public void saveAndUpdate(Time time) {
        try {
            con.getEntityManager();
            con.initTransaction();
            con.getEntityManager().merge(time);
            con.commitTransaction();
            con.closeTransaction();
        } catch (Exception e) {
            System.out.println("Error while saving or updating time: " + e.getMessage());
        }
    }
    public List<Time> getTimes() {
        try {
            con.getEntityManager();
            con.initTransaction();
            List<Time> times = con.getEntityManager().createNamedQuery("Time.findAll", Time.class).getResultList();
            con.closeTransaction();
            return times;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching times: " + e.getMessage());
        }
    }
    public Time getTimeByNome(String nome) {
        try {
            con.getEntityManager();
            con.initTransaction();
            var query = con.getEntityManager().createNamedQuery("Time.findByName", Time.class);
            query.setParameter("nome", nome);
            Time time = query.getSingleResult();
            con.closeTransaction();
            return time;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching time by name: " + e.getMessage());
        }
    }
    public Time getTimeByJogador(String nomeJogador) {
        try {
            con.getEntityManager();
            con.initTransaction();
            var query = con.getEntityManager().createNamedQuery("Time.findByJogador", Time.class);
            query.setParameter("nomeJogador", nomeJogador);
            Time time = query.getSingleResult();
            con.closeTransaction();
            return time;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching time by jogador: " + e.getMessage());
        }
    }
    public List<Campeonato> getCampeonatosByTime(String time) {
        try{
            con.getEntityManager();
            con.initTransaction();
            List<Campeonato> campeonatos = con.getEntityManager()
                    .createNamedQuery("Time.findCampeonatos", Campeonato.class)
                    .setParameter("nomeTime", time)
                    .getResultList();
            con.closeTransaction();
            return campeonatos;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching campeonatos by time: " + e.getMessage());
        }
    }
}
