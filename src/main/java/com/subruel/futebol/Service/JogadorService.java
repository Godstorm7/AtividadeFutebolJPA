package com.subruel.futebol.Service;

import com.subruel.futebol.domain.Jogador;
import com.subruel.futebol.factory.ConnectionFactory;

public class JogadorService {
    private ConnectionFactory con;

    public JogadorService() {
        con = new ConnectionFactory();
    }

    /*public void saveAndUpdate(Jogador jogador) {
        try {
            con.getEntityManager();
            con.initTransaction();
            con.getEntityManager().merge(jogador);
            con.commitTransaction();
            con.closeTransaction();
        } catch (Exception e) {
            System.out.println("Error while saving or updating jogador: " + e.getMessage());
        }
    }*/

    public Jogador getJogadorByNome(String nomeJogador) {
        try {
            con.getEntityManager();
            con.initTransaction();
            var query = con.getEntityManager().createNamedQuery("Jogador.findByName", Jogador.class);
            query.setParameter("nome", nomeJogador);
            Jogador jogador = query.getSingleResult();
            con.closeTransaction();
            return jogador;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching jogador by nome: " + e.getMessage());
        }
    }
    public Jogador getJogadorByStatus(String status) {
        try {
            con.getEntityManager();
            con.initTransaction();
            var query = con.getEntityManager().createNamedQuery("Jogador.findByStatus", Jogador.class);
            query.setParameter("status", status);
            Jogador jogador = query.getSingleResult();
            con.closeTransaction();
            return jogador;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching jogador by status: " + e.getMessage());
        }
    }
    public Jogador getJogadorByTime(String nomeTime) {
        try {
            con.getEntityManager();
            con.initTransaction();
            var query = con.getEntityManager().createNamedQuery("Jogador.findByTime", Jogador.class);
            query.setParameter("nomeTime", nomeTime);
            Jogador jogador = query.getSingleResult();
            con.closeTransaction();
            return jogador;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching jogador by time: " + e.getMessage());
        }
    }
}
