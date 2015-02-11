/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.services;

import com.pos.dao.DaoImpl;
import com.pos.entidades.Pessoa;
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
@WebService(serviceName = "ManterFuncionarioService")
public class ManterPessoaService {

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
     */
    @WebMethod(operationName = "cadastrarFuncionario")
    public void addPessoa(Pessoa pessoa) {
        dao.salva(pessoa);
    }

    @WebMethod(operationName = "atualizarFuncionario")
    public void atualiza(Pessoa pessoa) {
        dao.atualiza(pessoa);
    }

    @WebMethod(operationName = "excluirFuncionario")
    public void deleta(Pessoa pessoa) {
        dao.deleta(pessoa);
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
