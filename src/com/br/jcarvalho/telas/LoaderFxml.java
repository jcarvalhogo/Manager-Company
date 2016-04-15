/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.util.IntegracaoConsultas;
import com.br.jcarvalho.util.IntegracaoPersistencia;
import com.br.jcarvalho.util.ItemComboBox;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoaderFxml {

    public static Parent getBarraPersistencia(IntegracaoPersistencia integracao, Stage stage_consulta) {
        try {
            FXMLLoader loader = new FXMLLoader(LoaderFxml.class.getResource("BarraPesistencia.fxml"));
            loader.load();
            BarraPesistenciaController controller = loader.getController();
            controller.setIntegracaoPersistencia(integracao);
            controller.setStageConsulta(stage_consulta);
            return loader.getRoot();
        } catch (IOException ex) {
            Logger.getLogger(LoaderFxml.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static Stage getStage(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(LoaderFxml.class.getResource(fxml));
            loader.load();
            Scene scene = new Scene(loader.getRoot());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(titulo);
            return stage;
        } catch (IOException ex) {
            Logger.getLogger(LoaderFxml.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static Stage getStageConsulta(Class myClass, List<ItemComboBox> itens, IntegracaoConsultas integracao, String titulo, int width, int heigth, TableView<?> table, ObservableList<?> observableList, TableColumn<?, ?>... colunas) {
        try {
            FXMLLoader loader = new FXMLLoader(LoaderFxml.class.getResource("Consualtas.fxml"));
            loader.load();
            ConsultasController controller = loader.getController();
            controller.initTable(myClass, table, observableList, colunas);
            controller.initItensComboBox(itens);
            controller.setIntegracaoConsultas(integracao);
            Scene scene = new Scene(loader.getRoot());
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.setResizable(false);
            stage.setMaximized(false);
            stage.setWidth(width);
            stage.setHeight(heigth);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(titulo);
            return stage;
        } catch (IOException ex) {
            Logger.getLogger(LoaderFxml.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
