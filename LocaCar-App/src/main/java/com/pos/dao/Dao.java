/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.dao;

import java.util.List;
import java.util.Map;

/**
 * Created on : 12/01/2015, 11:40:17
 *
 * @author Elis Oliveira
 */
public interface Dao {

    public void salva(Object object);

    public Object busca(Class classe, Long id);

    public void atualiza(Object object);

    public void deleta(Object object);

    public Object buscaObjetoComNamedQuery(String namedQuery, Map<String, Object> parametros);

    public List buscaListaComNamedQuery(String namedQuery, Map<String, Object> parametros);

    public Object buscaObjetoComJPQLQuery(String jpqlQuery, Map<String, Object> parametros);

    public List buscaListaComJPQLQuery(String jpqlQuery, Map<String, Object> parametros);

}
