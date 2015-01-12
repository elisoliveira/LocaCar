/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Created on : 12/01/2015, 11:38:42
 *
 * @author Elis Oliveira
 */
public class DaoImpl implements Dao {

    private EntityManager manager;
    private UserTransaction transaction;

    public DaoImpl(EntityManager manager, UserTransaction transaction) {
        this.manager = manager;
        this.transaction = transaction;
    }

    @Override
    public void salva(Object object) {
        try {
            transaction.begin();
            manager.persist(object);
            transaction.commit();
            System.out.println("SALVOU!");
        } catch (SystemException | RollbackException | HeuristicMixedException |
                HeuristicRollbackException | SecurityException |
                IllegalStateException | NotSupportedException ex) {
        }
    }

    @Override
    public Object busca(Class classe, Long id) {
        return manager.find(classe, id);
    }

    @Override
    public void atualiza(Object object) {
        try {
            transaction.begin();
            manager.merge(object);
            transaction.commit();
            System.out.println("ATUALIZOU!!!");
        } catch (SystemException | RollbackException | HeuristicMixedException |
                HeuristicRollbackException | SecurityException |
                IllegalStateException | NotSupportedException ex) {

        }
    }

    @Override
    public void deleta(Object object) {
        try {
            transaction.begin();
            manager.remove(object);
            transaction.commit();
            System.out.println("DELETOU");
        } catch (SystemException | RollbackException | HeuristicMixedException |
                HeuristicRollbackException | SecurityException |
                IllegalStateException | NotSupportedException ex) {
        }
    }

    @Override
    public Object buscaObjetoComNamedQuery(String namedQuery, Map<String, Object> parametros) {
        Query query = manager.createNamedQuery(namedQuery);
        if (parametros != null) {
            for (String nomeParametro : parametros.keySet()) {
                query.setParameter(nomeParametro, parametros.get(nomeParametro));
            }
        }
        return query.getSingleResult();
    }

    @Override
    public List buscaListaComNamedQuery(String namedQuery, Map<String, Object> parametros) {
        Query query = manager.createNamedQuery(namedQuery);
        if (parametros != null) {
            for (String nomeParametro : parametros.keySet()) {
                query.setParameter(nomeParametro, parametros.get(nomeParametro));
            }
        }
        return query.getResultList();
    }

    @Override
    public Object buscaObjetoComJPQLQuery(String jpqlQuery, Map<String, Object> parametros) {
        Query query = manager.createQuery(jpqlQuery);
        if (parametros != null) {
            for (String nomeParametro : parametros.keySet()) {
                query.setParameter(nomeParametro, parametros.get(nomeParametro));
            }
        }
        return query.getSingleResult();
    }

    @Override
    public List buscaListaComJPQLQuery(String jpqlQuery, Map<String, Object> parametros) {
        Query query = manager.createQuery(jpqlQuery);
        if (parametros != null) {
            for (String nomeParametro : parametros.keySet()) {
                query.setParameter(nomeParametro, parametros.get(nomeParametro));
            }
        }
        return query.getResultList();
    }
}
