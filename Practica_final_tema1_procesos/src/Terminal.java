import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Terminal {

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
		numero=sc.nextInt();
		if (numero<=5) {
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
            		break;
            case 4:  numero = 4;
            		miobool=true;
            		System.out.println("Ejercicio 4");
            		System.out.println();
                     break;
            case 5:  numero = 5;
            		miobool=true;
            		System.out.println("Ejercicio 5");
            		System.out.println();
                     break;
            case 6:  numero = 999;
            		System.out.println("Intentalo de nuevo");
            		System.out.println();
            		
                   }
			return miobool;
	}
	
	
	/**
	 * Proceso de ejercicio 1
	 */
	public static void Ejercicio1() {
		String ruta;
		String nombre;
		ProcessBuilder PB;
		ProcessBuilder LS;
		Process child;
		
		
			System.out.println();
			System.out.println("Crear una carpeta dada una Ruta");
			ruta= leerRuta();
			//nombre=ElegirNombre();
			
			
			//problema al crear la carpeta
			
			//PB= new ProcessBuilder("cmd.exe", "/c", "mkdir",nombre);
			String command = "cmd /c mkdir "+ruta;
		    try {
				child = Runtime.getRuntime().exec(command);
				//comprobación
				
				
				
				//Print(ruta);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    //if (checkRuta(ruta)==true) {
				//System.out.println("todo ha ido bien");
			//} else {
				//System.out.println("algo ha ido mal");
			//}
		
	}
	
	/**
	 * proceso ejercicio 2
	 */
	private static void Ejercicio2() {
		String ruta;
		
		
		System.out.println();
		System.out.println("Crear un fichero dada una Ruta");
		ruta= leerRuta();
		
	}
	
	/**
	 * Proceso usado para seleccionar la ruta
	 * @return
	 */
	private static String leerRuta() {
		// No cierren nunca el System.in si no quieren cargarse el flujo estandar
		// (teclado)
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta donde realizar el ejercicio: ");
		return sc.nextLine();
	}
	
	/**
	 * Proceso para seleccionar nombre del archivo a crear
	 * @return
	 */
	private static String ElegirNombre() {
		// No cierren nunca el System.in si no quieren cargarse el flujo estandar
		// (teclado)
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el no nombre del fichero/carpeta a crear: ");
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
