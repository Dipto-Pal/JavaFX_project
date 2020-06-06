package final_project;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Final_Project extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
          
         
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
       /* try{
            
        String path = "C:\\Users\\dipto\\Desktop\\New folder\\JavaFx\\Final_Project\\src\\sound\\FinalSong.mp3"; 
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setAutoPlay(true);
        
        }
        catch(Exception ex)
        {
            
        }*/
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
