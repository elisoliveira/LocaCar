/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Created on : 12/01/2015, 09:57:18
 *
 * @author Elis Oliveira
 */
@Entity
@DiscriminatorValue("cliente")
public class Cliente extends Pessoa {
    
    private String documento;

    public Cliente() {
    }

    public Cliente(List<Reserva> reservas, int id, String nome, String login, String senha, String documento) {
        super(id, nome, login, senha);
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
