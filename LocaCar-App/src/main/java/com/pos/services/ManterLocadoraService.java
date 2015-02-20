/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.services;

import com.pos.dao.DaoImpl;
import com.pos.entidades.Locadora;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 * Created on : 20/02/2015, 10:30:58
 * @author Elis Oliveira
 */
@WebService(serviceName = "ManterLocadoraService")
public class ManterLocadoraService {
    
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
     * @param locadora
     */
    @WebMethod(operationName = "cadastrarLocadora")
    public void addLocadora(Locadora locadora) {
        dao.salva(locadora);
    }

    @WebMethod(operationName = "atualizaLocadora")
    public void atualiza(Locadora locadora) {
        dao.atualiza(locadora);
    }

    @WebMethod(operationName = "excluirLocadora")
    public void deleta(Locadora locadora) {
        dao.deleta(locadora);
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
