/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.model.Operadora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Josemar
 */
public class ConsultasController implements Initializable {

    private ObservableList observableList;

    @FXML
    private HBox conteiner_table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initTable(TableView<?> table, ObservableList<? extends Object> observableList, TableColumn<?, ?>... colunas) {
        this.observableList = observableList;
        for (TableColumn coluna : colunas) {
            table.getColumns().add(coluna);
        }

        conteiner_table.getChildren().add(table);
    }

    @FXML
    private void consultar(ActionEvent event) {
        Operadora operadora = new Operadora();

        operadora.setIdOpe(1);
        operadora.setDesciracaoOpe("TIM");

        observableList.add(operadora);
    }

}
