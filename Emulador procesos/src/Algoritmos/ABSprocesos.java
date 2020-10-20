package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;

import Elementos.Proceso;

/**
 * clase comun para todos los procesos
 * @author alvar
 *
 */
public abstract class ABSprocesos {

	protected ArrayList<Proceso> procesos;
	protected ArrayList<String> listaMedias;
	
	
	/**
	 * comportamiento para mostrar las medias de los procesos
	 */
	protected void mostrarmedias() {
		
		System.out.println();
		System.out.println("Medias de los procesos:");
		System.out.println();
		Collections.sort(listaMedias);
		for (int cont=0;cont<listaMedias.size();cont++) {
			System.out.println(listaMedias.get(cont).toString());
		}
		
		
	}
}
