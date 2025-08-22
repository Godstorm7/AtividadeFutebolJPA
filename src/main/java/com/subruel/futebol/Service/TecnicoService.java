package com.subruel.futebol.Service;


import com.subruel.futebol.domain.Jogador;
import com.subruel.futebol.domain.Tecnico;
import com.subruel.futebol.factory.ConnectionFactory;

import java.util.List;

public class TecnicoService {
    private ConnectionFactory con;

    public TecnicoService() {
        con = new ConnectionFactory();
    }

    /*public void saveAndUpdate(Tecnico tecnico) {
        try {
            con.getEntityManager();
            con.initTransaction();
            con.getEntityManager().merge(tecnico);
            con.commitTransaction();
            con.closeTransaction();
        } catch (Exception e) {
            System.out.println("Error while saving or updating tecnico: " + e.getMessage());
        }
    }*/
    public List<Jogador> getJogadoresTreinadosPeloTecnico(String nomeTecnico) {
        try {
            con.getEntityManager();
            con.initTransaction();
            var query = con.getEntityManager().createNamedQuery("Tecnico.findJogadoresTreinadosPeloTecnico", Jogador.class);
            query.setParameter("nomeTecnico", nomeTecnico);
            List<Jogador> jogadores = query.getResultList();
            con.closeTransaction();
            return jogadores;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching jogadores treinados pelo tecnico: " + e.getMessage());
        }
    }
}
