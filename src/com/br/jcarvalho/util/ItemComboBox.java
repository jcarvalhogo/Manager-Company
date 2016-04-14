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
public class ItemComboBox {

    private final String item;
    private final String nameQuery;
    private final String parametro;
    private final Class tipo;

    public ItemComboBox(String item, String nameQuery, String parametro, Class tipo) {
        this.item = item;
        this.nameQuery = nameQuery;
        this.parametro = parametro;
        this.tipo = tipo;
    }

    public String getItem() {
        return item;
    }

    public String getNameQuery() {
        return nameQuery;
    }

    public String getParametro() {
        return parametro;
    }

    public Class getTipo() {
        return tipo;
    }

}
