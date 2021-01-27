package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

//modelo https://github.com/joseprofe/PSP/blob/master/TCP_IP/src/UDP/ServidorUDP2.java
public class LadoHost {
	
	 DatagramSocket serverSocket;
     byte[] recibidos;
     byte[] enviados;
     private final int port=9876;
     DatagramPacket paqRecibido;
	
	public LadoHost() {
		try {
			serverSocket = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String recibir() {
		
		recibidos = new byte[1024];
        paqRecibido = new DatagramPacket (recibidos, recibidos.length);
        try {
			serverSocket.receive(paqRecibido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String cadena = new String(paqRecibido.getData());
        
        return cadena;
	}
	
	public void enviar(ArrayList<String> lista) {
		for (String s: lista) {
			InetAddress IPOrigen = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
			enviados = s.getBytes();
            
            //ENVIO DATAGRAMA AL CLIENTE
            DatagramPacket paqEnviado = new DatagramPacket (enviados, enviados.length, IPOrigen, puerto);
            
            try {
				serverSocket.send(paqEnviado);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cerrar() {
		serverSocket.close();
	}
	
	
	

}
