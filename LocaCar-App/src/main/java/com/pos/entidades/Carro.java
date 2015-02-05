/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Created on : 12/01/2015, 09:21:52
 *
 * @author Elis Oliveira
 */
@Entity
@NamedQueries({ 
    @NamedQuery(name = Carro.BUSCAR_TODOS_CARROS, query="SELECT c FROM Carro c ORDER BY c.nome"),
    @NamedQuery(name = Carro.BUSCAR_TODOS_CARROS_DISPONIVEIS, query="SELECT c FROM Carro c WHERE c.statusReserva='DISPONIVEL'"),
    @NamedQuery(name = Carro.BUSCAR_TODOS_CARROS_DISPONIVEL_PELO_ID_LOCADORA, query="SELECT c FROM Locadora l JOIN l.carros as c WHERE c.status='DISPONIVEL' AND l.id=:id"),
    @NamedQuery(name = Carro.BUSCAR_TODOS_CARROS_PELO_ID, query="SELECT c FROM Carro c WHERE c.id=:id")
})
public class Carro implements Serializable {

    public static final String BUSCAR_TODOS_CARROS = "buscar.todos.carros";
    public static final String BUSCAR_TODOS_CARROS_DISPONIVEIS = "buscar.todos.carros.disponiveis";
    public static final String BUSCAR_TODOS_CARROS_DISPONIVEL_PELO_ID_LOCADORA = "buscar.todos.carros.disponiveis.pelo.id.locadora";
    public static final String BUSCAR_TODOS_CARROS_PELO_ID = "buscar.todos.carros.pelo.id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoStatusReserva statusReserva;
    private float valor;
    private int ano;
    private String placa;

    @OneToOne
    private Reserva reserva;

    @ManyToOne
    private Locadora locadora;

    public Carro() {
    }

    public Carro(int id, String nome, TipoStatusReserva statusReserva, float valor, int ano, String placa, Reserva reserva) {
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

    public TipoStatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(TipoStatusReserva statusReserva) {
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

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", nome=" + nome + ", statusReserva=" + statusReserva + ", valor=" + valor + ", ano=" + ano + ", placa=" + placa + ", reserva=" + reserva + '}';
    }

}
