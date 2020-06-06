package final_project;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class ScoreSeeController implements Initializable {

    @FXML
    private Button hard;
    @FXML
    private Button medium;
    @FXML
    private Button easy;
    @FXML
    private Label tx1;
    
    String c,c1,c2,c3 ;
    @FXML
    private Button ok;
    @FXML
    private Label tx2;
    @FXML
    private Label tx4;
    @FXML
    private Label tx3;
    @FXML
    private Button default1;
    @FXML
    private AnchorPane rootPane4;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    public void default1(ActionEvent event) {
        
         try
           {
               FileReader fr=new FileReader("score.txt");
               Scanner scanner = new Scanner(fr);
               BufferedReader br=new BufferedReader(fr);
               while(scanner.hasNext())
                  {
                        c=scanner.next();
                        //System.out.println(c);
                        tx1.setText(c);
                        scanner.close();
                         
                  }
            }
            catch(Exception ex){}
           
    }

    @FXML
    private void hard(ActionEvent event) {
        try
           {
               FileReader fr=new FileReader("scorehd.txt");
               Scanner scanner = new Scanner(fr);
               BufferedReader br=new BufferedReader(fr);
               while(scanner.hasNext())
                  {
                        c1=scanner.next();
                        //System.out.println(c);
                        tx2.setText(c1);
                        scanner.close();
                         
                  }
            }
            catch(Exception ex){}
    }

    @FXML
    private void medium(ActionEvent event) {
        try
           {
               FileReader fr=new FileReader("scoremm.txt");
               Scanner scanner = new Scanner(fr);
               BufferedReader br=new BufferedReader(fr);
               while(scanner.hasNext())
                  {
                        c=scanner.next();
                        //System.out.println(c);
                        tx3.setText(c);
                        scanner.close();
                         
                  }
            }
            catch(Exception ex){}
    }

    @FXML
    private void easy(ActionEvent event) {
        try
           {
               FileReader fr=new FileReader("scoreey.txt");
               Scanner scanner = new Scanner(fr);
               BufferedReader br=new BufferedReader(fr);
               while(scanner.hasNext())
                  {
                        c=scanner.next();
                        //System.out.println(c);
                        tx4.setText(c);
                        scanner.close();
                         
                  }
            }
            catch(Exception ex){}
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
            rootPane4.getChildren().setAll(pane);
        }
        catch(Exception ex){
            //System.out.println(ex);
        }
    }
    
}
