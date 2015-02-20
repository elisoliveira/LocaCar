/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.services;

import com.pos.dao.DaoImpl;
import com.pos.entidades.Carro;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Magdiel Ildefonso
 */
@WebService(serviceName = "ManterCarroService")
public class ManterCarroService {

    /**
     * This is a sample web service operation
     */
    @PersistenceContext(name = "LOCACAR-PU")
    private EntityManager manager;
    @Resource
    private UserTransaction transaction;
    private DaoImpl dao;

    /**
     * This is a sample web service operation
     * @param carro
     */
    @WebMethod(operationName = "cadastrarCarro")
    public void addCarro(Carro carro) {
        dao.salva(carro);
    }

    @WebMethod(operationName = "atualizaCarro")
    public void atualiza(Carro carro) {
        dao.atualiza(carro);
    }

    @WebMethod(operationName = "excluirCarro")
    public void deleta(Carro carro) {
        dao.deleta(carro);
    }

    @PostConstruct
    public void onConstruct() {
        dao = new DaoImpl(manager, transaction);

    }

    @PreDestroy
    public void onDestroy() {
        manager = null;
        dao = null;
    }
}
