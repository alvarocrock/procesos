package controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Thread.ServerThread;

public class comunication_controller_server {

	ServerSocket servidor;
    
    
    public comunication_controller_server() {
    	try {
			servidor = new ServerSocket(6000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void Ini() {
    	System.out.println("Servidor iniciado...");
        while (true) {
              try {
            	Socket cliente = new Socket();
				cliente=servidor.accept();
				ServerThread thread = new ServerThread(cliente);
				thread.start(); //Se atiende al cliente
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//esperando cliente
              
             
        }// Fin de while	
    }
    
}
