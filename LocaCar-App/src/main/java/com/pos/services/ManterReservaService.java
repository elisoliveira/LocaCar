/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.services;

import com.pos.dao.DaoImpl;
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
@WebService(serviceName = "ManterReservaService")
public class ManterReservaService {

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
     * @param reserva
     */
    @WebMethod(operationName = "cadastrarReserva")
    public void addReserva(Reserva reserva) {
        dao.salva(reserva);
    }

    @WebMethod(operationName = "atualizarReserva")
    public void atualiza(Reserva reserva) {
        dao.atualiza(reserva);
    }

    @WebMethod(operationName = "excluirReserva")
    public void deleta(Reserva reserva) {
        dao.deleta(reserva);
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
