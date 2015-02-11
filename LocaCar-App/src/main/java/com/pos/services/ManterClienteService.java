/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.services;

import com.pos.dao.DaoImpl;
import com.pos.entidades.Cliente;
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
@WebService(serviceName = "ManterClienteService")
public class ManterClienteService {
    
    @PersistenceContext(name = "LOCACAR-PU")
    private EntityManager manager;
    @Resource
    private UserTransaction transaction;
    private DaoImpl dao;
    
    /**
     * This is a sample web service operation
     */
    
    @WebMethod(operationName = "cadastrarCliente")
    public void addCliente(Cliente cliente){
        dao.salva(cliente);
    }
    
    @WebMethod(operationName = "atualizaCliente")
    public void atualiza(Cliente cliente) {
        dao.atualiza(cliente);
    }

    @WebMethod(operationName = "excluirCliente")
    public void deleta(Cliente cliente) {
        dao.deleta(cliente);
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
