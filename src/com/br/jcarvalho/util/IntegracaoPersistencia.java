/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.util;

/**
 *
 * @author Josemar
 */
public interface IntegracaoPersistencia {

    public Object getObject();

    public boolean setObject(Object object);

    public boolean isShowMessage();

    public boolean reflesh();
}
