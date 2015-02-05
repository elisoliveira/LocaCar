/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.managedBean;

import com.pos.dao.Dao;
import com.pos.dao.DaoImpl;
import com.pos.entidades.Carro;
import com.pos.entidades.Cliente;
import com.pos.entidades.Reserva;
import com.pos.entidades.TipoStatusReserva;
import java.util.Date;
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
 * Created on : 04/02/2015, 21:42:55
 *
 * @author Elis Oliveira
 */
@ManagedBean(name = "carroMB")
@RequestScoped
public class CarroController {

    @PersistenceContext(name = "LOCACAR-PU")
    private EntityManager manager;
    @Resource
    private UserTransaction transaction;
    private Dao dao;
    private Carro carro;
    private Reserva reserva;
    private Cliente cliente;
    
    
    public void reservaCarro(){
        Date dataEntrada = new Date();
        
        try {
            
            reserva.setDataInicioReserva(dataEntrada);
            reserva.setCliente(cliente);
            reserva.setCarro(carro);

            dao.salva(reserva);
            
            carro.setStatusReserva(TipoStatusReserva.RESERVADO);
            dao.atualiza(carro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Sucesso!",
                    "Carro reservado com sucesso!"));
            
            System.out.println("reservou e atualizou");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "ERRO!",
                    "Erro ao tentar reservar o carro escolhido."));
            
        }
        
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
