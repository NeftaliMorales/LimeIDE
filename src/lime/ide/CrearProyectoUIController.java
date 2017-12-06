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
import javax.swing.JOptionPane;

public class CrearProyectoUIController implements Initializable {

    @FXML private Button bAtras;
    @FXML private Button bCrear;
    @FXML private TextField tfNombre;
    @FXML private TextField tfRuta;
    
    String rutaProyecto = tfRuta.getText();
    String nombreProyecto = tfNombre.getText();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bAtras.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                atras();
                cerrar();
            }
        });
        bCrear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                crear();
                cerrar();
            }
        });
    }    
    private void atras(){
        try {
            String idioma = LimeIDE.getIdioma();
            ResourceBundle bundle = ResourceBundle.getBundle(idioma);
            Parent root = FXMLLoader.load(getClass().getResource("AbrirProyectoUI.fxml"), bundle);
            
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(bundle.getString("tAbrirProyecto"));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void crear(){
        try {
            crearProyecto();
            String idioma = LimeIDE.getIdioma();
            ResourceBundle bundle = ResourceBundle.getBundle(idioma);
            Parent root = FXMLLoader.load(getClass().getResource("IdeEditor.fxml"), bundle);
            
            Stage stage = new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            //stage.setResizable(false);
            stage.setMaximized(true);
            //stage.setTitle("LimeIDE - " + nombreProyecto);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cerrar(){
        Stage stage = (Stage) bAtras.getScene().getWindow();
        stage.close();
    }
    
    private void crearProyecto(){
        if(nombreProyecto.equals("") || rutaProyecto.equals("")){
            JOptionPane.showMessageDialog(null, "Completa los campos");
        }
        else{
            Proyecto proyecto = new Proyecto(rutaProyecto, nombreProyecto);
            IdeEditorController.setProyecto(proyecto);
            proyecto.mkdirs();
        }
    }
}
