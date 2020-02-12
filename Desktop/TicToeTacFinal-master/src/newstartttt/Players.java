package newstartttt;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Players extends Application {
    //UIGame uIGame = new UIGame();

    gameSceneH gameScene = new gameSceneH();
    Socket sClient;
    DataInputStream dInputStream;
    PrintStream pStream;

    // strings of btns
    final String btn_0 = "0";
    final String btn_1 = "1";
    final String btn_2 = "2";
    final String btn_3 = "3";
    final String btn_4 = "4";
    final String btn_5 = "5";
    final String btn_6 = "6";
    final String btn_7 = "7";
    final String btn_8 = "8";
    // static boolean is2Player = false;

    String dReaded;
    String p1; // hold number of p1  //1
    String p2; // hold number of p2  //2

    String[] dataReaedArray;

    String playerRecived = "t";
    String btnRecived = "t";
    String turnRecived = "t";
    String moveRecived = "t";
    String winState;
    String drawStat;
    // was static
    boolean flagReadingPlayer = true;

    String isReplay = "r";

    String[] strCounters = new String[3];

    // TODO problen with sound running in backgroud
    private void clickBtnSound() {
        Platform.runLater(() -> {
            String path2 = "test.mp3";

            //Instantiating Media class
            Media med = new Media(new File(path2).toURI().toString());

            //Instantiating MediaPlayer class
            MediaPlayer click = new MediaPlayer(med);

            click.setAutoPlay(true);
        });

    }

    public Players() {
        try {
            System.out.println("from try cons player");
            sClient = new Socket("127.0.0.1", 4949);
            // sClient = new Socket("172.16.4.159", 4949);

            dInputStream = new DataInputStream(sClient.getInputStream());
            pStream = new PrintStream(sClient.getOutputStream());
        } catch (IOException ex) {
            System.err.println("1-From SockeClient - input-outputStreams ");
        }
        ThreadOperations operations = new ThreadOperations();
        Thread thread = new Thread(operations);
        thread.start();

        //                     0   1   2    3   4    5
        //CONTRACT STATMENT name_btn_turn_move_win_draw
        gameScene.btn0.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_0 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_0 + "_" + turnRecived + "_" + moveRecived);
            }
            //clickBtnSound();
        });

        gameScene.btn1.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_1 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_1 + "_" + turnRecived + "_" + moveRecived);
            }
            // clickBtnSound();

        });
        gameScene.btn2.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_2 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_2 + "_" + turnRecived + "_" + moveRecived);
            }
            // clickBtnSound();

        });

        gameScene.btn3.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_3 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_3 + "_" + turnRecived + "_" + moveRecived);
            }
            //          clickBtnSound();

        });

        gameScene.btn4.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_4 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_4 + "_" + turnRecived + "_" + moveRecived);
            }
            // clickBtnSound();

        });

        gameScene.btn5.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_5 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_5 + "_" + turnRecived + "_" + moveRecived);
            }
        });

        gameScene.btn6.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_6 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_6 + "_" + turnRecived + "_" + moveRecived);
            }
        });

        gameScene.btn7.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_7 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_7 + "_" + turnRecived + "_" + moveRecived);
            }
        });

        gameScene.btn8.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_8 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_8 + "_" + turnRecived + "_" + moveRecived);
            }
        });
    }

    class ThreadOperations implements Runnable {

        @Override
        public void run() {

            while (flagReadingPlayer) {
                try {
                    dReaded = dInputStream.readLine();
                    //String s = dInputStream.readLine();
                    //System.out.println("sec is >> " + s);
                    // String dR2 = dInputStream.readLine();
                    System.err.println("dr1 is >> " + dReaded);
                    //System.err.println("dr2 is >> " + dR2);
                    // see is the second plyae exit
                    //>>>>
                    // coz at the end of the game dRead at some point will be null
                    // and i do not want to throw an exception
                    if (dReaded != null) {
                        if (dReaded.length() == 6) {
                            System.out.println("anthor player closed");
                            displayDialog("Sorry the second player exit the game",
                                    "Conection Termiation");
                            flagReadingPlayer = false;
                            // alert then go to back screen
                        }
                        //>>
                        // to check which player that data send from
                        if (dReaded.equals("1") && dReaded != null) {
                            p1 = dReaded;
                            System.err.println("int value client p1 is >> " + p1);
                            //newS.textField.setText(s);      
                            //System.err.println("bool value client >>  " + is2Player);
                        } else if (dReaded.equals("2") && dReaded != null) {
                            p2 = dReaded;
                            System.err.println("int value client p2 is >> " + p2);
                            //newS.textField.setText(s);
                            // data comming from server like 1_t_2_f so len is 7
                        } // if game finished and need to know play again or not
                        else if (dReaded.length() == 7) {
                            afterGameEnded();
                        } // here normal game has began and two cleint can send and recive from the server
                        else {
                            System.err.println("data read from server is >> " + dReaded);
                            // when server send tp remaing player that the first one has left
                            // the game wil send an str with len of 6 and i do not want
                            // to enter that method if len is 6
                            if (dReaded.length() != 6) {
                                processDataReturnFromServer(dReaded);                                                       
                            }
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("2-from readLinePlayer");
                    Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void processDataReturnFromServer(String dataReaded) {
            //                     0   1   2    3   4    5
            //CONTRACT STATMENT name_btn_turn_move_win_draw
            dataReaedArray = dataReaded.split("_");
            playerRecived = dataReaedArray[0];
            btnRecived = dataReaedArray[1];
            turnRecived = dataReaedArray[2];
            moveRecived = dataReaedArray[3];
            winState = dataReaedArray[4];
            drawStat = dataReaedArray[5];
            System.out.println("%^%^ >> pRecived is " + playerRecived);
            System.out.println("str from process is  >> " + dataReaded);
//            System.err.println("FProcDaFServer^name is >> " + playerRecived + " $$ btn is >> " + btnRecived
//                    + " $$ turn is >> " + turnRecived + " $$ move is >> " + moveRecived);
            if (turnRecived.equals("t")) { // vaild turn
                if (moveRecived.equals("t")) { // vaild move
                    //set text to ui
                    int whichBtnClicked = Integer.parseInt(btnRecived);
                    int playerId = Integer.parseInt(playerRecived);
                    System.out.println("@@- p is >> " + playerId + " btn is >> " + whichBtnClicked);
                    // update ui by x or o
                    whichButtonClicked(whichBtnClicked, playerId);
                    checkForWinsDraw(playerId);
                } else { // Invaild move
                    displayDialog("InVaild Move please, try again", "invalid move");
                }
            } else { // invaild turn
                displayDialog("You Already played please wait for anthor player", "Not Your Turn");
            }
        }

        /**
         * take player ID and compare it with winState to see if there is a win
         * or in case of win -- see which player has win and display right
         * dialog and celebration to each player
         *
         * @param playerId: player ID compare it with winState to see
         */
        private void checkForWinsDraw(int playerId) {
            // Checks For WINNER after drar
            if (winState.equals("t")) {
                // chech if winner wehtaer p1 or p1
                // then display lose dialoge to loser
                // the code enter weahter if of p1 or p2 and MUST enter to else of them
                // which mean other player
                Fade(gameScene.lineH1);
                Fade(gameScene.lineH1);
                Fade(gameScene.lineV1);
                Fade(gameScene.lineV2);
                if (playerRecived.equals(p1)) {
                    //  displayDialog("Congrats ", "you win");
                    //  isWinners = true;
                    // TODO Displya celebration
                    displayDialogReplayGame();
                    // YASMEEN
                } else if (playerRecived.equals(p2)) {
                    // displayDialog("Congrats ", "you win");
                    //   isWinners = true;
                    // TODO Displya celebration
                    displayDialogReplayGame();
                } else {
                    // displayDialog("Sorry ", "you lost");
                    //  isWinners = true;
                    // TODO Displya celebration
                    displayDialogReplayGame();
                }
                System.out.println("there is a winner + pId >> " + playerId);
            } else if (drawStat.equals("d")) {
                displayDialogReplayGame();
                //displayDialog("Draw", "no Winner");
                //isWinners = true;
                System.out.println("presc is >> " + playerRecived);
            }
        }

        /**
         * read from server that "1_t_1_f" which means weather player want to
         * play again or not if want to set text of btns to "" and read from
         * another stream 3 counter of game
         */
        private void afterGameEnded() {
            String dReaded2 = null;
            try {
                // read 3 counter -- p1Wins - p2Wins - draw
                dReaded2 = dInputStream.readLine();
            } catch (IOException ex) {
                System.out.println("3- from  afterGameEnded.readLine()");
                Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("dRead  is >> " + dReaded);
            System.out.println("dRead2  is >> " + dReaded2);
            strCounters = dReaded2.split("_");
            //check to see the data to which player if values play again
            // set all buttons to "" so can play again
            //String replayStatP1Id  = dReaded.split("_")[0];  // 1 or 2
            String replayStat1YorN = dReaded.split("_")[1]; // t or f
            //String replayStatP2Id  = dReaded.split("_")[2];
            String replayStat2YorN = dReaded.split("_")[3];
            System.out.println("stat is ><>< " + dReaded);
            if (p1 != null && p1.equals("1")) { // case player one
                if (replayStat1YorN.equals("t")) {
                    if (replayStat2YorN.equals("f")) {
                        // then back to privous screen
                        System.out.println("sorry p2 refused the request");
                    } else if (replayStat2YorN.equals("t")) {
                        // set ui to new game
                        setTextNull();
                        System.out.println("all accept stat new game from " + p1);
                    }
                } else if (replayStat1YorN.equals("f")) {
                    System.out.println("p1 refused )");
                    // then back to privous screen
                }
                // update counter for player wins
                // 1_1__1                
                Platform.runLater(() -> {
                    gameScene.xScoreLabel.setText(strCounters[0]);
                    gameScene.oScoreLabel.setText(strCounters[1]);
                    gameScene.tieScoreLabel.setText(strCounters[2]);
                });

            } // case player 2
            else if (p2 != null && p2.equals("2")) {
                if (replayStat2YorN.equals("t")) {
                    if (replayStat1YorN.equals("f")) {
                        // then back to privous screen
                        System.out.println("sorry p1 refused the request");
                    } else if (replayStat1YorN.equals("t")) {
                        // set ui to new game
                        setTextNull();
                        System.out.println("all accept stat new game from " + p2);
                    }
                } else if (replayStat2YorN.equals("f")) {
                    System.out.println("p2 refused )");
                    // then back to privous screen
                }
                // update counter for player wins
                Platform.runLater(() -> {
                    gameScene.xScoreLabel.setText(strCounters[0]);
                    gameScene.oScoreLabel.setText(strCounters[1]);
                    gameScene.tieScoreLabel.setText(strCounters[2]);
                });
            }
            System.err.println("#@# len is 7 " + dReaded);
        }

        private void setTextNull() {
            Platform.runLater(() -> {
                gameScene.btn0.setText("");
                gameScene.btn1.setText("");
                gameScene.btn2.setText("");
                gameScene.btn3.setText("");
                gameScene.btn4.setText("");
                gameScene.btn5.setText("");
                gameScene.btn6.setText("");
                gameScene.btn7.setText("");
                gameScene.btn8.setText("");
            });

        }

        /**
         * take the button clicked and pId that click then send those data to
         * printXorO() to set the button to X or o
         *
         * @param whichBtnClicked : which button are clicked
         * @param playerId : who has played
         */
        private void whichButtonClicked(int whichBtnClicked, int playerId) {
            switch (whichBtnClicked) {
                case 0:
                    printXorO(playerId, gameScene.btn0);
                    break;
                case 1:
                    printXorO(playerId, gameScene.btn1);
                    break;
                case 2:
                    printXorO(playerId, gameScene.btn2);
                    break;
                case 3:
                    printXorO(playerId, gameScene.btn3);
                    break;
                case 4:
                    printXorO(playerId, gameScene.btn4);
                    break;
                case 5:
                    printXorO(playerId, gameScene.btn5);
                    break;
                case 6:
                    printXorO(playerId, gameScene.btn6);
                    break;
                case 7:
                    printXorO(playerId, gameScene.btn7);
                    break;
                case 8:
                    printXorO(playerId, gameScene.btn8);
                    break;
            }
        }

        /**
         * take numbers of player and buttons to check appropriate player to Set
         * weather X or O on the button then disable the button so can not click
         * in that button again
         *
         * @param pId : player number
         * @param btn : button number
         */
        public void printXorO(int pId, Button btn) {
            Platform.runLater(() -> {
                if (pId == 1) {
                    btn.setText("X");
                } else if (pId == 2) {
                    btn.setText("O");
                }
                // btn.setDisable(true);
            });
        }

        public void displayDialog(String title, String content) {
            Platform.runLater(() -> {
                System.out.println("from alert");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(content);
                alert.setHeaderText(null);
                alert.setContentText(title);
                alert.showAndWait();
            });
        }

        /**
         * display dialog ask them if want to replay -- receive their response
         * then see which client that take the action then send the action and
         * the player who took the action to server to see if they want play
         * again or not and sent a proper strStat to server
         */
        private void displayDialogReplayGame() {
            Platform.runLater(() -> {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Game Finished");
                a.setHeaderText("Do You Want Play Again");
                ButtonType yes = new ButtonType("Yes");
                ButtonType no = new ButtonType("No");
                //ButtonType  cancel = new ButtonType ("cancel");
                a.getButtonTypes().clear();
                a.getButtonTypes().addAll(yes, no);
                Optional<ButtonType> option;
                option = a.showAndWait();
                if (option.get() == yes) {
                    System.out.println("yes btn click");
                    isReplay = "t";
                } else if (option.get() == no) {
                    System.out.println("no btn click");
                    isReplay = "f";
                }
                if (p1 != null && p1.equals("1")) {
                    System.out.println("from p1 alert");
                    pStream.println(p1 + "_" + isReplay);
                } else if (p2 != null && p2.equals("2")) {
                    System.out.println("from p2 alert");
                    pStream.println(p2 + "_" + isReplay);
                }
            });
        }

        // YASMEEN
        public void Fade(Line n) {
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(400));
            fade.setFromValue(10);
            fade.setToValue(0.1);

            fade.setCycleCount(10);
            fade.setAutoReverse(true);
            fade.setNode(n);
            fade.play();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(gameScene);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("this is NewClient");
        // TODO speard class ouside main to can stop it
        /* play music
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
                     Logger.getLogger(Players.class.getName()).log(Level.SEVERE, null, e);
                    System.out.println("error");
                }
            }
        });
         */
        launch(args);

    }

    @Override
    public void stop() throws Exception {
        // _11 meaning less just with size 6 to differnt from other str stats
        if (p1 != null && p1.equals("1")) {
            System.out.println("close clicked >> p1 send to server");
            flagReadingPlayer = false;
            pStream.println(p1 + "_" + "c" + "_11");
        } else if (p2 != null && p2.equals("2")) {
            System.out.println("close clicked >> p2 send to server");
            flagReadingPlayer = false;
            pStream.println(p2 + "_" + "c" + "_11");
        }
        System.exit(0);
    }

}
