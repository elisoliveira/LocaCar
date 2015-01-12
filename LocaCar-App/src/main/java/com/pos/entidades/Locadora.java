/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on : 12/01/2015, 09:19:02
 *
 * @author Elis Oliveira
 */
public class Locadora {
   
    private int id;
    private String nome;   
    private Endereco endereco;
    private List<Carro> carros = new ArrayList();

}
