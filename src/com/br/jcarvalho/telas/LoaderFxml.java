/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.util.IntegracaoPersistencia;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoaderFxml {

    public static Parent getBarraPersistencia(IntegracaoPersistencia integracao) {
        try {
            FXMLLoader loader = new FXMLLoader(LoaderFxml.class.getResource("BarraPesistencia.fxml"));
            loader.load();
            BarraPesistenciaController controller = loader.getController();
            controller.setIntegracaoPersistencia(integracao);

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
}
