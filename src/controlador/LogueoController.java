package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.conectar;

public class LogueoController implements Initializable {
    
    conectar cnx = new conectar();
    
    @FXML
    private Button btnAccept;
    
    @FXML
    private Button btnClose;
    
    @FXML
    private Label lbpass;
    
    @FXML
    private PasswordField txPass;
    
    @FXML
    private TextField txUser;
    
    @FXML
    private Button btnRegistrar;
    
    @FXML
    void actionClose(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    void actionLogin(ActionEvent event) {
        loguearse(event);
    }
    
    @FXML
    void actionRegistrar(ActionEvent event) {
        if (!txUser.getText().isEmpty() && !txPass.getText().isEmpty()) {
            if (!cnx.logueo(txUser.getText(), txPass.getText())) {
                
                if (cnx.register(txUser.getText(), txPass.getText())) {
                    
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Register");
                    alerta.setContentText("Registrado con exito");
                    alerta.showAndWait();
                    txUser.clear();
                    txPass.clear();
                    
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Register");
                    alerta.setContentText("Error: No se pudo completar el registro");
                    alerta.showAndWait();
                    txUser.clear();
                    txPass.clear();
                }
                
            } else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Resgiter");
                alerta.setContentText("Ya existe ese usuario");
                alerta.showAndWait();
                txUser.clear();
                txPass.clear();
                txUser.requestFocus();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Register");
            alerta.setContentText("Error: Rellena todos los campos ");
            alerta.showAndWait();
            txUser.clear();
            txPass.clear();
        }
    }
    
    @FXML
    void actionIntro(ActionEvent event) {
        loguearse(event);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnx.conectar();
        txUser.requestFocus();
    }
    
    private void loguearse(ActionEvent event) {
        
        if (cnx.logueo(txUser.getText(), txPass.getText())) {
            Stage escenario = new Stage();
            FXMLLoader fXMLLoader = new FXMLLoader();
            
            fXMLLoader.setLocation(getClass().getResource("/vista/interfaceAsientos.fxml"));
            try {
                Scene escena = new Scene(fXMLLoader.load());
                escenario.setScene(escena);
            } catch (IOException ex) {
                Logger.getLogger(LogueoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ControladorBilletes contBill = (ControladorBilletes) fXMLLoader.getController();
            contBill.lbUser.setText(txUser.getText());
            escenario.setTitle("IberiasTu");
            escenario.initStyle(StageStyle.UNDECORATED);
            escenario.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setContentText("No existe ese usuario");
            alerta.showAndWait();
            txUser.clear();
            txPass.clear();
            txUser.requestFocus();
            
        }
    }
    
}
