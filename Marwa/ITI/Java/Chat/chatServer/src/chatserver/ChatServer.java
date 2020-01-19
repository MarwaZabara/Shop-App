/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */







package chatserver;

import static chatserver.ChatHandler.clientsVector;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marwazabara
 */



public class ChatServer
{
ServerSocket serverSocket; 
public ChatServer()
{
    try {
        serverSocket = new ServerSocket(5000);
    } catch (IOException ex) {
        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
    }
while(true)
{

        try {
            Socket s;
            s = serverSocket.accept();
             new ChatHandler(s);
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            
        }
 
}
}
public static void main(String[] args) {
   new ChatServer();
}}

class ChatHandler extends Thread {
DataInputStream dis;
PrintStream ps;
static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();
public ChatHandler(Socket cs) {
    try { 
        dis = new DataInputStream(cs.getInputStream());
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        ps = new PrintStream(cs.getOutputStream());
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
clientsVector.add(this);
    start();
}


public void run()
{
while(true)
{

    try {
        String str = dis.readLine();
         sendMessageToAll(str);
    } catch (IOException ex) {
        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
       // clientsVector.remove(this);
    }
 
}}
void sendMessageToAll(String msg) {
for(ChatHandler ch : clientsVector) {
  ch.ps.println(msg);
}}}