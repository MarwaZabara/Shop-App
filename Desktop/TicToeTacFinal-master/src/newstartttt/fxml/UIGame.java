package newstartttt.fxml;

import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class UIGame extends AnchorPane {

    protected final Label label;
    protected final TextField textField;
    protected final TextField textField0;
    protected final Pane pane;
    protected final Button btn0;
    protected final Button btn1;
    protected final Button btn2;
    protected final Button btn4;
    protected final Button btn3;
    protected final Button btn5;
    protected final Button btn7;
    protected final Button btn6;
    protected final Button btn8;

    public UIGame() {

        label = new Label();
        textField = new TextField();
        textField0 = new TextField();
        pane = new Pane();
        btn1 = new Button();
        btn0 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn7 = new Button();
        btn6 = new Button();
        btn8 = new Button();

        setId("AnchorPane");
        setPrefHeight(200);
        setPrefWidth(200);

        label.setLayoutX(126.0);
        label.setLayoutY(120.0);
        label.setMinHeight(16.0);
        label.setMinWidth(69.0);

        textField.setLayoutX(14.0);
        textField.setLayoutY(7.0);
        textField.setPrefHeight(46.0);
        textField.setPrefWidth(154.0);

        textField0.setLayoutX(244.0);
        textField0.setLayoutY(7.0);
        textField0.setPrefHeight(46.0);
        textField0.setPrefWidth(154.0);

        pane.setLayoutX(97.0);
        pane.setLayoutY(53.0);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(231.0);

       

        btn0.setLayoutX(14.0);
        btn0.setLayoutY(14.0);
        btn0.setMnemonicParsing(false);
        btn0.setPrefHeight(57.0);
        btn0.setPrefWidth(70.0);
        btn0.setText("");
        
        btn1.setLayoutX(84.0);
        btn1.setLayoutY(14.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(57.0);
        btn1.setPrefWidth(70.0);
        btn1.setText("");

        btn2.setLayoutX(154.0);
        btn2.setLayoutY(14.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(57.0);
        btn2.setPrefWidth(70.0);
        btn2.setText("");

        btn4.setLayoutX(84.0);
        btn4.setLayoutY(71.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(57.0);
        btn4.setPrefWidth(70.0);
        btn4.setText("");

        btn3.setLayoutX(14.0);
        btn3.setLayoutY(71.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(57.0);
        btn3.setPrefWidth(70.0);
        btn3.setText("");

        btn5.setLayoutX(154.0);
        btn5.setLayoutY(71.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(57.0);
        btn5.setPrefWidth(70.0);
        btn5.setText("");

        btn6.setLayoutX(14.0);
        btn6.setLayoutY(128.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(57.0);
        btn6.setPrefWidth(70.0);
        btn6.setText("");
        
        btn7.setLayoutX(84.0);
        btn7.setLayoutY(128.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(57.0);
        btn7.setPrefWidth(70.0);
        btn7.setText("");
        
        btn8.setLayoutX(154.0);
        btn8.setLayoutY(128.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(57.0);
        btn8.setPrefWidth(70.0);
        btn8.setText("");

        getChildren().add(label);
        getChildren().add(textField);
        getChildren().add(textField0);
        pane.getChildren().add(btn1);
        pane.getChildren().add(btn0);
        pane.getChildren().add(btn2);
        pane.getChildren().add(btn4);
        pane.getChildren().add(btn3);
        pane.getChildren().add(btn5);
        pane.getChildren().add(btn7);
        pane.getChildren().add(btn6);
        pane.getChildren().add(btn8);
        getChildren().add(pane);
        
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Coni");
        a.setHeaderText("Do You Want Save Changes");
        ButtonType  save = new ButtonType ("Save");
        ButtonType  dsave = new ButtonType ("Don't save");
        ButtonType  cancel = new ButtonType ("cancel");

        a.getButtonTypes().clear();
        a.getButtonTypes().addAll(save, dsave, cancel);

        Optional<ButtonType> option ;
        option = a.showAndWait();
        if (option.get() == save) {

        } else if (option.get() == dsave) {

        } else if (option.get() == cancel) { 
            Platform.exit();
        } 

                                       

    }
}
