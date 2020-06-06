package final_project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelpViewController implements Initializable {

    @FXML
    private Button ok;
    
    @FXML
    private AnchorPane rootPane2;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void ok(ActionEvent event) throws IOException {
        /*Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SecondWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);*/
        
        
        try{
            AnchorPane pane=FXMLLoader.load(getClass().getResource("SecondWindow.fxml"));
            rootPane2.getChildren().setAll(pane);
        }
        catch(Exception ex){
            //System.out.println(ex);
        }
    }
    
}
