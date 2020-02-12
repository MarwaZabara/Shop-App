/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newstartttt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HoSaM
 */
public class NewServer extends Thread {
    
    ServerSocket mSSocket;
    //two connection
    List<Socket> socketList = new ArrayList<>();
//    List<List<Socket>> room = new VirtualFlow.ArrayLinkedList<>();
    
    //DataInputStream dInputStream;
    //DataOutputStream dOutStrem;
   // PrintStream pStream;
    int player ; // 1 for X --  for O
    String s1 = "ahmad";
    String s2 = "marwa";
    static boolean flagReadSocket = true;
    public NewServer() {
        try {
            mSSocket = new ServerSocket(4949);
        } catch (IOException ex) {
            System.out.println("from catch serverSocket");
            Logger.getLogger(NewServer.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        while(true) {
            try {
                System.err.println("@@@@from start while (true) NewServer");
                for (Socket s: socketList) {
                   // System.out.println("s is " + s);                
                }
                if (socketList.isEmpty()) {
                    socketList.add(0,mSSocket.accept());
                    new Handler(socketList.get(0), 1, this, s1); 
                } else if ( socketList.size() == 1) {
                    socketList.add(1,mSSocket.accept());
                    new Handler(socketList.get(1), 2, this, s2);   
                } else {
                    // to accept other player after 2 player connected
                    socketList.clear();
                    //Handler.counPlyer = 0;
                }                
            }
            catch (IOException ex) {
                Logger.getLogger(NewServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }
    
    public static void main(String[] args) {
        System.out.println("This is NewServer");
        new NewServer();
    }
}
