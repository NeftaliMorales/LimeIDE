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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class AbrirProyectoUIController implements Initializable {

    @FXML Button bNuevoProyecto;
    @FXML MenuItem miCerrarSesion;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bNuevoProyecto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevoP();
                cerrar();
            }
        });
        miCerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cerrarSesion();
                cerrar();
            }
        });
    }    
    private void nuevoP(){
        try {
            String idioma = LimeIDE.getIdioma();
            ResourceBundle bundle = ResourceBundle.getBundle(idioma);
            Parent root = FXMLLoader.load(getClass().getResource("CrearProyectoUI.fxml"), bundle);
            
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(bundle.getString("tCrearProyecto"));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cerrar(){
        Stage stage = (Stage) bNuevoProyecto.getScene().getWindow();
        stage.close();
    }
    private void cerrarSesion(){
        try {
           String idioma = LimeIDE.getIdioma();
           ResourceBundle bundle = ResourceBundle.getBundle(idioma);
           Parent root = FXMLLoader.load(getClass().getResource("InicioSesionUI.fxml"), bundle);

           Stage stage = new Stage();

           Scene scene = new Scene(root);

           stage.setScene(scene);
           stage.setResizable(false);
           stage.setTitle(bundle.getString("tIniciarSesion"));
           stage.show();
       } catch (IOException ex) {
           Logger.getLogger(InicioSesionUIController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
