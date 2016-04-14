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

    public ItemComboBox(String item, String nameQuery) {
        this.item = item;
        this.nameQuery = nameQuery;
    }

    public String getItem() {
        return item;
    }

    public String getNameQuery() {
        return nameQuery;
    }

}
