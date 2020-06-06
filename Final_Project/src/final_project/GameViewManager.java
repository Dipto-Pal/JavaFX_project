package final_project;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private static final int Game_WIDTH=600;
    private static final int Game_HEIGHT=800;
    
    private ImageView ship;
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private int angle;
    private AnimationTimer gameTimer;
    
    private GridPane gridPane1;
    private GridPane gridPane2;
    private final static String object_image1="/img/obj1.png";
    //private final static String object_image2="/img/obj2.png";
    private final static String object_image15="/img/obj5.png";
    private final static String object_image16="/img/obj6.png";
    private ImageView[] obj_img1;
    //private ImageView[] obj_img2;
    private ImageView[] obj_img5;
    private ImageView[] obj_img6;
    
    Random randomPositionGenerator;
    
    private ImageView star;
    private SmallInfoLable pointsLable;
    private ImageView[] playerLifes;
    private int playerLife;
    int points;
    String value;
    private final static String GoldStar="/img/GoldStar.png";
    private final static int STAR_radius=12;
    private final static int SHIP_radius=27;
    private final static int OBJ_radius=20;
    
    
    public GameViewManager()
    {
        initializeStage();
        createKeyListeners();
        randomPositionGenerator =new Random();
    }
    private void createKeyListeners() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
               if(event.getCode()==KeyCode.LEFT)
               {
                  isLeftKeyPressed=true; 
               }
               else if(event.getCode()==KeyCode.RIGHT)
               {
                   isRightKeyPressed=true;
               }
            }
        
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
               if(event.getCode()==KeyCode.LEFT)
               {
                   isLeftKeyPressed=false;
               }
               else if(event.getCode()==KeyCode.RIGHT)
               {
                   isRightKeyPressed=false;
               }
            }
        
        });
    }
    private void initializeStage() {
        gamePane=new AnchorPane();
        gameScene=new Scene(gamePane,Game_WIDTH,Game_HEIGHT);
        gameStage=new Stage();
        gameStage.setScene(gameScene);
        gameStage.setResizable(false);
    }
    
    public void creatNewGame()
    {
        gameStage.show();
        createBackground();
        createShip();
        creatGameElements(ship);
        creatGameLoop();
        
    }
    public void creatGameElements(ImageView ship)
    {
        playerLife=2;
        star =new ImageView(GoldStar);
        setNewElementPosition(star);
        gamePane.getChildren().add(star);
        pointsLable = new SmallInfoLable("POINTS : 00");
        pointsLable.setLayoutX(460);
        pointsLable.setLayoutY(20);
        gamePane.getChildren().add(pointsLable);
        playerLifes=new ImageView[3];
        
        for(int i=0;i<playerLifes.length;i++)
        {
            playerLifes[i]=new ImageView(ship.getImage());
            playerLifes[i].setLayoutX(350 +(i*80));
            playerLifes[i].setLayoutY(80);
            gamePane.getChildren().add(playerLifes[i]);
        }
        
       obj_img1=new ImageView[7];
       for(int i=0;i<obj_img1.length;i++)
       {
           obj_img1[i]=new ImageView(object_image1);
           setNewElementPosition(obj_img1[i]);
           gamePane.getChildren().add(obj_img1[i]);
       }
       
      // obj_img2=new ImageView[7];
      /* for(int i=0;i<obj_img2.length;i++)
       {
           obj_img2[i]=new ImageView(object_image2);
           setNewElementPosition(obj_img2[i]);
           gamePane.getChildren().add(obj_img2[i]);
       }*/
       
       obj_img5=new ImageView[7];
       for(int i=0;i<obj_img5.length;i++)
       {
           obj_img5[i]=new ImageView(object_image15);
           setNewElementPosition(obj_img5[i]);
           gamePane.getChildren().add(obj_img5[i]);
       }
       
       
       obj_img6=new ImageView[7];
       for(int i=0;i<obj_img6.length;i++)
       {
           obj_img6[i]=new ImageView(object_image16);
           setNewElementPosition(obj_img6[i]);
           gamePane.getChildren().add(obj_img6[i]);
       }
  
    }
    private void moveGameElements()
    {
        star.setLayoutY(star.getLayoutY()+5);
        
        for(int i=0;i<obj_img1.length;i++)
        {
            obj_img1[i].setLayoutY(obj_img1[i].getLayoutY()+7);
            obj_img1[i].setRotate(obj_img1[i].getRotate()+4);
        }
       /* for(int i=0;i<obj_img2.length;i++)
        {
            obj_img2[i].setLayoutY(obj_img2[i].getLayoutY()+7);
            obj_img2[i].setRotate(obj_img2[i].getRotate()+4);
        }*/
        for(int i=0;i<obj_img5.length;i++)
        {
            obj_img5[i].setLayoutY(obj_img5[i].getLayoutY()+7);
            obj_img5[i].setRotate(obj_img5[i].getRotate()+4);
        }
        for(int i=0;i<obj_img6.length;i++)
        {
            obj_img6[i].setLayoutY(obj_img6[i].getLayoutY()+7);
            obj_img6[i].setRotate(obj_img6[i].getRotate()+4);
        }
    }
    
    private void checkIfElementsAreBehindTheShipAnsRelocate()
    {
        if(star.getLayoutY()>1200)
        {
            setNewElementPosition(star);
        }
        for(int i=0;i<obj_img1.length;i++)
        {
            if(obj_img1[i].getLayoutY()>900)
            {
                setNewElementPosition(obj_img1[i]);
            }
            /*if(obj_img2[i].getLayoutY()>900)
            {
                setNewElementPosition(obj_img2[i]);
            }*/
            if(obj_img5[i].getLayoutY()>900)
            {
                setNewElementPosition(obj_img5[i]);
            }
            if(obj_img6[i].getLayoutY()>900)
            {
                setNewElementPosition(obj_img6[i]);
            }
               
        }
    }
    private void setNewElementPosition(ImageView image)
    {
        image.setLayoutX(randomPositionGenerator.nextInt(600));
        image.setLayoutY(-(randomPositionGenerator.nextInt(3200)+600));
    }
    
    private void createShip()
    {
        try
        {
        ship=new ImageView("/img/32.png");
        ship.setLayoutX(Game_WIDTH/2);
        ship.setLayoutY(Game_HEIGHT-90);
        gamePane.getChildren().add(ship);
        }
        catch(Exception e)
        {
                
        }
    }
    private void creatGameLoop(){
        gameTimer=new AnimationTimer(){
            @Override
            public void handle(long now) {
                moveBackground();
                moveGameElements();
                checkIfElementsAreBehindTheShipAnsRelocate();
                checkElementsCollide();
                moveShip();
            }  
            
        };
        gameTimer.start();
        
    }
    private void moveShip()
    {
        if(isLeftKeyPressed && !isRightKeyPressed)
        {
            if(angle>-30)
            {
                angle-=5;
            }
            ship.setRotate(angle);
            if(ship.getLayoutX()>-20){
                ship.setLayoutX(ship.getLayoutX()-3);
            }
        }
        if(isRightKeyPressed && !isLeftKeyPressed)
        {
            if(angle<30)
            {
                angle+=5;
            }
            ship.setRotate(angle);
            if(ship.getLayoutX()<522){
                ship.setLayoutX(ship.getLayoutX()+3);
            }
        }
        if(!isLeftKeyPressed && !isRightKeyPressed)
        {
            if(angle<0)
            {
                angle+=5;
            }
            else if(angle>0)
            {
                angle-=5;
            }
            ship.setRotate(angle);
        }
        if(isLeftKeyPressed && isRightKeyPressed)
        {
            if(angle<0)
            {
                angle+=5;
            }
            else if(angle>0)
            {
                angle-=5;
            }
                ship.setRotate(angle);
        }
    }
    private void createBackground()
    {
        gridPane1= new GridPane();
        gridPane2= new GridPane();
        for(int i=0;i<30;i++)
        {
            ImageView backgroundImage1= new ImageView("/img/BlackSpace.jpg");
            ImageView backgroundImage2= new ImageView("/img/BlackSpace.jpg");
            GridPane.setConstraints(backgroundImage1, i%3, i/3);
            GridPane.setConstraints(backgroundImage2, i%3, i/3);
            gridPane1.getChildren().add(backgroundImage1);
            gridPane2.getChildren().add(backgroundImage2);
        }
        
        gridPane2.setLayoutY(-1024);
        gamePane.getChildren().addAll(gridPane1,gridPane2);
    }
    private void moveBackground()
    {
        gridPane1.setLayoutY(gridPane1.getLayoutY()+3);
        gridPane2.setLayoutY(gridPane2.getLayoutY()+3);
        
        if(gridPane1.getLayoutY() >= 1024)
        {
            gridPane1.setLayoutY(-1024);
        }
        if(gridPane2.getLayoutY() >= 1024)
        {
            gridPane2.setLayoutY(-1024);
        }
    }
    
    private void checkElementsCollide()
    {
       if(SHIP_radius + STAR_radius>calculatateDistance(ship.getLayoutX()+49,star.getLayoutX()+15,ship.getLayoutY()+37,star.getLayoutY()+15))
       {
           setNewElementPosition(star);
           points=points+5;
           value=String.valueOf(points);
           String textToSet="POINTS : ";
           if(points<10)
           {
               textToSet=textToSet + "0";
           }
           pointsLable.setText(textToSet+points);
       }
       
       
       for(int i=0;i<obj_img1.length;i++)
       {
           if(OBJ_radius+SHIP_radius>calculatateDistance(ship.getLayoutX()+49,obj_img1[i].getLayoutX()+20,ship.getLayoutY()+37,obj_img1[i].getLayoutY()+20))
           {
             removeLife();
             setNewElementPosition(obj_img1[i]);
           }
       }
      /* for(int i=0;i<obj_img2.length;i++)
       {
           if(OBJ_radius+SHIP_radius>calculatateDistance(ship.getLayoutX()+49,obj_img2[i].getLayoutX()+20,ship.getLayoutY()+37,obj_img2[i].getLayoutY()+20))
           {
             removeLife();
             setNewElementPosition(obj_img2[i]);
           }
       }*/
       for(int i=0;i<obj_img5.length;i++)
       {
           if(OBJ_radius+SHIP_radius>calculatateDistance(ship.getLayoutX()+49,obj_img5[i].getLayoutX()+20,ship.getLayoutY()+37,obj_img5[i].getLayoutY()+20))
           {
             removeLife();
             setNewElementPosition(obj_img5[i]);
           }
       }
       for(int i=0;i<obj_img6.length;i++)
       {
           if(OBJ_radius+SHIP_radius>calculatateDistance(ship.getLayoutX()+49,obj_img6[i].getLayoutX()+20,ship.getLayoutY()+37,obj_img6[i].getLayoutY()+20))
           {
             removeLife();
             setNewElementPosition(obj_img6[i]);
           }
       }
        
    }
    
    
    private void removeLife()
    {
        gamePane.getChildren().remove(playerLifes[playerLife]);
        playerLife--;
        if(playerLife<0)
        {
            gameStage.close();
            gameTimer.stop();
            
            
            
            try
            {
                FileWriter fw=new FileWriter("score1.txt");
                BufferedWriter bw =new BufferedWriter(fw);
                bw.write(value);
                bw.close();
                
            }
           catch(Exception ex){}        
            
           try
           {
               FileReader fr=new FileReader("score.txt");
               Scanner scanner = new Scanner(fr);
               BufferedReader br=new BufferedReader(fr);
               while(scanner.hasNext())
                  {
                      String c = scanner.next();
                       int v1=Integer.parseInt(c);
                       if(points>v1)
                       {   
                           String v2=String.valueOf(points);
                           try{
                                 FileWriter fw=new FileWriter("score.txt");
                                 BufferedWriter bw =new BufferedWriter(fw);
                                 bw.write(v2);
                                 bw.close();
                           }
                           catch(Exception ex)
                           {
                               
                           }
                           
                       }   
                  }
               scanner.close();
            }
              catch(Exception ex){} 
           
             
             
        }
    }
    private double calculatateDistance(double x1,double x2,double y1,double y2)
    {
        return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
    }
    

     
}
