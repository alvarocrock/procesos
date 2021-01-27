package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class ladoGuest {
	
	DatagramSocket socket;
	InetAddress IPServidor;
	private final int port=9876;
	byte[] enviados;
    byte[] recibidos;
	public ladoGuest() {
		try {
			socket= new DatagramSocket();
			enviados = new byte[1024];
            recibidos = new byte[1024];
            
            IPServidor = InetAddress.getLocalHost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviar(ArrayList<String> lista) {
		for (String s: lista) {
			enviados = s.getBytes();
			DatagramPacket envio = new DatagramPacket (enviados, enviados.length, IPServidor, port);
			
            try {
				socket.send(envio);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String recibir() {
		DatagramPacket recibo = new DatagramPacket (recibidos, recibidos.length);
		
		try {
			socket.receive(recibo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mayuscula = new String(recibo.getData());
		
		return mayuscula;
		 	
	}
	
	public void cerrar() {
		socket.close();
	}

}
