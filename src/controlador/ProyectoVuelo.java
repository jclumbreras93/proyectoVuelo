/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author David
 */
public class ProyectoVuelo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Cargar la interface grafica de inicio
        //que se ha construido con la herramienta
        //scenebuilder
        Parent root = FXMLLoader.load(getClass().getResource("/vista/logueo.fxml"));
        //La escena viene a ser el panel que alberga todos 
        //componenetes: botones, tablas, textfield
        Scene scene = new Scene(root);
        //cargar la hoja de estilo de forma global

        //El escenario carga la escena
        stage.setTitle("IberiasTu");
        stage.setResizable(false);
        stage.setTitle("IberiasTu");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
