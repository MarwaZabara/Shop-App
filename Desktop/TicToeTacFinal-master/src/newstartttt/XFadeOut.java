package yasmine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author D
 */
public class XFadeOut extends Application {

    Text txt1;
    Text txt2;
    Text txt3;

    public void start(Stage primaryStage) {

        txt1 = new Text("X");
        txt2 = new Text("X");
        txt3 = new Text("X");

        txt1.setX(100);
        txt1.setY(100);

        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        txt1.setEffect(is);

        txt1.setFill(Color.RED);
        txt1.setFont(Font.font(null, FontWeight.BOLD, 100));

        txt2.setX(250);
        txt2.setY(100);

        txt2.setEffect(is);
        txt2.setFill(Color.RED);
        txt2.setFont(Font.font(null, FontWeight.BOLD, 100));

        txt3.setX(400);
        txt3.setY(100);

        txt3.setEffect(is);
        txt3.setFill(Color.RED);
        txt3.setFont(Font.font(null, FontWeight.BOLD, 100));

        blink(txt1);
        blink(txt2);
        blink(txt3);

//        Playing the animation Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });

        Group root = new Group(txt1, txt2, txt3);

//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void blink(Text tx) {

        ScaleTransition scaleTransition = new ScaleTransition();

        //Setting the duration for the transition 
        scaleTransition.setDuration(Duration.millis(550));

        //Setting the node for the transition 
       

        //Setting the dimensions for scaling 
        scaleTransition.setByY(.5);
        scaleTransition.setByX(.5);

        //Setting the cycle count for the translation 
        scaleTransition.setCycleCount(3);

        //Setting auto reverse value to true 
        scaleTransition.setAutoReverse(false);
         scaleTransition.setNode(tx);
        scaleTransition.play();

    }

}

