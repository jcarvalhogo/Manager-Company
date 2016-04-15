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

    public Object getObject(int action);

    public boolean isShowMessage();

    public boolean reflesh();

    public boolean limpartudo();
    public void setFocus();
}
