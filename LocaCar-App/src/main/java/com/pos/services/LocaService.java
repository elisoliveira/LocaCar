/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.services;

import com.pos.dao.DaoImpl;
import com.pos.entidades.Carro;
import com.pos.entidades.Locadora;
import com.pos.managedBean.CarroController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Magdiel Ildefonso
 */
@WebService(serviceName = "LocaService")
public class LocaService {
    
    @PersistenceContext(name = "LOCACAR-PU")
    private EntityManager manager;
    @Resource
    private UserTransaction transaction;
    @EJB
    private CarroController carcontrol;
    
    private final DaoImpl dao = new DaoImpl(manager, transaction);
    /**
     * This is a sample web service operation
     * @return 
     */
         
    @WebMethod(operationName = "getCarros")
    public List<Carro> getCarros(){
        return (List<Carro>) dao.buscaObjetoComNamedQuery(Carro.BUSCAR_TODOS_CARROS, null);
    }
    
    @WebMethod(operationName = "getCarrosDisponiveis")
    public List<Carro> getCarrosDisponiveis(){
        return (List<Carro>) dao.buscaListaComNamedQuery(Carro.BUSCAR_TODOS_CARROS_DISPONIVEIS, null);
    }
    
    @WebMethod(operationName = "getCarrosDisponiveisPorIdLocadora")
    public List<Carro> getCarrosDisponiveisPorIdLocaldora(int idLocadora){
        Map<String, Object> params = new HashMap();
        params.put("id", idLocadora);
        return (List<Carro>) dao.buscaListaComNamedQuery(Carro.BUSCAR_TODOS_CARROS_DISPONIVEL_PELO_ID_LOCADORA, params);
    }
    
    @WebMethod(operationName = "getCarroPorId")
    public Carro getCarroPorId(int idCarro){
        Map<String, Object> params = new HashMap();
        params.put("id", idCarro);
        return (Carro) dao.buscaListaComNamedQuery(Carro.BUSCAR_TODOS_CARROS_PELO_ID, params);
    }
    
    @WebMethod(operationName = "getLocadoras")
    public Locadora getLocadoras(){
        return (Locadora) dao.buscaListaComNamedQuery(Locadora.BUSCAR_TODAS_AS_LOCADORAS, null);
    }
    
    @WebMethod(operationName = "getLocadoraPorId")
    public Locadora getLocadoraPorId(int idLocadora){
        Map<String, Object> params = new HashMap();
        params.put("id", idLocadora);
        return (Locadora) dao.buscaObjetoComNamedQuery(Locadora.BUSCAR_TODAS_AS_LOCADORAS_PELO_ID, params);
    }
    
    @WebMethod(operationName = "reservarCarro")
    public void reservarCarro(int idCarro){
        carcontrol.reservaCarro(idCarro);
    }
}
