/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.model.Tipoconweb;
import com.br.jcarvalho.util.DBAction;
import com.br.jcarvalho.util.IntegracaoConsultas;
import com.br.jcarvalho.util.IntegracaoPersistencia;
import com.br.jcarvalho.util.ItemComboBox;
import com.br.jcarvalho.util.MsgBarra;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Josemar
 */
public class TipoConWebController implements Initializable, IntegracaoConsultas, IntegracaoPersistencia {

    private Tipoconweb tipoconweb;

    @FXML
    private HBox barra_ferrameta;
    @FXML
    private TextField tf_descriacao;
    @FXML
    private TextArea ta_obs;
    @FXML
    private Label lb_estatus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lb_estatus.setText(MsgBarra.NORMAL);
        barra_ferrameta.getChildren().add(LoaderFxml.getBarraPersistencia(this, getStageConsulta()));
    }

    private Stage getStageConsulta() {
        List<ItemComboBox> itens = new ArrayList<>();
        itens.add(new ItemComboBox("Todos", "Tipoconweb.findAll", "", null));
        itens.add(new ItemComboBox("Código", "Tipoconweb.findByIdConWeb", "idConWeb", Integer.class));
        itens.add(new ItemComboBox("Tipo Contato", "findByDesciracaoConWeb", "desciracaoConWeb", String.class));

        ObservableList<Tipoconweb> observableList = FXCollections.observableArrayList();
        TableView<Tipoconweb> table = new TableView<>();
        table.setItems(observableList);

        TableColumn<Tipoconweb, Integer> cl_id = new TableColumn<>("ID");
        cl_id.setMaxWidth(80);
        cl_id.setCellValueFactory(new PropertyValueFactory<>("idConWeb"));

        TableColumn<Tipoconweb, String> cl_descricao = new TableColumn<>("Descrição");
        cl_descricao.setMinWidth(520);
        cl_descricao.setCellValueFactory(new PropertyValueFactory<>("desciracaoConWeb"));

        return LoaderFxml.getStageConsulta(
                Tipoconweb.class,
                itens,
                this,
                "Cosulta de Contatos Web",
                600, 500, table,
                observableList,
                cl_id, cl_descricao);

    }

    @Override
    public boolean setObjectConsulta(Object object) {
        tipoconweb = (Tipoconweb) object;
        tf_descriacao.setText(tipoconweb.getDesciracaoConWeb());
        ta_obs.setText(tipoconweb.getObsConWeb());
        return true;
    }

    @Override
    public Object getObject(int action) {
        switch (action) {
            case DBAction.SALVAR:
                tipoconweb = new Tipoconweb();
                tipoconweb.setDesciracaoConWeb(tf_descriacao.getText());
                tipoconweb.setObsConWeb(ta_obs.getText());
                break;
            case DBAction.CANCELAR:
                tipoconweb = null;
                lb_estatus.setText(MsgBarra.CANCEL);
                break;
            case DBAction.EDITAR:
                lb_estatus.setText(MsgBarra.EDITE);
                break;
            case DBAction.NOVO:
                limpartudo();
                lb_estatus.setText(MsgBarra.NOVO);
                setFocus();
                break;
            default:
                return null;
        }

        return tipoconweb;
    }

    @Override
    public boolean isShowMessage() {
        return true;
    }

    @Override
    public boolean reflesh() {
        return true;
    }

    @Override
    public boolean limpartudo() {
        tf_descriacao.setText("");
        ta_obs.setText("");
        return true;
    }

    @Override
    public void setFocus() {
        tf_descriacao.requestFocus();
    }

}
