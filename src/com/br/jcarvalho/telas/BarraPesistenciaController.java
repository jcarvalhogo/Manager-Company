/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jcarvalho.telas;

import com.br.jcarvalho.util.IntegracaoPersistencia;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Josemar
 */
public class BarraPesistenciaController implements Initializable {

    private IntegracaoPersistencia integracao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setIntegracaoPersistencia(IntegracaoPersistencia integracao){
        this.integracao = integracao;
    }
    
}
