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

/**
 * FXML Controller class
 *
 * @author edson
 */
public class InternalizacionUIController implements Initializable {
    
    @FXML private Button bEspañol;
    @FXML private Button bEnglish;
    @FXML private Button bDeutsch;
    @FXML private Button bJapon;
    @FXML private Button bItaliano;
    @FXML private Button bFrances;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bEspañol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambiar("Resources.idioma");
                JOptionPane.showMessageDialog(null, "Idioma Cambiado");
                inicio();
                cerrar();
            }
        });
        bEnglish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambiar("Resources.idioma_en_US");
                JOptionPane.showMessageDialog(null, "language changed");
                inicio();
                cerrar();
            }
        });
        bDeutsch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambiar("Resources.idioma_de_DE");
                JOptionPane.showMessageDialog(null, "Sprache geändert");
                inicio();
                cerrar();
            }
        });
        bJapon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambiar("Resources.idioma_jp_JP");
                JOptionPane.showMessageDialog(null, "言語が変更されました");
                inicio();
                cerrar();
            }
        });
        bItaliano.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambiar("Resources.idioma_it_IT");
                JOptionPane.showMessageDialog(null, "Lingua modificata");
                inicio();
                cerrar();
            }
        });
        bFrances.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambiar("Resources.idioma_fr_FR");
                JOptionPane.showMessageDialog(null, "Langue changée");
                inicio();
                cerrar();
            }
        });
    }    
    private void cambiar(String i){
        String idioma = i;
        LimeIDE.setIdioma(idioma);
    }
    private void cerrar(){
        Stage stage = (Stage) bEspañol.getScene().getWindow();
        stage.close();
    }
    private void inicio(){
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
