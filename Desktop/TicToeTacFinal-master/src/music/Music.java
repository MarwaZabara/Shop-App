/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Yasmine Dwedar
 */
public class Music extends Application {
 
    
    
    public void start(Stage primaryStage) throws Exception {
    
      Button btn = new Button();
        btn.setText("When Clicked'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
              
                          clickBtnSound(); 
       
            }

          private void clickBtnSound() {
              String path2 = "test.mp3";
              
              //Instantiating Media class
              Media med = new Media(new File(path2).toURI().toString());
              
              //Instantiating MediaPlayer class
              MediaPlayer click = new MediaPlayer(med);
              
              click.setAutoPlay(true);
          }
        });


//    private Controller controller;
//      String musicFile = "music.mp3";
//        Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();


        
        StackPane root = new StackPane();
        root.getChildren().addAll(btn);
   
        
        Scene scene = new Scene(root, 300, 250);
        
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
   
             java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
           // Music  a =new Music();
                
                try {    
                URL inurl=this.getClass().getResource("bgm.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(inurl));
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);    
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        });
            launch(args);
     
    }

        
     
    }
    

