package lime.ide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author edson
 */
public class RegistrarseUIController implements Initializable {

    @FXML private Button bRegistrar;
    @FXML private TextField tfNombre;
    @FXML private TextField tfUsuario;
    @FXML private PasswordField pfPass;
    @FXML private PasswordField pfPassC;
    @FXML private TextField tfCorreo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bRegistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                validarCampos();
            }
        });
    }    
    private void validarCampos(){
        String idioma = LimeIDE.getIdioma();
        ResourceBundle bundle = ResourceBundle.getBundle(idioma);
        
        String nombre = tfNombre.getText();
        String user = tfUsuario.getText();
        String pass = pfPass.getText();
        String passC = pfPassC.getText();
        String correo = tfCorreo.getText();
        if(nombre.equals("") || user.equals("") || pass.equals("") || passC.equals("") || correo.equals("")){
            JOptionPane.showMessageDialog(null, bundle.getString("mdValidarRegistro"));
        }
        else{
            cerrar();
        }
    }

    private void cerrar(){
        Stage stage = (Stage) bRegistrar.getScene().getWindow();
        stage.close();
    }
}
