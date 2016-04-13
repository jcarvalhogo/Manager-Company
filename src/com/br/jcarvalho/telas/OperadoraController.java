/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.model.Operadora;
import com.br.jcarvalho.util.DBAction;
import com.br.jcarvalho.util.IntegracaoPersistencia;
import com.br.jcarvalho.util.MsgBarra;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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
        barra_ferramenta.getChildren().add(LoaderFxml.getBarraPersistencia(this));
    }

    @Override
    public Object getObject(int action) {
        switch (action) {
            case DBAction.SALVAR:
                //TODO preparar objeto para salvar
                break;
            case DBAction.CANCELAR:
                //TODO cancelar actions
                break;
            case DBAction.EDITAR:
                //TODO preparar objeto para editar
                break;
            case DBAction.NOVO:
                //TODO preparar objeto para novo..
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

}
