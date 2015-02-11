/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entidades;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created on : 12/01/2015, 09:50:20
 *
 * @author Elis Oliveira
 */
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dataInicioReserva;
    private Date dataFimReserva;

    @OneToOne
    private Carro carro;

    @ManyToOne
    @Basic(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Reserva() {
    }

    public Reserva(int id, Date dataInicioReserva, Date dataFimReserva, Carro carro, Cliente cliente) {
        this.id = id;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.carro = carro;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicioReserva() {
        return dataInicioReserva;
    }

    public void setDataInicioReserva(Date dataInicioReserva) {
        this.dataInicioReserva = dataInicioReserva;
    }

    public Date getDataFimReserva() {
        return dataFimReserva;
    }

    public void setDataFimReserva(Date dataFimReserva) {
        this.dataFimReserva = dataFimReserva;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", dataInicioReserva=" + dataInicioReserva + ", dataFimReserva=" + dataFimReserva + ", carro=" + carro + ", cliente=" + cliente + '}';
    }

}
