/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.services;

import com.pos.entidades.Carro;
import com.pos.entidades.Locadora;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Magdiel Ildefonso
 */
@WebService(serviceName = "LocaService")
public class LocaService {

    /**
     * This is a sample web service operation
     */
         
    @WebMethod(operationName = "getCarros")
    public List<Carro> getCarros(){
        List<Carro> carros = new ArrayList<>();
        return carros;
    }
    
    @WebMethod(operationName = "getCarrosDisponiveis")
    public List<Carro> getCarrosDisponiveis(){
        List<Carro> carros = new ArrayList<>();
        return carros;
    }
    
    @WebMethod(operationName = "getCarrosDisponiveisPorIdLocadora")
    public List<Carro> getCarrosDisponiveisPorIdLocaldora(int idLocadora){
        List<Carro> carros = new ArrayList<>();
        return carros;
    }
    
    @WebMethod(operationName = "getCarroPorId")
    public Carro getCarroPorId(int idCarro){
        Carro carros = new Carro();
        return carros;
    }
    
    @WebMethod(operationName = "getLocadoras")
    public Locadora getLocadoras(){
        Locadora locadora = new Locadora();
        return locadora;
    }
    
    @WebMethod(operationName = "getLocadoraPorId")
    public Locadora getLocadoraPorId(int idLocadora){
        Locadora locadora = new Locadora();
        return locadora;
    }
    
    @WebMethod(operationName = "reservarCarro")
    public Carro reservarCarro(int idCarro){
        Carro carro = new Carro();
        return carro;
    }
}
