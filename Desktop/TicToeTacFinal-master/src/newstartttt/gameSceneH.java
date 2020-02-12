package newstartttt;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class gameSceneH extends BorderPane {

    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final Label gameTitle;
    protected final ImageView logo;
    protected final Label playerName;
    protected final AnchorPane actionPane;
    protected final Line lineV2;
    protected final Line lineV1;
    protected final Line lineH2;
    protected final Line lineH1;
    protected final Button btn0;
    protected final Button btn1;
    protected final Button btn2;
    protected final Button btn3;
    protected final Button btn4;
    protected final Button btn5;
    protected final Button btn6;
    protected final Button btn7;
    protected final Button btn8;
    
    protected final Line lineH21;
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Label score;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label oScoreLabel;
    protected final Label xScoreLabel;
    protected final Label tieScoreLabel;

    public gameSceneH() {

        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        gameTitle = new Label();
        logo = new ImageView();
        playerName = new Label();
        actionPane = new AnchorPane();
        
        lineV2 = new Line();
        lineV1 = new Line();
        lineH2 = new Line();
        lineH1 = new Line();
        
        btn2 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn8 = new Button();
        btn0 = new Button();
        btn1 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn7 = new Button();
        lineH21 = new Line();
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        score = new Label();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        oScoreLabel = new Label();
        xScoreLabel = new Label();
        tieScoreLabel = new Label();

        setId("rootPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(506.0);
        setPrefWidth(636.0);

        BorderPane.setAlignment(containerPane, javafx.geometry.Pos.CENTER);
        containerPane.setId("containerPane");
        containerPane.setPrefHeight(513.0);
        containerPane.setPrefWidth(541.0);
        containerPane.getStylesheets().add("/tictactoe/../css/styles.css");

        contentPane.setId("contentPane");
        contentPane.setLayoutX(124.0);
        contentPane.setPrefHeight(506.0);
        contentPane.setPrefWidth(359.0);

        gameTitle.setId("gameTitle");
        gameTitle.setLayoutX(55.0);
        gameTitle.setLayoutY(7.0);
        gameTitle.setText("TICTOCTOE-GAME");
        gameTitle.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        gameTitle.setFont(new Font("System Bold", 12.0));

        logo.setFitHeight(51.0);
        logo.setFitWidth(50.0);
        logo.setId("logo");
        logo.setLayoutX(1.0);
        logo.setLayoutY(1.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        logo.setImage(new Image(getClass().getResource("../img/icon.png").toExternalForm()));

        playerName.setId("playerName");
        playerName.setLayoutX(58.0);
        playerName.setLayoutY(24.0);
        playerName.setText("playerName");
        playerName.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        playerName.setFont(new Font("System Bold", 12.0));

        actionPane.setId("actionPane");
        actionPane.setLayoutX(31.0);
        actionPane.setLayoutY(61.0);
        actionPane.setPrefHeight(305.0);
        actionPane.setPrefWidth(297.0);
        actionPane.getStyleClass().add("action");
        actionPane.getStylesheets().add("/tictactoe/../css/styles.css");

        lineV2.setEndX(-105.99996948242188);
        lineV2.setEndY(267.0);
        lineV2.setId("lineV2");
        lineV2.setLayoutX(304.0);
        lineV2.setLayoutY(20.0);
        lineV2.setStartX(-105.99998474121094);
        lineV2.setStartY(8.666664123535156);
        lineV2.setStroke(javafx.scene.paint.Color.WHITE);
        lineV2.setStrokeWidth(4.0);

        lineV1.setEndX(-105.99995422363281);
        lineV1.setEndY(266.3333435058594);
        lineV1.setId("lineV1");
        lineV1.setLayoutX(201.0);
        lineV1.setLayoutY(21.0);
        lineV1.setStartX(-105.99998474121094);
        lineV1.setStartY(8.666664123535156);
        lineV1.setStroke(javafx.scene.paint.Color.WHITE);
        lineV1.setStrokeWidth(4.0);

        lineH2.setEndX(-127.99998474121094);
        lineH2.setEndY(290.0);
        lineH2.setId("lineH2");
        lineH2.setLayoutX(130.0);
        lineH2.setLayoutY(-88.0);
        lineH2.setStartX(159.33334350585938);
        lineH2.setStartY(290.0);
        lineH2.setStroke(javafx.scene.paint.Color.WHITE);
        lineH2.setStrokeWidth(4.0);

        lineH1.setEndX(-142.99998474121094);
        lineH1.setEndY(290.0);
        lineH1.setId("lineH1");
        lineH1.setLayoutX(145.0);
        lineH1.setLayoutY(-176.0);
        lineH1.setStartX(143.33334350585938);
        lineH1.setStartY(290.0);
        lineH1.setStroke(javafx.scene.paint.Color.WHITE);
        lineH1.setStrokeWidth(4.0);

        btn2.setId("btn3");
        btn2.setLayoutX(201.0);
        btn2.setLayoutY(30.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(81.0);
        btn2.setPrefWidth(89.0);
        btn2.getStyleClass().add("btn");
        btn2.setTextFill(javafx.scene.paint.Color.WHITE);

        btn5.setId("btn6");
        btn5.setLayoutX(201.0);
        btn5.setLayoutY(117.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(81.0);
        btn5.setPrefWidth(89.0);
        btn5.getStyleClass().add("btn");
        btn5.setTextFill(javafx.scene.paint.Color.WHITE);

        btn6.setId("btn7");
        btn6.setLayoutX(3.0);
        btn6.setLayoutY(205.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(81.0);
        btn6.setPrefWidth(89.0);
        btn6.getStyleClass().add("btn");
        btn6.setTextFill(javafx.scene.paint.Color.WHITE);

        btn8.setId("btn9");
        btn8.setLayoutX(201.0);
        btn8.setLayoutY(205.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(81.0);
        btn8.setPrefWidth(89.0);
        btn8.getStyleClass().add("btn");
        btn8.setTextFill(javafx.scene.paint.Color.WHITE);

        btn0.setId("btn1");
        btn0.setLayoutX(3.0);
        btn0.setLayoutY(30.0);
        btn0.setMnemonicParsing(false);
        btn0.setPrefHeight(81.0);
        btn0.setPrefWidth(89.0);
        btn0.getStyleClass().add("btn");
        btn0.setTextFill(javafx.scene.paint.Color.WHITE);
       
        btn1.setId("btn2");
        btn1.setLayoutX(98.0);
        btn1.setLayoutY(30.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(81.0);
        btn1.setPrefWidth(97.0);
        btn1.getStyleClass().add("btn");
        btn1.setTextFill(javafx.scene.paint.Color.WHITE);

        btn3.setId("btn4");
        btn3.setLayoutX(3.0);
        btn3.setLayoutY(117.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(81.0);
        btn3.setPrefWidth(89.0);
        btn3.getStyleClass().add("btn");
        btn3.setTextFill(javafx.scene.paint.Color.WHITE);

        btn4.setId("btn5");
        btn4.setLayoutX(98.0);
        btn4.setLayoutY(117.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(81.0);
        btn4.setPrefWidth(97.0);
        btn4.getStyleClass().add("btn");
        btn4.setTextFill(javafx.scene.paint.Color.WHITE);

        btn7.setId("btn8");
        btn7.setLayoutX(98.0);
        btn7.setLayoutY(205.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(81.0);
        btn7.setPrefWidth(97.0);
        btn7.getStyleClass().add("btn");
        btn7.setTextFill(javafx.scene.paint.Color.WHITE);

        lineH21.setEndX(-171.0);
        lineH21.setEndY(290.0);
        lineH21.setId("lineH2");
        lineH21.setLayoutX(173.0);
        lineH21.setLayoutY(72.0);
        lineH21.setStartX(182.33334350585938);
        lineH21.setStartY(290.0);
        lineH21.setStroke(javafx.scene.paint.Color.valueOf("#7e7c7c"));
        lineH21.setStrokeWidth(2.0);

        anchorPane.setId("scorePane");
        anchorPane.setLayoutX(6.0);
        anchorPane.setLayoutY(366.0);
        anchorPane.setPrefHeight(140.0);
        anchorPane.setPrefWidth(346.0);

        imageView.setFitHeight(99.0);
        imageView.setFitWidth(53.0);
        imageView.setId("scoreImage");
        imageView.setLayoutX(147.0);
        imageView.setLayoutY(7.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../img/score-icon-2.png").toExternalForm()));

        score.setId("score");
        score.setLayoutX(158.0);
        score.setLayoutY(61.0);
        score.setText("Score");
        score.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        score.setFont(new Font("System Bold", 12.0));

        label.setLayoutX(285.0);
        label.setLayoutY(18.0);
        label.setText("X");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        label.setFont(new Font("System Bold", 32.0));

        label0.setLayoutX(28.0);
        label0.setLayoutY(17.0);
        label0.setText("O");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        label0.setFont(new Font("System Bold", 33.0));

        label1.setLayoutX(160.0);
        label1.setLayoutY(79.0);
        label1.setText("Tie");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 18.0));

        oScoreLabel.setLayoutX(11.0);
        oScoreLabel.setLayoutY(68.0);
        oScoreLabel.setText("oScore");
        oScoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        oScoreLabel.setFont(new Font("System Bold", 18.0));

        xScoreLabel.setLayoutX(270.0);
        xScoreLabel.setLayoutY(61.0);
        xScoreLabel.setText("xScore");
        xScoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        xScoreLabel.setFont(new Font("System Bold", 18.0));

        tieScoreLabel.setLayoutX(141.0);
        tieScoreLabel.setLayoutY(104.0);
        tieScoreLabel.setText("tieScore");
        tieScoreLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        tieScoreLabel.setFont(new Font("System Bold", 18.0));
        setCenter(containerPane);

        contentPane.getChildren().add(gameTitle);
        contentPane.getChildren().add(logo);
        contentPane.getChildren().add(playerName);
        actionPane.getChildren().add(lineV2);
        actionPane.getChildren().add(lineV1);
        actionPane.getChildren().add(lineH2);
        actionPane.getChildren().add(lineH1);
        actionPane.getChildren().add(btn2);
        actionPane.getChildren().add(btn5);
        actionPane.getChildren().add(btn6);
        actionPane.getChildren().add(btn8);
        actionPane.getChildren().add(btn0);
        actionPane.getChildren().add(btn1);
        actionPane.getChildren().add(btn3);
        actionPane.getChildren().add(btn4);
        actionPane.getChildren().add(btn7);
        contentPane.getChildren().add(actionPane);
        contentPane.getChildren().add(lineH21);
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(score);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(oScoreLabel);
        anchorPane.getChildren().add(xScoreLabel);
        anchorPane.getChildren().add(tieScoreLabel);
        contentPane.getChildren().add(anchorPane);
        containerPane.getChildren().add(contentPane);
        xScoreLabel.setText("0");
        oScoreLabel.setText("0");
        tieScoreLabel.setText("0");
        
        /*
        btn0.setText("0");         
        btn1.setText("1");
        btn2.setText("2");
        btn3.setText("3");
        btn4.setText("4");
        btn5.setText("5");
        btn6.setText("6");
        btn7.setText("7");
        btn8.setText("8");
        */

    }
}
