/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static javafx.scene.input.KeyCode.T;
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
    
    //private Class<T> entityClass;

    @FXML
    private HBox conteiner_table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void getEntityManager() {
        emf = Persistence.createEntityManagerFactory("Manager-Company");
        em = emf.createEntityManager();
        em.getTransaction().begin();
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
        getEntityManager();
        if (em != null) {
            //TypedQuery<?> query = em.cre
            //List resultList = createQuery.getResultList();
        }
    }

}
