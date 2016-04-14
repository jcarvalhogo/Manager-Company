/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.main;

import com.br.jcarvalho.telas.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(PrincipalController.class.getResource("Principal.fxml"));

        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent event) -> {
            //TODO implementar alguma coisa para ser executando antes de fechar a tela principal caso neja necessario..
        });
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
