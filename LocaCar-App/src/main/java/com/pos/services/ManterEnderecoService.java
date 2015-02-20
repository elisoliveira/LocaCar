/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.services;

import com.pos.dao.DaoImpl;
import com.pos.entidades.Endereco;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 * Created on : 20/02/2015, 12:39:13
 * @author Elis Oliveira
 */

@WebService(serviceName = "ManterEnderecoService")
public class ManterEnderecoService {
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
     * @param endereco
     */
    @WebMethod(operationName = "cadastrarEndereco")
    public void addEndereco(Endereco endereco) {
        dao.salva(endereco);
    }

    @WebMethod(operationName = "atualizarEndereco")
    public void atualiza(Endereco endereco) {
        dao.atualiza(endereco);
    }

    @WebMethod(operationName = "excluirEndereco")
    public void deleta(Endereco endereco) {
        dao.deleta(endereco);
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
