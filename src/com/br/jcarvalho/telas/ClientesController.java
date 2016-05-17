/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author frede
 */
public class ClientesController implements Initializable {

    @FXML
    private ComboBox<String> cb_estados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load_estados();
    }

    private void load_estados() {
        cb_estados.getItems().add("Acre (AC)");
        cb_estados.getItems().add("Alagoas (AL)");
        cb_estados.getItems().add("Amapá (AP)");
        cb_estados.getItems().add("Amazonas (AM)");
        cb_estados.getItems().add("Bahia (BA)");
        cb_estados.getItems().add("Ceará (CE)");
        cb_estados.getItems().add("Distrito Federal (DF)");
        cb_estados.getItems().add("Espírito Santo (ES)");
        cb_estados.getItems().add("Goiás (GO)");
        cb_estados.getItems().add("Maranhão (MA)");
        cb_estados.getItems().add("Mato Grosso (MT)");
        cb_estados.getItems().add("Mato Grosso do Sul (MS)");
        cb_estados.getItems().add("Minas Gerais (MG)");
        cb_estados.getItems().add("Paraíba (PB)");
        cb_estados.getItems().add("Paraná (PR)");
        cb_estados.getItems().add("Pernambuco (PE)");
        cb_estados.getItems().add("Rio de Janeiro (RJ)");
        cb_estados.getItems().add("Rio Grande do Norte (RN)");
        cb_estados.getItems().add("Rio Grande do Sul (RS)");
        cb_estados.getItems().add("Rondônia (RO)");
        cb_estados.getItems().add("Roraima (RR)");
        cb_estados.getItems().add("Santa Catarina (SC)");
        cb_estados.getItems().add("São Paulo (SP)");
        cb_estados.getItems().add("Sergipe (SE)");
        cb_estados.getItems().add("Tocantins (TO)");
        
        cb_estados.getSelectionModel().select(0);
    }

}
