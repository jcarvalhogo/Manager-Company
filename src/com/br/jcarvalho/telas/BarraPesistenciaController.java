/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.util.DBAction;
import com.br.jcarvalho.util.IntegracaoPersistencia;
import com.br.jcarvalho.util.MsgBarra;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author Josemar
 */
public class BarraPesistenciaController implements Initializable {
    // Uso Josemar
    //private static final String PERSISTENCE_UNIT = "Manager-Company";
    // Uso Fred
    public static final String PERSISTENCE_UNIT = "Manager-Company-02";

    private IntegracaoPersistencia integracao;
    private int local_action;
    private EntityManagerFactory emf;
    private EntityManager em;

    private Stage stage_consultas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        local_action = DBAction.LIVRE;
    }

    private void menssagem(String titulo, String msg, AlertType type) {
        if (integracao.isShowMessage()) {
            Alert alert = new Alert(type);
            alert.setTitle(titulo);
            alert.setContentText(msg);
            alert.show();
        }
    }

    private void getEntityManager() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void setIntegracaoPersistencia(IntegracaoPersistencia integracao) {
        this.integracao = integracao;
    }

    public void setStageConsulta(Stage stage_consultas) {
        this.stage_consultas = stage_consultas;
    }

    @FXML
    private void salvar(ActionEvent event) {
        try {
            switch (local_action) {
                case DBAction.NOVO:
                    getEntityManager();
                    if (em != null) {
                        Object obj = integracao.getObject(DBAction.SALVAR);
                        if (obj != null) {
                            em.persist(obj);
                            em.getTransaction().commit();
                        }
                        em.close();
                        emf.close();
                        menssagem(MsgBarra.TITULO, MsgBarra.SALVO_COM_SUCESO, AlertType.CONFIRMATION);
                        integracao.limpartudo();
                    }
                    break;

                case DBAction.EDITAR:
                    getEntityManager();
                    if (em != null) {
                        Object obj = integracao.getObject(DBAction.SALVAR);
                        if (obj != null) {
                            em.merge(obj);
                            em.getTransaction().commit();
                        }
                        em.close();
                        emf.close();
                        menssagem(MsgBarra.TITULO, MsgBarra.EDTIDADO_COM_SUCESO, AlertType.CONFIRMATION);
                        integracao.limpartudo();
                    }
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(BarraPesistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void novo(ActionEvent event) {
        if (local_action != DBAction.EDITAR) {
            local_action = DBAction.NOVO;
            integracao.getObject(DBAction.NOVO);
        } else {

        }
    }

    @FXML
    private void editar(ActionEvent event) {
        if (local_action != DBAction.NOVO) {
            local_action = DBAction.EDITAR;
            integracao.getObject(DBAction.EDITAR);
        } else if (integracao.isShowMessage()) {

        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        local_action = DBAction.CANCELAR;
        integracao.getObject(DBAction.CANCELAR);
        integracao.limpartudo();
    }

    @FXML
    private void consultas(ActionEvent event) {
        if (stage_consultas != null) {
            stage_consultas.showAndWait();
        }
    }

}
