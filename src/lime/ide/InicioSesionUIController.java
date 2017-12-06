package lime.ide;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class InicioSesionUIController implements Initializable {

    @FXML private Button bRegistrarse;
    @FXML private Button bConfig;
    @FXML private Button bIniciarSesion;
    @FXML private TextField tfUser;
    @FXML private PasswordField pfPass;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bIniciarSesion.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                validarInicio();
            }
        });
        bRegistrarse.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                registrarse();
            }
        });
        bConfig.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambiarIdioma();
                cerrar();
            }
        });
    }
    private void cerrar(){
        Stage stage = (Stage) bRegistrarse.getScene().getWindow();
        stage.close();
    }
    private void registrarse(){
        try {
           String idioma = LimeIDE.getIdioma();
           ResourceBundle bundle = ResourceBundle.getBundle(idioma);
           Parent root = FXMLLoader.load(getClass().getResource("RegistrarseUI.fxml"), bundle);

           Stage stage = new Stage();

           Scene scene = new Scene(root);

           stage.setScene(scene);
           stage.setResizable(false);
           stage.setTitle(bundle.getString("tRegistrarse"));
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.show();
       } catch (IOException ex) {
           Logger.getLogger(InicioSesionUIController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    private void cambiarIdioma(){
        try {
            String idioma = LimeIDE.getIdioma();
            ResourceBundle bundle = ResourceBundle.getBundle(idioma);
            Parent root = FXMLLoader.load(getClass().getResource("InternacionalizacionUI.fxml"), bundle);
            
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(bundle.getString("tCambiarIdioma"));
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void iniciarSesion(){
        try {
            String idioma = LimeIDE.getIdioma();
            ResourceBundle bundle = ResourceBundle.getBundle(idioma);
            Parent root = FXMLLoader.load(getClass().getResource("AbrirProyectoUI.fxml"), bundle);
            
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(bundle.getString("tAbrirProyecto"));
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void validarInicio(){
        String idioma = LimeIDE.getIdioma();
        ResourceBundle bundle = ResourceBundle.getBundle(idioma);
//        String user = tfUser.getText();
//        String pass = pfPass.getText();
//        if(user.equals("") || pass.equals("")){
//            JOptionPane.showMessageDialog(null, bundle.getString("mdValidar"));
//        }
//        else{
            iniciarSesion();
            cerrar();
        //}
    }
}
