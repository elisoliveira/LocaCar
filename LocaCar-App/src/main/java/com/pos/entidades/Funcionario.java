/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created on : 12/01/2015, 09:57:53
 *
 * @author Elis Oliveira
 */
@Entity
@DiscriminatorValue("funcionario")
public class Funcionario extends Pessoa {

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String login, String senha) {
        super(id, nome, login, senha);
    }

}
