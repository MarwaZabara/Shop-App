package yasmine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author D
 */
public class FadeOut extends Application {

    Image img;
    ImagePattern Background;
    Rectangle rect;
    ImageView iv1;
//         iv1.setImage(image)

    // TextSizeTransition trans ;    
    @Override
    public void start(Stage primaryStage) {
//
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//
//                //    translate.play();  
//            }
//        });

        FileInputStream inputstream;
        try {
            inputstream = new FileInputStream("C:/Users/D/Documents/NetBeansProjects/Test/src/test/pic.jpg");
            img = new Image(inputstream);
            
            iv1 = new ImageView();

            iv1.setImage(img);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FadeOut.class.getName()).log(Level.SEVERE, null, ex);
        }

        Background = new ImagePattern(img);

        rect = new Rectangle();

      BorderPane bp = new BorderPane();
      //sc.logo
      bp.setCenter(iv1);

 
        rect.setFill(Background);

        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setFromValue(5);
        fade.setToValue(0.0);
        fade.setCycleCount(5);
        fade.setAutoReverse(true);
        fade.setNode(bp);
        fade.play();

      
        Group root = new Group(rect, bp);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setScene(scene);

        
        primaryStage.show();


    }

    
    public static void main(String[] args) {
        launch(args);
    }

//        static Node lighting() {
//        Light.Distant light = new Light.Distant();
//        light.setAzimuth(-135.0f);
//
//        Lighting l = new Lighting();
//        l.setLight(light);
//        l.setSurfaceScale(5.0f);
//
//        Text t = new Text();
//        t.setText("Lighting!");
//        t.setFill(Color.RED);
//        t.setFont(Font.font(null, FontWeight.BOLD, 70));
//        t.setX(10.0f);
//        t.setY(10.0f);
//        t.setTextOrigin(VPos.TOP);
//
//        t.setEffect(l);
//
//        t.setTranslateX(0);
//        t.setTranslateY(320);
//
//        return t;
//    }
}
