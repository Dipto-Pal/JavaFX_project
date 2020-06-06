package final_project;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button enter;
    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private AnchorPane rootPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       setRatate(c1,true,360,10);
       setRatate(c2,true,180,18);
       setRatate(c3,true,145,24);
    }    
    int rotate=0;
    private void setRatate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition =new RotateTransition(Duration.seconds(duration),c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(10);
        rotateTransition.play();
    }
    @FXML
    private void enter(ActionEvent event)throws IOException {
        /*Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SecondWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);*/
        
        AnchorPane pane=FXMLLoader.load(getClass().getResource("SecondWindow.fxml"));
        rootPane.getChildren().setAll(pane);
        
        try{
            
        String path = "C:\\Users\\dipto\\Desktop\\New folder\\JavaFx\\Final_Project\\src\\sound\\FinalSong.mp3"; 
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setAutoPlay(true);
        
        }
        catch(Exception ex)
        {
            
        }
        
    }

    
    
}
