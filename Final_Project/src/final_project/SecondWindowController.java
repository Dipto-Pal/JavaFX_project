package final_project;

import java.io.File;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class SecondWindowController implements Initializable {

    @FXML
    private Button newGame;
    @FXML
    private Button score;
    @FXML
    private Button Level;
    @FXML
    private Button exit;
    @FXML
    private Button help;
     @FXML
    private AnchorPane rootPane1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void newGame(ActionEvent event) {
         GameViewManager gameManager = new GameViewManager();
         gameManager.creatNewGame();
         
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

    @FXML
    private void score(ActionEvent event) throws IOException {
        /*Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ScoreSee.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);*/
        try{
            AnchorPane pane=FXMLLoader.load(getClass().getResource("ScoreSee.fxml"));
            rootPane1.getChildren().setAll(pane);
        }
        catch(Exception ex){
            //System.out.println(ex);
        }
        
    }

    @FXML
    private void Level(ActionEvent event) throws IOException {
        /*Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LevelUp.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);*/
        try{
            AnchorPane pane=FXMLLoader.load(getClass().getResource("LevelUp.fxml"));
            rootPane1.getChildren().setAll(pane);
        }
        catch(Exception ex){
            //System.out.println(ex);
        }
        
    }
    
    @FXML
    private void help(ActionEvent event) throws IOException {
       /* Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("HelpView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);*/
       try{
            AnchorPane pane=FXMLLoader.load(getClass().getResource("HelpView.fxml"));
            rootPane1.getChildren().setAll(pane);
        }
        catch(Exception ex){
            //System.out.println(ex);
        }
        
    }
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

  
    
}
