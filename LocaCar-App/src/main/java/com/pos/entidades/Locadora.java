/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Created on : 12/01/2015, 09:19:02
 *
 * @author Elis Oliveira
 */

@Entity
@NamedQueries({
    @NamedQuery(name = Locadora.BUSCAR_TODAS_AS_LOCADORAS, query = "SELECT l FROM Locadora l ORDER BY l.nome"),
    @NamedQuery(name = Locadora.BUSCAR_TODAS_AS_LOCADORAS_PELO_ID, query = "SELECT l FROM Locadora l WHERE l.id=:id")
})
public class Locadora implements Serializable {

    public static final String BUSCAR_TODAS_AS_LOCADORAS = "buscar.todas.as.locadoras";
    public static final String BUSCAR_TODAS_AS_LOCADORAS_PELO_ID = "buscar.todas.as.locadoras.pelo.id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco endereco;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Carro> carros = new ArrayList();

    public Locadora() {
    }

    public Locadora(int id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public String toString() {
        return "Locadora{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", carros=" + carros + '}';
    }

}
