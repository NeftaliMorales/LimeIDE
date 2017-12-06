package lime.ide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.fxmisc.richtext.*;

public class IdeEditorController implements Initializable {
    
    @FXML AnchorPane apMain;
    @FXML TabPane tabs;
    @FXML Button bNuevaHoja;
    @FXML Button bBorrarHoja;
    private String nombreP;
    private String rutaP;
    private static Proyecto proy;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bNuevaHoja.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nuevaPestaña("hola");
            }
        });
        bBorrarHoja.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                borrarPestaña();
            }
        });
    }
    private void nuevaPestaña(String nombreTab){
        Tab nueva = new Tab(nombreTab);
        CodeArea code = new CodeArea();
        code.setParagraphGraphicFactory(LineNumberFactory.get(code));
        nueva.setContent(code);
        tabs.getTabs().add(nueva);
    }
    private void borrarPestaña(){
        int index = tabs.getSelectionModel().getSelectedIndex();
        tabs.getTabs().remove(index);
    }
    public static void setProyecto(Proyecto a){
        proy = a;        
    }
}
