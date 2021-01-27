package Control;

import java.util.ArrayList;
import java.util.Scanner;

import Server.LadoHost;
import Server.ladoGuest;


public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LadoHost lado= new LadoHost();
		String mensaje="";
		String recibido="";
		ArrayList<String> mensajes= new ArrayList<>();
		
		
		System.out.println("Este es el lado de la oscuridad");
		System.out.println("Esperando comunicaciones....");
		while (!mensaje.contains("cambio y corto")|| !recibido.contains("cambio y corto")) {
			
			//recibir paquetes
			
			while (!recibido.contains("cambio")) {
				recibido=lado.recibir();
				System.out.println("lado lumninoso: "+recibido);
				
			}
			if (recibido.contains("cambio y corto")) {
				System.out.println("lado luminoso ha desaparecido");
				lado.cerrar();
			}
			
			System.out.println("Tu turno");
			
			
			//bucle general
			if (recibido.contains("cambio")) {
				recibido="";
				while (!mensaje.contains("cambio")) {
					Scanner sc = new Scanner(System.in);
					mensaje= sc.nextLine();
					
					
					if (!mensaje.contains("cambio")) {
						mensajes.add(mensaje);
						
					} else  {
						mensajes.add(mensaje);
						lado.enviar(mensajes);
						System.out.println("has pasado el turno");
						//limpiamos lista
						mensajes.clear();
						//System.out.println("Esperando comunicaciones....");
					}
					//envias datos	
				}
			}
			if (recibido.contains("cambio y corto") || mensaje.contains("cambio y corto")) {
				lado.cerrar();
				System.out.println("comunicación cortada");
			}
		}
		lado.cerrar();
		System.out.println("comunicación cortada");
	}

}
