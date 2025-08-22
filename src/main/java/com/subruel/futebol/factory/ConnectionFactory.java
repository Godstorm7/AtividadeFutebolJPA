package com.subruel.futebol.factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;

public class ConnectionFactory {
    private EntityManagerFactory emf;

    private EntityManager em;

    public ConnectionFactory(){
        emf = Persistence.createEntityManagerFactory("AtividadeFutebolPU");
    }
    public EntityManager getEntityManager(){
        if (Objects.isNull(em) || !em.isOpen()){
            em = emf.createEntityManager();
        }
        return em;
    }
    public void initTransaction(){
        em.getTransaction().begin();
    }
    public void commitTransaction(){
        em.getTransaction().commit();
    }
    public void closeTransaction(){
        em.close();
    }
}
