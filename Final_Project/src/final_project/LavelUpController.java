
package final_project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LavelUpController implements Initializable {

    @FXML
    private AnchorPane rootPane3;
    @FXML
    private Button ok1;
    @FXML
    private Button hard1;
    @FXML
    private Button medium1;
    @FXML
    private Button easy1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ok1(ActionEvent event) {
         try{
            AnchorPane pane=FXMLLoader.load(getClass().getResource("SecondWindow.fxml"));
            rootPane3.getChildren().setAll(pane);
        }
        catch(Exception ex){
            //System.out.println(ex);
        }
    }

    @FXML
    private void hard1(ActionEvent event) {
        try{
            
        String path = "C:\\Users\\dipto\\Desktop\\New folder\\JavaFx\\Final_Project\\src\\sound\\FinalSong.mp3"; 
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setAutoPlay(true);
        
        }
        catch(Exception ex)
        {
            
        }
        GameViewManagerhd gameManagerhd = new GameViewManagerhd();
        gameManagerhd.creatNewGame();
    }

    @FXML
    private void medium1(ActionEvent event) {
        try{
            
        String path = "C:\\Users\\dipto\\Desktop\\New folder\\JavaFx\\Final_Project\\src\\sound\\FinalSong.mp3"; 
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setAutoPlay(true);
        
        }
        catch(Exception ex)
        {
            
        }
        GameViewManagermm gameManagermm = new GameViewManagermm();
         gameManagermm.creatNewGame();
    }

    @FXML
    private void easy1(ActionEvent event) {
        try{
            
        String path = "C:\\Users\\dipto\\Desktop\\New folder\\JavaFx\\Final_Project\\src\\sound\\FinalSong.mp3"; 
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setAutoPlay(true);
        
        }
        catch(Exception ex)
        {
            
        }
        GameViewManagerey gameManagerey = new GameViewManagerey();
         gameManagerey.creatNewGame();
    }
    
}
