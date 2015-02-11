/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.services;

import com.pos.dao.DaoImpl;
import com.pos.entidades.Funcionario;
import com.pos.entidades.Reserva;
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
public class ManterFuncionarioService {

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
    public void addCliente(Funcionario funcionario) {
        dao.salva(funcionario);
    }

    @WebMethod(operationName = "atualizarFuncionario")
    public void atualiza(Funcionario funcionario) {
        dao.atualiza(funcionario);
    }

    @WebMethod(operationName = "excluirFuncionario")
    public void deleta(Funcionario funcionario) {
        dao.deleta(funcionario);
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
