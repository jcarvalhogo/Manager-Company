/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.model.Contatowebcli;
import com.br.jcarvalho.model.Telcliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author frede
 */
public class ClientesController implements Initializable {

    private Telcliente telcliente;
    private ObservableList<Telcliente> telefones;

    private Contatowebcli contatowebcli;
    private ObservableList<Contatowebcli> conatatosweb;

    @FXML
    private ComboBox<String> cb_estados;

    @FXML
    private TabPane tbp_cadastro;

    @FXML
    private TableView<Contatowebcli> tbw_contatosWeb;
    @FXML
    private TableColumn<Contatowebcli, String> tbc_web_url;
    @FXML
    private TableColumn<Contatowebcli, String> tbc_web_tipo;
    @FXML
    private TableColumn<Contatowebcli, String> tbc_web_obs;

    @FXML
    private TableView<Telcliente> tbw_telcliente;
    @FXML
    private TableColumn<Telcliente, String> tbc_tel_operadora;
    @FXML
    private TableColumn<Telcliente, String> tbc_tel_numero;
    @FXML
    private TableColumn<Telcliente, String> tbc_tel_tipo;
    @FXML
    private TableColumn<Telcliente, String> tbc_tel_obs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load_estados();

        tbp_cadastro.getSelectionModel().select(0);
        initTabViewTelCliente();
        initTabViewContatosWeb();
    }

    private void initTabViewTelCliente() {
        tbc_tel_numero.setCellValueFactory(new PropertyValueFactory<>("numeroTelCli"));
        tbc_tel_obs.setCellValueFactory(new PropertyValueFactory<>("obsTelCli"));
        tbc_tel_operadora.setCellValueFactory(new PropertyValueFactory<>("operadorTelCli"));
        tbc_tel_tipo.setCellValueFactory(new PropertyValueFactory<>("tipoTelCli"));

        telefones = FXCollections.observableArrayList();
        tbw_telcliente.setItems(telefones);
    }
    
    private void initTabViewContatosWeb() {
        tbc_web_url.setCellValueFactory(new PropertyValueFactory<>("urlWebCli"));
        tbc_web_tipo.setCellValueFactory(new PropertyValueFactory<>("tipoWebCli"));
        tbc_web_obs.setCellValueFactory(new PropertyValueFactory<>("obsWebCli"));

        conatatosweb = FXCollections.observableArrayList();
        tbw_contatosWeb.setItems(conatatosweb);
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

    @FXML
    private void addTelefone(ActionEvent event) {
        telcliente = new Telcliente();

        telcliente.setIdCliFis(null);
        telcliente.setIdTelCli(1);
        telcliente.setObsTelCli("Teste");
        telcliente.setNumeroTelCli("(62)-8626-0025");
        telcliente.setTipoTelCli("movel");
        telcliente.setOperadorTelCli("tim");

        telefones.add(telcliente);
    }

    @FXML
    private void removerTelefone(ActionEvent event) {
        int index = tbw_telcliente.getSelectionModel().getSelectedIndex();
        if (index > -1) {
            telefones.remove(index);
        }
    }

}
