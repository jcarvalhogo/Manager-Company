/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.model.Operadora;
import com.br.jcarvalho.util.DBAction;
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
public class OperadoraController implements Initializable, IntegracaoPersistencia {

    private Operadora operadora;

    @FXML
    private HBox barra_ferramenta;
    @FXML
    private TextField tf_operadora;
    @FXML
    private TextArea ta_obs;
    @FXML
    private Label lb_estatus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lb_estatus.setText(MsgBarra.NORMAL);
        barra_ferramenta.getChildren().add(LoaderFxml.getBarraPersistencia(this, getStageConsulta()));

    }

    private Stage getStageConsulta() {
        List<ItemComboBox> itens = new ArrayList<>();
        itens.add(new ItemComboBox("Todos", "Operadora.findAll", "", null));
        itens.add(new ItemComboBox("Código", "Operadora.findByIdOpe", "idOpe", Integer.class));
        itens.add(new ItemComboBox("Operadora", "Operadora.findByDesciracaoOpe", "desciracaoOpe", String.class));

        ObservableList<Operadora> observableList = FXCollections.observableArrayList();
        TableView<Operadora> table = new TableView<>();
        table.setItems(observableList);

        TableColumn<Operadora, Integer> cl_id = new TableColumn<>("ID");
        cl_id.setMaxWidth(80);
        cl_id.setCellValueFactory(new PropertyValueFactory<>("idOpe"));

        TableColumn<Operadora, String> cl_descricao = new TableColumn<>("Operadora");
        cl_descricao.setMinWidth(520);
        cl_descricao.setCellValueFactory(new PropertyValueFactory<>("desciracaoOpe"));

        return LoaderFxml.getStageConsulta(
                Operadora.class,
                itens,
                "Cosulta de Operadoras",
                600, 500, table,
                observableList,
                cl_id, cl_descricao);

    }

    @Override
    public Object getObject(int action) {
        switch (action) {
            case DBAction.SALVAR:
                operadora = new Operadora();
                operadora.setDesciracaoOpe(tf_operadora.getText());
                operadora.setObsOpe(ta_obs.getText());
                break;
            case DBAction.CANCELAR:
                operadora = null;
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

        return operadora;
    }

    @Override
    public boolean setObject(Object object) {
        return false;
    }

    @Override
    public boolean isShowMessage() {
        return true;
    }

    @Override
    public boolean reflesh() {
        return false;
    }

    @Override
    public boolean limpartudo() {
        tf_operadora.setText("");
        ta_obs.setText("");
        return true;
    }

    @Override
    public void setFocus() {
        tf_operadora.requestFocus();
    }

}
