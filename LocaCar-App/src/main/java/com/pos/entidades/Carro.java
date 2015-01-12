/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created on : 12/01/2015, 09:21:52
 *
 * @author Elis Oliveira
 */
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private boolean statusReserva;
    private float valor;
    private int ano;
    private String placa;

    //coloquei a reserva aqui pra facilitar as consultas!
    //e tbm coloquei carro em reserva.
    @OneToOne
    private Reserva reserva;

    public Carro() {
    }

    public Carro(int id, String nome, boolean statusReserva, float valor, int ano, String placa, Reserva reserva) {
        this.id = id;
        this.nome = nome;
        this.statusReserva = statusReserva;
        this.valor = valor;
        this.ano = ano;
        this.placa = placa;
        this.reserva = reserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(boolean statusReserva) {
        this.statusReserva = statusReserva;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", nome=" + nome + ", statusReserva=" + statusReserva + ", valor=" + valor + ", ano=" + ano + ", placa=" + placa + ", reserva=" + reserva + '}';
    }

}
