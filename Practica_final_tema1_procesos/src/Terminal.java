import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Terminal {
	//constante para ejercicio 3 , 4 y 5
	final static String IP="IPv4";
	
	final static String MAC="f¡sica";
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		boolean valor=ElegirEjercicio();
		
		//si elegir ejercicio es false, significa que no se ha elegido una opción correcta
		while (valor !=true) {
			valor=ElegirEjercicio();
		}
	
	}
	
	
	
	/**
	 * Proceso que devuelve un valor para realizar un ejercicio u otro
	 * @return
	 */
	public static int PedirEleccion() {
		Scanner sc = new Scanner(System.in);
		int numero;
		System.out.println("Introduce la opcion del ejercicio: ");
		System.out.println("SOLO ADMINTE VALORES NUMERICOS!!!!!!");
		System.out.println("Si es el ejercicio 1 pulse 1.");
		System.out.println("Si es el ejercicio 2 pulse 2.");
		System.out.println("Si es el ejercicio 3 pulse 3.");
		System.out.println("Si es el ejercicio 4 pulse 4.");
		System.out.println("Si es el ejercicio 5 pulse 5.");
		System.out.println("Si es el ejercicio 6 pulse 6.");
		System.out.println("Si sesea salir pulse 7");
		numero=sc.nextInt();
		if (numero<=8) {
		return numero;
		} else  {
		return 999;
		}
	}
	
	/**
	 * Proceso usado para elegeir el ejercicio y en base a eso ejecuta una cosa u otra
	 * @return
	 */
	public static Boolean ElegirEjercicio() {
		int numero= PedirEleccion();
		Boolean miobool= false;
		switch (numero) 
        {
            case 1:  numero = 1;
            		miobool=true;
            		System.out.println("Ejercicio 1");
            		System.out.println();
            		Ejercicio1();
                     break;
            case 2:  numero = 2;
            		miobool=true;
            		System.out.println("Ejercicio 2");
            		System.out.println();
            		Ejercicio2();
            		break;
            case 3:  numero = 3;
            		miobool=true;
            		System.out.println("Ejercicio 3");
            		System.out.println();
            		Ejercicio3();
            		break;
            case 4:  numero = 4;
            		miobool=true;
            		System.out.println("Ejercicio 4");
            		System.out.println();
            		Ejercicio4();
                     break;
            case 5:  numero = 5;
            		miobool=true;
            		System.out.println("Ejercicio 5");
            		Ejercicio5();
            		System.out.println();
                     break;
            case 6:  numero = 6;
            		//miobool=true;
    				System.out.println("Ejercicio 6");
    				System.out.println();
    				Ejercicio6();
    				break;
            case 7:  numero = 7;
					System.out.println("Saliendo.....");
					System.out.println();
					salir();
					break;
   
            case 8:  numero = 999;
            		System.out.println("Intentalo de nuevo");
            		System.out.println();
            		
                   }
			return miobool;
	}
	
	///////////////////////////////ejercicios////////////////////////////////////////
	
	
	/**
	 * comportamiento para cerrar terminal
	 */
	public  static void salir() {
		//como se programa esta chingada????????
		System.exit(0);
	}
	
	
	/**
	 * Proceso de ejercicio 1, crear una carpeta
	 */
	public static void Ejercicio1() {
		String ruta;
		String nombre;
		ProcessBuilder PB;
		ProcessBuilder LS;
		Process child;
		
		
			System.out.println();
			System.out.println("Crear una carpeta dada una Ruta");
			ruta= elegirRuta();
			//nombre=ElegirNombre();
			
			
			//problema al crear la carpeta
			
			//PB= new ProcessBuilder("cmd.exe", "/c", "mkdir",nombre);
			String command = "cmd /c mkdir "+ruta;
			if (checkRuta(ruta)==false) {
		    try {
				child = Runtime.getRuntime().exec(command);
				//comprobación
				
				System.out.println();
				System.out.println("Carpeta creada, si para cosas de la escuela, siiii");
				//Print(ruta);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			} else {
				System.out.println();
				System.out.println("La carpeta ya exixte, reciclar es importante");
			}

			ElegirEjercicio();
		    //if (checkRuta(ruta)==true) {
				//System.out.println("todo ha ido bien");
			//} else {
				//System.out.println("algo ha ido mal");
			//}
		
	}
	
	/**
	 * proceso ejercicio 2, crear un fichero
	 */
	private static void Ejercicio2() {
		String ruta;
		String longitud;
		ProcessBuilder PB;
		ProcessBuilder LS;
		Process child;
		
		
			System.out.println();
			System.out.println("Crear un fichero dada una Ruta");
			ruta= elegirRuta();
			longitud=ElegirLongitud();
			
			
			//problema al crear la carpeta
			
			//PB= new ProcessBuilder("cmd.exe", "/c", "mkdir",nombre);
			String command = "fsutil file createnew"+" "+ruta+ longitud;
			if (checkRuta(ruta)==false) {
		    try {
				child = Runtime.getRuntime().exec(command);
				//comprobación
				
				System.out.println();
				System.out.println("Fichero creado, ahora a llenarlo de comida");
				//Print(ruta);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			} else {
				System.out.println();
				System.out.println("Fichero ya exixte, Intentelo mas tarde");
			}
			ElegirEjercicio();
		
	}
		
	/**
	 * proceso del ejercicio 3, Listar todas la interfaces de red de nuestro equipo
	 */
	public static void Ejercicio3() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		//Scanner misacanner;
		processBuilder.command("cmd.exe", "/c", "ipconfig /all");
		System.out.println("Listar todas las interfaces de red de nuestro ordenador");
		try {

			Process process = processBuilder.start();

			StringBuilder buffer = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// Guardamos en un buffer la salida del proceso
			String line;
			System.out.println("sus tarjetas de red son (con dirección mac):");
			System.out.println();
			while ((line = reader.readLine()) != null) {
				if (line.contains("Adaptador") || line.contains("f¡sica")) {
				buffer.append(line + "\n");
				} else {
					
				}
			}

			if (process.waitFor() == 0) {
				System.out.println(buffer);
			} else {
				System.out.println("mal");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		
		}
		ElegirEjercicio();
	}
	
	/**
	 * Comportamiento ejercicio 4, Mostrar la IP del ordenador dado el nombre de la interfaz de red
	 */
	public static void Ejercicio4() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		String nombreinter= nombre_inter();
		int cont4=1;
		String line;
		boolean encontrado=false;
		
		
		
		processBuilder.command("cmd.exe", "/c", "ipconfig /all");
		System.out.println("Mostrar la IP del ordenador dado el nombre de la interfaz de red");
		//netsh Realtek 8822CE Wireless LAN 802.11ac PCI-E NIC show interface
		try {

			Process process = processBuilder.start();

			StringBuilder buffer = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// Guardamos en un buffer la salida del proceso
			
			
			while ((line = reader.readLine()) != null) {
				
					if (line.contains(nombreinter)){
						buffer.append(line + "\n");
						encontrado=true;
					}
					if (encontrado==true && line.contains(IP) && cont4<6) {
						buffer.append(line + "\n");
						
						
					}
				}
	
					//si el buffer esta vacio, no ha encontrado nada
					if (buffer.length()==0) {
						System.out.println("Proceso finalizado, intentelo de nuevo con otra interfaz");
					}		
						
			
					
			if (process.waitFor() == 0) {
				System.out.println(buffer);
			} else {
				System.out.println("mal");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		
		}
		ElegirEjercicio();
		
	}
	
	/**
	 * comportamiento ejercicio 5, Mostrar la dirección MAC dado el nombre de la interfaz de red
	 */
	
	private static void Ejercicio5() {
		
			ProcessBuilder processBuilder = new ProcessBuilder();
			String nombreinter= nombre_inter();
			boolean unamac=false;
			String line;
			
			
			processBuilder.command("cmd.exe", "/c", "ipconfig /all");
			System.out.println("Mostrar la MAC del ordenador dado el nombre de la interfaz de red");
			//netsh Realtek 8822CE Wireless LAN 802.11ac PCI-E NIC show interface
			try {

				Process process = processBuilder.start();

				StringBuilder buffer = new StringBuilder();

				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

				// Guardamos en un buffer la salida del proceso
		
				boolean encontrado=false;
				while ((line = reader.readLine()) != null) {
					
						if (line.contains(nombreinter)){
							buffer.append(line + "\n");
							encontrado=true;
						}
						if (encontrado==true && line.contains(MAC) && unamac==false) {
							unamac=true;
							buffer.append(line + "\n");
							
						}
					}
		
						//si el buffer esta vacio, no ha encontrado nada
						if (buffer.length()==0) {
							
							System.out.println();
							System.out.println("Proceso finalizado, intentelo de nuevo con otra interfaz");
							System.out.println();
						}		
							
				
						
				if (process.waitFor() == 0) {
					System.out.println(buffer);
				} else {
					System.out.println("mal");
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			
			}
			ElegirEjercicio();
	}
	
	/**
	 * comportamiento ejercicio 6, Comporbar conectividad
	 */
	private static void Ejercicio6() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		String ip=ElegirIP();
		//String command = "cmd /c mkdir "+ruta;
		Process proceso;
		boolean conexion=false;
		processBuilder.command("cmd.exe", "/c", "ping -l 1 "+ ip);
		try {

			/*
			 * String command = "cmd /c mkdir "+ruta;
			if (checkRuta(ruta)==false) {
		    try {
				child = Runtime.getRuntime().exec(command);
			 */
			
			Process process = processBuilder.start();
			
			

			StringBuilder buffer = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			

			// Guardamos en un buffer la salida del proceso
			String line;
			while ((line = reader.readLine()) != null && conexion==false) {
				if (line.contains("perdidos = 0")) {
					conexion=true;
				}
			}

			if (conexion==true) {
				System.out.println("");
				System.out.println("Aleluya ves al resto del mundo");
				System.out.println("");
			} else {
				System.out.println("");
				System.out.println("Hello darkness my old friend... estas mas solo que la una asi no llegas a plata");
				System.out.println("");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	///////////////////////////////////////////////////////////////////////////////////
	/**
	 * Proceso usado para seleccionar la ruta
	 * @return
	 */
	private static String elegirRuta() {
		// No cierren nunca el System.in si no quieren cargarse el flujo estandar
		// (teclado)
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta donde realizar el ejercicio: ");
		return sc.nextLine();
	}
	
	private static String nombre_inter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la interfaz: ");
		return sc.nextLine();
	}
	
	/**
	 * Proceso para seleccionar longitud del archivo a crear
	 * @return
	 */
	private static String ElegirLongitud() {
		// No cierren nunca el System.in si no quieren cargarse el flujo estandar
		// (teclado)
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la longitud (bytes) del fichero a crear: ");
		return sc.nextLine();
	}
	
	/**
	 * Proceso para seleccionar ip
	 * @return
	 */
	private static String ElegirIP() {
		// No cierren nunca el System.in si no quieren cargarse el flujo estandar
		// (teclado)
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ip o el dominio: ");
		return sc.nextLine();
	}
	
	/**
	 * comportamiento para ver si exixte
	 * @param ruta
	 * @return
	 */
	private static boolean checkRuta(String ruta) {
		 return new File(ruta).exists();
	}
	
	/**
	 * Proceso usado para comprobar el resultado de un comando
	 * @param p
	 * @param PB
	 */
	private static void Print(String ruta) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("cmd.exe", "/c", "dir",ruta);
		try {

			Process process = processBuilder.start();

			StringBuilder buffer = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// Guardamos en un buffer la salida del proceso
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line + "\n");
			}

			if (process.waitFor() == 0) {
				System.out.println(buffer);
			} else {
				System.out.println("mal");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
