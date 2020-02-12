/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasmine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author D
 */
public class Word extends Application {

    public void start(Stage primaryStage) {

        ScaleTransition st;
        Text txt = new Text("Tic-Tac-Toe");
        txt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        txt.setFill(Color.BROWN);
        txt.setStrokeWidth(1);
        txt.setStroke(Color.BLUE);
        txt.setX(100);
        txt.setY(100);

//      //Creating scale Transition 
        ScaleTransition scaleTransition = new ScaleTransition();
//      
//      //Setting the duration for the transition 
        scaleTransition.setDuration(Duration.millis(1000));
//      
//      //Setting the node for the transition 
        scaleTransition.setNode(txt);
//      
//      //Setting the dimensions for scaling 
        scaleTransition.setByY(1.5);
        scaleTransition.setByX(1.5);

//      //Setting the cycle count for the translation 
        scaleTransition.setCycleCount(30);
//      
//      //Setting auto reverse value to true 
        scaleTransition.setAutoReverse(false);
//      
//      //Playing the animation 
        scaleTransition.play();

        Group root = new Group(txt);

        Scene scene = new Scene(root, 600, 300);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
