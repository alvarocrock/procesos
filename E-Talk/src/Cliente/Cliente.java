package Cliente;

import java.util.ArrayList;
import java.util.Scanner;

import Server.ladoGuest;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ladoGuest lado= new ladoGuest();
		String mensaje="";
		String recibido="";
		ArrayList<String> mensajes= new ArrayList<>();
		
		
		
		
		System.out.println("Este es el lado de la luz");
		//System.out.println("Tu turno");
		System.out.println("Tu turno");
		
		//bucle general
		while (!mensaje.equals("cambio y corto") || !recibido.equals("cambio y corto")) {
			
			Scanner sc = new Scanner(System.in);
			mensaje= sc.nextLine();
			
			
			if (!mensaje.contains("cambio")) {
				//envias datos
				mensajes.add(mensaje);
			} else {
				mensajes.add(mensaje);
				lado.enviar(mensajes);
				System.out.println("has pasado el turno");
				//limpiamos lista
				mensajes.clear();
			}
			
			if  (mensaje.contains("cambio y corto")) {
				lado.enviar(mensajes);
				lado.cerrar();
				System.out.println("Has acabado la comunicación");
			}
			//enviar mensajes y limmpiar lista
			
			
			if (mensaje.equals("cambio")) {
			//bucle para recibir paquetes
				System.out.println("Esperando comunicaciones....");
				while (!recibido.contains("cambio")) {
					recibido=lado.recibir();
					System.out.println("lado oscuro: "+recibido);
					
				}
				if (recibido.contains("cambio y corto")) {
					System.out.println("lado oscuro ha desaparecido");
					//lado.cerrar();
				} else  if (recibido.contains("cambio")) {
					//System.out.println("Tu turno");
				}
			
			}
			
			if (recibido.contains("cambio y corto")) {
				//lado.enviar(mensajes);
				lado.cerrar();
				System.out.println("Han acabado la comunicación");
			} 
		}
		System.out.println("comunicación cortada");

	}

}
