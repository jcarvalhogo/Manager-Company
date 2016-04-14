/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.util.ItemComboBox;
import com.br.jcarvalho.util.MsgBarra;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author Josemar
 */
public class ConsultasController implements Initializable {

    private ObservableList observableList;
    private EntityManagerFactory emf;
    private EntityManager em;
    private Class myClass;
    private List<ItemComboBox> itens;

    @FXML
    private HBox conteiner_table;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField textField;
    @FXML
    private Button button;
    @FXML
    private Label lb_estatus;
    @FXML
    private ProgressIndicator progressIndicator;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progressIndicator.progressProperty().setValue(1);
        progressIndicator.setVisible(false);
        lb_estatus.setText("");
    }

    private void disableControler(boolean disable, double value) {
        Platform.runLater(() -> {
            comboBox.setDisable(disable);
            textField.setDisable(disable);
            button.setDisable(disable);

            progressIndicator.progressProperty().setValue(value);
            progressIndicator.setVisible(disable);
            if (disable) {
                lb_estatus.setText(MsgBarra.PESQUISANDO);
            } else {
                lb_estatus.setText("" + observableList.size() + MsgBarra.REGISTRO_ENCONTRADOS);
            }
        });
    }

    private void getEntityManager() {
        emf = Persistence.createEntityManagerFactory("Manager-Company");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void initItensComboBox(List<ItemComboBox> itens) {
        this.itens = itens;
        comboBox.getItems().clear();
        itens.stream().forEach((iten) -> {
            comboBox.getItems().add(iten.getItem());
        });
    }

    public void initTable(Class myClass, TableView<?> table, ObservableList<? extends Object> observableList, TableColumn<?, ?>... colunas) {
        this.observableList = observableList;
        this.myClass = myClass;
        for (TableColumn coluna : colunas) {
            table.getColumns().add(coluna);
        }

        conteiner_table.getChildren().add(table);
    }

    private <T> TypedQuery<T> getTypedQuery(Class<T> type) {
        TypedQuery<T> query = em.createNamedQuery("Operadora.findAll", type);
        return query;
    }

    @FXML
    private void consultar(ActionEvent event) {
        if (!button.isDisable()) {
            disableControler(true, -1);
            progressIndicator.progressProperty().setValue(-1);
            progressIndicator.setVisible(true);
            new Consultar().start();
        }
    }

    private class Consultar extends Thread {

        @Override
        public void run() {
            getEntityManager();
            if (em != null) {
                observableList.clear();
                TypedQuery query = getTypedQuery(myClass);
                List resultList = query.getResultList();
                resultList.stream().forEach((object) -> {
                    observableList.add(object);
                });

                em.close();
                emf.close();

                disableControler(false, 1);
            }
        }
    }

}
