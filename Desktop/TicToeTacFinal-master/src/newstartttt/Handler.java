/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newstartttt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handler extends Thread {

    Socket socket;
    NewServer nServer;
    int curPlayer; // 1 for X --  for O
    //int nextPlayer = 0;
    DataInputStream dis;
    PrintStream ps;
//    DataInputStream dtest = new DataInputStream();

    static boolean isPlayersCons = false;
    static List<Handler> conList = new ArrayList<>();
    //  coun plyers so when 2 player connected disable first sendData and excute anthor sendData
    static int counPlyer = 0;

    static int lastPlayerTurn = 0;
    int playerComing;
    //name_turn_move_win_draw
    static String vaildTurn = "t";
    static String validMove = "t";
    static boolean gamePrepared = false;
    static String isPlayerWin = "f";
    static String isNoPlayerWin = "f";
    static long GID;
    // just test
    String pN1;
    String pN2;
    static String[] names = new String[2];

    // Strings for locations if X or O
    static List<String> finalBoardXO = new ArrayList<>();
    // to tack every move on board
    static int[] boardXO = new int[9];
    // when become  9 >> draw
    static int countForMove = 0;

    static List<String> replayDialogStr = new ArrayList<>();
    static boolean IsGameEnd = false;
    // who winners
    static int winner = 0;
    // counter diplayed in ui 
    static int sCountForWinP1 = 0;
    static int sCountForWinP2 = 0;
    static int sCountForDraw = 0;

    boolean flagReadingServer = true;
    static boolean flagP1Left = false;
    static boolean flagP2Left = false;

    public Handler(Socket c, int player, NewServer newServer, String sName) {
        System.out.println("countPlayer is >> " + counPlyer);
        socket = c;
        this.curPlayer = player;
        nServer = newServer;

        //int i = 0;
        try {
            System.out.println("from try cons Handler");
            System.out.println("countPs is >> " + counPlyer);
            dis = new DataInputStream(c.getInputStream());
            ps = new PrintStream(c.getOutputStream());
            if (conList.isEmpty()) {
                System.out.println("is empty server");
                conList.add(0, this);
                counPlyer++;
                names[0] = sName;
                System.out.println("f name is >> " + names[0]);
            } else if (conList.size() == 1) {  // size become 2
                System.out.println("from is size()==1 server");
                conList.add(1, this);
                counPlyer++;
                names[1] = sName;
                DBConnection.AddGame(names[0], names[1]);
                GID = (long) DBConnection.GetGID();
                System.out.println("GID=" + GID);
                System.out.println("names=" + names[0]);
                System.out.println("names=" + names[1]);
                System.out.println("f name is >> " + names[1]);
            }
            start();
        } catch (IOException ex) {
            System.out.println("1- from catch handler");
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
//        String dataReadedFromClient = null;
        // just while true 
        while (flagReadingServer) {
            for (int i : boardXO) {
                System.err.print(i + " - ");
            }
            // System.err.println(" >>counPlyer is<<  " + counPlyer ); //1.1 -2.1 - 3.2
            // send number of  two curPlayer to client to make a different between them
            // if there is o p Or 2 that good - but once it was 2 curPlayer then diable that print
            if (counPlyer <= 2 || !gamePrepared) {
                // send with playerid a vlaue reperesent 2 player or one
                if (counPlyer == 1) {
                    ps.println(curPlayer);
                    //ps.println("ali");
                } else if (counPlyer == 2) {
                    ps.println(curPlayer);
                    counPlyer++;
                    gamePrepared = true;
                    //ps.println("hossam");
                }

            }
            afterTwoPlayerConntected();
        }
    }

    /**
     * read data from 1 player at a time check if game not ended yet check for
     * valid turn and valid move if game end call the right method to handle it
     */
    private void afterTwoPlayerConntected() {

        String dataReadedFromPlayer = null;
        try {
            System.out.println("from try read server");
//            DBConnection.AddGame(names[0], names[1]);
//            long GID = (long) DBConnection.GetGID();
//            System.out.println("GID=" + GID);
//            System.out.println("names=" + names[0]);
//            System.out.println("names=" + names[1]);
            // read data sended from players object - btn clicked
            // just reading
            dataReadedFromPlayer = dis.readLine();
            // System.out.println("PLAYER ReplayStr is >> " + dataReadedFromClient);
        } catch (IOException ex) {
            System.out.println("2- from readline handler");
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // code did not reach here until
        //stat = dataReadedFromClient.split("-");
        // 2 player connected so start operation of the game
        if (dataReadedFromPlayer.length() == 6) {
            whenReciveStrOfClosedPlayer(dataReadedFromPlayer);

        } else if (counPlyer > 2 && !IsGameEnd) {
            gameOperations(dataReadedFromPlayer);
        } // the game has ended strat new operations 
        // maybe MUST put a contition
        else {
            afterGameFinished(dataReadedFromPlayer);
        }
    }

    private void whenReciveStrOfClosedPlayer(String dReadedFromPlayer) {
        System.out.println("data sended from close " + dReadedFromPlayer);
        counPlyer = 0;
        // String close = dataReadedFromPlayer.split("_")[1];
        int player = Integer.parseInt(dReadedFromPlayer.split("_")[0]);
        try {
            dis.close();
            flagReadingServer = false;
            // 123456 meaning less just with size 6 to differnt from other str stats
            if (player == 1) {
                System.out.println("from close server p1");
                // send to second
                // coz if p2 aleardy left i do not want to sen anthing to it
                if (!flagP2Left) {
                    conList.get(1).ps.println("123456");
                }
                conList.remove(0);
                flagP1Left = true;
            } else if (player == 2) {
                System.out.println("from close server  p2");
                conList.get(0).ps.println("123456");
                // coz if the p1 already left so the index will be 0 not 1 
                if (flagP1Left) {
                    conList.remove(0);
                } else { // in case if p2 closed first 
                    conList.remove(1);
                    flagP2Left = true;
                }
            }
            for (Handler sHandler : conList) {
                System.err.println("@@@cur is  is >> " + sHandler.curPlayer);
            }
        } catch (IOException ex) {
            System.out.println("addCatch close dis");
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // NewServer.flagReadSocket = true;
    }

    /**
     * do operations of game -- check valid turn and move -- calling the right
     * methods
     *
     * @param dReadedFromPlayer
     */
    private void gameOperations(String dReadedFromPlayer) {
        String pId = dReadedFromPlayer.split("_")[0]; // player number
        String moveRecived = dReadedFromPlayer.split("_")[3];

        //String pTurn = dataReadedFromClient.split("_")[3];
        int btn = Integer.parseInt(dReadedFromPlayer.split("_")[1]);
        System.err.println("btn is ## " + btn);
        playerComing = Integer.parseInt(pId);
        boolean isVailedTurn = checkIsVaildTurn();
        //                     0   1   2    3   4    5
        //CONTRACT STATMENT name_btn_turn_move_win_draw
        //&& pTurn.equals("t")
        System.out.println("&&&- Com str is ?? >> " + dReadedFromPlayer);
        System.out.println("turn before ifIsVaildTurn str is >> " + moveRecived);
        // && moveRecived.equals("t")
        if (isVailedTurn == true) {
            System.out.println("@@Valid turn");
            boolean isVailedMove = checkIsVaildMove(btn, Integer.parseInt(pId));
            System.out.println("dSendFrom VaildTrue p is >> " + playerComing + "-btn is>>"
                    + "-va");
            if (isVailedMove == true) {
                afterItsVaildMove(btn);
            } else { // invaild move
                // if vaild move the lastPlayerTurn will changed to anthor player
                // and no longer can make a move so i will return it to same player
                // so can make anthor plays
                if (lastPlayerTurn == 1) {
                    lastPlayerTurn = 2;
                } else if (lastPlayerTurn == 2) {
                    lastPlayerTurn = 1;
                }
                //invaild move tell client to diplay dialog
                ps.println(playerComing + "_" + btn + "_" + vaildTurn + "_"
                        + validMove + "_" + isPlayerWin + "_" + isNoPlayerWin);
            }
        } else { // invalid turn
            System.out.println("@@invalid turn");
            ps.println(playerComing + "_" + btn + "_" + vaildTurn + "_"
                    + validMove + "_" + isPlayerWin + "_" + isNoPlayerWin);
            System.err.println("turn after evluate and send to player ");
        }
    }

    /**
     * check for winner then send to 2 players to tell then the results if there
     * is a winner increment right counter weather is p1 or p2 or draw then set
     * vara >> gameEnd << to true and >> resetGame() << TODO Store in database
     * @param btn:
     */
    private void afterItsVaildMove(int btn) {
        System.out.println("@@Valid move");
        // Send to 2 player to update ui then
        for (Handler sHandler : conList) {
            isWinner();
            sHandler.ps.println(playerComing + "_" + btn + "_" + vaildTurn + "_"
                    + validMove + "_" + isPlayerWin + "_" + isNoPlayerWin);
            System.err.println("@@@winner is >> " + playerComing);
        }
        // if GAMEOVER  so send game board to database
        if (isPlayerWin.equals("t") || isNoPlayerWin.equals("d")) {
            // save winner in own variable
            // see which winner to count the wins time
            winner = playerComing;
            if (isPlayerWin.equals("t") && winner == 1) {
                System.out.println("from countForWinP1");
                sCountForWinP1++;
            } else if (isPlayerWin.equals("t") && winner == 2) {
                System.out.println("from countForWinP2");
                sCountForWinP2++;
            } else {
                System.out.println("from countForDraw");
                sCountForDraw++;
            }
            // ####### Marwa #########
            // TODO >> DataBase >> send final draw to database -- and counters

            // That forloop Diplay content of final bored
            for (int i = 0; i < finalBoardXO.size(); i++) {
                System.err.println(finalBoardXO.get(i));
            }
            IsGameEnd = true;

            System.out.println("Finalborad=" + finalBoardXO);

//            Thread th = new Thread(new Runnable() {
//                @Override
//                public void run() {
        
            System.err.println("from t in hamdler");

            for (int i = 0; i < finalBoardXO.size(); i++) {
                System.out.println(finalBoardXO.get(i));
                String dr = finalBoardXO.get(i);
                String[] ss = new String[4];
                ss = dr.split("_");
                int pos = Integer.parseInt(ss[0]);
                int cplayer = Integer.parseInt(ss[1]);
                System.out.println("pos=" + ss[0]);
                if (Integer.parseInt(ss[1]) == 1) {
                
                }

                // System.out.println("player=" + p);
                System.out.println("GID in moves=" + GID);
                DBConnection.AddMove(GID, i + 1, pos, names[cplayer - 1]);

            }
            DBConnection.SetWinner(GID, names[winner-1]);
//                }
//            });
            //  th.start();

            resetGame();
            System.err.println("winner end of game");
        }
    }

    /**
     * reset all variable of the game to start point after game is ended
     */
    private void resetGame() {
        System.out.println("count p1 is ? " + sCountForWinP1
                + "-* count p2 ?? " + sCountForWinP2
                + "-* count darw ?? " + sCountForDraw);
        //boardXO = 0;
        Arrays.fill(boardXO, 0);
        lastPlayerTurn = 0;
        winner = 0;
        countForMove = 0;
        isPlayerWin = "f";
        isNoPlayerWin = "f";
        finalBoardXO.clear();
        vaildTurn = "t";
        validMove = "t";
        //counPlyer = 0; // make a problem
    }

    /**
     * read data from 2 players store it in array >> (replayDialogStr) of 2
     * element and once the array is check the response of each player if they
     * want to play again or not the clear the array to check again if game is
     * ended again then send the replay to 2 players and set endGame to be false
     * to continue plays
     *
     * @param dReadedFromClient : data like << pID_YorN >> [0] = 1_t -- [1] =
     * 2_f
     */
    private void afterGameFinished(String dReadedFromClient) {

        // after game ended
        System.err.println("from else end Game && " + dReadedFromClient);
        replayDialogStr.add(dReadedFromClient);
        if (replayDialogStr.size() == 2) {
            //if that contion true so you have reponseo of the 2 client to the
            //  pId_Y ot No  >> 1_t
            String replayStatP1Id = replayDialogStr.get(0).split("_")[0];  // 1 or 2
            String replayStat1YorN = replayDialogStr.get(0).split("_")[1]; // t or f
            String replayStatP2Id = replayDialogStr.get(1).split("_")[0];
            String replayStat2YorN = replayDialogStr.get(1).split("_")[1];

            System.out.println(replayStatP1Id + "-" + replayStat1YorN + "-"
                    + replayStatP2Id + "-" + replayStat2YorN);
            System.out.println("1_t_2_t".length());

            // if they want to play again send to 2 player to reset the game
            if (replayStat1YorN.equals(replayStat2YorN) && !replayStat1YorN.equals("f")) {
                System.out.println("from if YorN");
                for (Handler sHandler : conList) {
                    // p1_t_p2_f lnegt = 7
                    // sHandler.ps.println("1_t_2_t");
                    sHandler.ps.println(replayStatP1Id + "_" + replayStat1YorN + "_"
                            + replayStatP2Id + "_" + replayStat2YorN);
                    // send who wins to each player
                    //sHandler.ps.println(winner);
                    sHandler.ps.println(sCountForWinP1 + "_" + sCountForWinP2
                            + "_" + sCountForDraw);
                }
                replayDialogStr.clear();
                // must be here to make it enter the right read Contition
                IsGameEnd = false;
            } else { // one of then refused jsut send the whole str to both to handlet it
                // for each player
                for (Handler sHandler : conList) {
                    // p1_t_p2_f lnegt = 7
                    sHandler.ps.println(replayStatP1Id + "_" + replayStat1YorN + "_"
                            + replayStatP2Id + "_" + replayStat2YorN);
                    sHandler.ps.println(sCountForWinP1 + "_" + sCountForWinP2
                            + "_" + sCountForDraw);
                }
                replayDialogStr.clear();
            }
        }
        //nServer.socketList.clear();  
    }

    /**
     * see if the lastPlayerTurn is equals to the playerComing
     *
     * @return true and make vaildTurn="t" and that means if they not equals
     * valid turn
     */
    private boolean checkIsVaildTurn() {
        boolean vaild = false;
        // at first nP = 0 then will be false
        if (lastPlayerTurn != playerComing) { // dif players
            lastPlayerTurn = playerComing;
            vaildTurn = "t";
            vaild = true;
        } else {
            vaildTurn = "f";
            vaild = false;
        }
        return vaild;
    }

    /**
     * take a button and the player who plays and check the button clicked in
     * the board of game if the button if empty put plauerId on the board then
     * make the validMove="t" of "f"
     *
     * @param btn : the button has clicked on
     * @param pId : the player who plays
     * @return ture if the mark on the empty place
     */
    private boolean checkIsVaildMove(int btn, int pId) {
        boolean vaild = false;
        if (boardXO[btn] == 0) { // vaild move
            boardXO[btn] = pId;
            validMove = "t";
            vaild = true;
            // 0_7_2
            finalBoardXO.add(countForMove, btn + "_" + pId);
            System.out.println("@#@# move ->> " + countForMove + " <<- is >> "
                    + finalBoardXO.get(countForMove));
            countForMove++;
        } else {
            validMove = "f";
            vaild = false;
        }
        return vaild;
    }

    /**
     * see if there is a matched 3 values in array updates flags to be f or t or
     * d
     */
    private void isWinner() {
        boolean isWin = false;
        // 1 row
        if (boardXO[0] == boardXO[1] && boardXO[1] == boardXO[2] && boardXO[0] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 2 row
        else if (boardXO[3] == boardXO[4] && boardXO[4] == boardXO[5] && boardXO[3] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 3 row 
        else if (boardXO[6] == boardXO[7] && boardXO[7] == boardXO[8] && boardXO[6] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 1 col
        else if (boardXO[0] == boardXO[3] && boardXO[3] == boardXO[6] && boardXO[0] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 2 col
        else if (boardXO[1] == boardXO[4] && boardXO[4] == boardXO[7] && boardXO[1] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 3 col
        else if (boardXO[2] == boardXO[5] && boardXO[5] == boardXO[8] && boardXO[2] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 0 interaction
        else if (boardXO[0] == boardXO[4] && boardXO[4] == boardXO[8] && boardXO[0] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 2 interaction
        else if (boardXO[2] == boardXO[4] && boardXO[4] == boardXO[6] && boardXO[2] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } else if (countForMove == 9) {
            //isPlayerWin = "f";
            isNoPlayerWin = "d";
            isWin = false;
        }
        System.err.println("isWin is >  " + isWin);
        // return isWin;
    }

}
