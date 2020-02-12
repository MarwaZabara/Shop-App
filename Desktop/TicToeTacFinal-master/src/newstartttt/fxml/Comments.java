/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newstartttt.fxml;

/**
 *
 * @author HoSaM
 */
public class Comments {
    
                    /*
                if (socketCon[0] == null) {
                   socketCon[0] = mSSocket.accept();
                   new Handler(socketCon[0], 1, this); 
                } else if (socketCon[0] != null && socketCon[1] == null) {
                    socketCon[1] = mSSocket.accept();
                    new Handler(socketCon[1], 2, this);
                    //break;
                } 
                */

    /*
                if (replayStat1YorN.equals(replayStat2YorN) && !replayStat1YorN.equals("f")) {
                    System.out.println("from if YorN");
                    // send to 2 player to reset the game 
                    for (Handler sHandler : conList) {
                        // p1_t_p2_f lnegt = 7
                        sHandler.ps.println("1_t_2_t");
                    }                       
                } else { // one of then refused jsut send the whole str to both to handlet it 
                    // for each player
                    for (Handler sHandler : conList) {
                        // p1_t_p2_f lnegt = 7
                        sHandler.ps.println(replayStatP1Id+"_"+replayStat1YorN+"_"
                        +replayStatP2Id+"_"+replayStat2YorN);
                    }
                }    
     */
 /*
                System.out.println("two plyer send thier response");
                for(String s: replayStr) {
                    System.err.println(" >> " + s);
                }
     */
    
                    /*
                System.out.println("two plyer send thier response");
                for(String s: replayStr) {
                    System.err.println(" >> " + s);
                }
                */
 /*
    System.out.println("## newPlayer  " + newPlayer + " != " + playerComing + "  ##" );
    System.out.println("newPlayer =   playerComing " + newPlayer + "  =  "  + playerComing);

     */
    // disable that send until two curPlayer connect then enable it
    /*
            if ( counPlyer > 2 ) {
                System.out.println("from isConnect a");
                if (curPlayer == 1) {          
                    // send data that recived from players object
                    ps.println(str + " FP1" );  // 3.1
                } else if (curPlayer == 2){
                    ps.println(str + " FB2" );                    
                }
            }
     */
    //                System.err.println("data send in btn %% p1>> " 
//                        + p1 + " btn>> "+ btn_0 + "  turn is >> "+
//                        turnRecived + "move is >> " +  moveRecived);
    //            // take action to send ui 
//            //name_button_row_col_turn_move_win_draw
//            //ps.println(playerComing+"_"+btn+"_1_5_"+vaildTurn+"_t_t" )
//            if ( moveRecived.equals("f")) {
//                System.err.println("from equlrs for move " + moveRecived );
//            }
}
