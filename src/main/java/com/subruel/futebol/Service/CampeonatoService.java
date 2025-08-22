package com.subruel.futebol.Service;

import com.subruel.futebol.domain.Campeonato;
import com.subruel.futebol.domain.Time;
import com.subruel.futebol.factory.ConnectionFactory;

import java.util.List;

public class CampeonatoService {
    private ConnectionFactory con;

    public CampeonatoService() {
        con = new ConnectionFactory();
    }
    public void saveAndUpdate(Campeonato campeonato) {
        try {
            con.getEntityManager();
            con.initTransaction();
            con.getEntityManager().merge(campeonato);
            con.commitTransaction();
            con.closeTransaction();
        } catch (Exception e) {
            System.out.println("Error while saving or updating campeonato: " + e.getMessage());
        }
    }
    public List<Time> getTimesByCampeonato(String nomeCampeonato) {
        try {
            con.getEntityManager();
            con.initTransaction();
            var query = con.getEntityManager().createNamedQuery("Campeonato.findTimes", Time.class);
            query.setParameter("nomeCampeonato", nomeCampeonato);
            List<Time> times = query.getResultList();
            con.closeTransaction();
            return times;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching times by campeonato: " + e.getMessage());
        }
    }
}
