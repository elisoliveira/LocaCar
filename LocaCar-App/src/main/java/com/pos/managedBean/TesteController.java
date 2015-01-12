/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.managedBean;

import com.pos.dao.Dao;
import com.pos.dao.DaoImpl;
import com.pos.entidades.Cliente;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 * Created on : 12/01/2015, 11:53:09
 *
 * @author Elis Oliveira
 */
@ManagedBean(name = "testeMB")
@RequestScoped
public class TesteController {

    @PersistenceContext(name = "LOCACAR-PU")
    private EntityManager manager;
    @Resource
    private UserTransaction transaction;
    private Dao dao;

    public void teste() {
        Cliente cliente = new Cliente();
        cliente.setNome("Elisiany");
        cliente.setLogin("elis");
        cliente.setSenha("123");

        try {
            dao.salva(cliente);

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao tentar cadastrar!",
                    "Detalhes do Erro: " + ex.getMessage() + ". Tente novamente mais tarde."));
        }

        System.out.println("cliente criado: " + cliente.toString());
    }

    //Não apagar
    @PostConstruct
    public void onConstruct() {
        dao = new DaoImpl(manager, transaction);

    }

    //Não apagar
    @PreDestroy
    public void onDestroy() {
        manager = null;
        dao = null;
    }

}
