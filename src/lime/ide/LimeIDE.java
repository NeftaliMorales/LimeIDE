package lime.ide;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author edson
 */
public class LimeIDE extends Application {
    
    private static String idioma = "Resources.idioma";
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        ResourceBundle bundle = ResourceBundle.getBundle(idioma);
        Parent root = FXMLLoader.load(getClass().getResource("InicioSesionUI.fxml"), bundle);
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(bundle.getString("tIniciarSesion"));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static String getIdioma(){
        return idioma;
    }
    public static void setIdioma(String i){
        idioma = i;
    }
}
